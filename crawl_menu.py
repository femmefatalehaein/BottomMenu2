import requests
import pandas as pd
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import NoSuchElementException, StaleElementReferenceException
import csv

# Function to retrieve restaurants using Kakao API
def get_restaurants(center_x, center_y, radius):
    url = 'https://dapi.kakao.com/v2/local/search/category.json'
    params = {
        'category_group_code': 'FD6',
        'x': center_x,
        'y': center_y,
        'radius': radius
    }
    headers = {"Authorization": "KakaoAK f3b121a900d2f12872ba8c70acff4995"}
    all_data_list = []
    page = 1
   
    while True:
        params['page'] = page
        resp = requests.get(url, params=params, headers=headers)
        data = resp.json()
        all_data_list.extend(data['documents'])
      
        if data['meta']['is_end']:
            break
      
        page += 1
   
    return all_data_list

# Retrieve restaurant data using Kakao API
deokseong_lat = 37.652565
deokseong_lng = 127.016343
radius = 1000
restaurants = get_restaurants(deokseong_lng, deokseong_lat, radius)

# Process and save restaurant data
stores = []
ID = []
for place in restaurants:
    stores.append(place['place_name'])
    ID.append(place['id'])

df = pd.DataFrame({'ID': ID, 'stores': stores})
df.to_csv('menus.csv', index=False)
print('Total number of restaurants:', len(df))
print(df)

data = pd.read_csv('menus.csv')

restaurant_names = data['stores']
chrome_options = Options()
chrome_options.add_experimental_option("detach", True)

driver = webdriver.Chrome(options=chrome_options)
driver.get("https://map.naver.com/v5/")

try:
    element = WebDriverWait(driver, 306).until(
        EC.presence_of_element_located((By.CLASS_NAME, "input_search"))
    )
finally:
    pass

all_menu_texts = []
all_price_texts = []

for restaurant_name in restaurant_names[:3]:
    try:
        search_box = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.CLASS_NAME, "input_search")))
        search_box.send_keys(restaurant_name)
        search_box.send_keys(Keys.ENTER)
        time.sleep(7)
      
        search_frame_present = False
        try:
            frame = driver.find_element(By.CSS_SELECTOR, "iframe#searchIframe")
            driver.switch_to.frame(frame)
            search_frame_present = True
        except NoSuchElementException:
            pass
      
        if search_frame_present:
            time.sleep(3)
            try:
                search_element = driver.find_element(By.XPATH, '//*[@id="_pcmap_list_scroll_container"]/ul/li[1]/div[1]/div[2]/a[1]/div/div/span[1]')
                ActionChains(driver).move_to_element(search_element).click().perform()
                time.sleep(5)
                current_window_handle = driver.current_window_handle
                driver.switch_to.window(driver.window_handles[-1])
                WebDriverWait(driver, 10).until(
                    EC.frame_to_be_available_and_switch_to_it((By.CSS_SELECTOR, "iframe#entryIframe")))
            except NoSuchElementException:
                pass
        else:
            entry_frame = driver.find_element(By.CSS_SELECTOR, "iframe#entryIframe")
            driver.switch_to.frame(entry_frame)
      
        menu_found = False
        menu_texts = []
        price_texts = []

        menuclick = driver.find_elements(By.CSS_SELECTOR, ".veBoZ")

        for item in menuclick:
            if "메뉴" in item.text:
                item.click()
                menus = driver.find_elements(By.CSS_SELECTOR, ".meDTN .yQlqY")
                prices = driver.find_elements(By.CSS_SELECTOR, ".GXS1X")
                for menu, price in zip(menus, prices):
                    print(menu.text, "\t", price.text)
                    menu_found = True
                    menu_texts.append(menu.text)
                    price_texts.append(price.text)

        if not menu_found:
            menu_texts.append('메뉴 안나와있음')
            price_texts.append('가격 안나와있음')

        all_menu_texts.extend(menu_texts)
        all_price_texts.extend(price_texts)
      
        driver.switch_to.default_content()
        deletebox = driver.find_element(By.CLASS_NAME, "button_clear")
        deletebox.click()
   
    except NoSuchElementException:
        pass

with open('menu_prices_test.csv', mode='w', encoding='utf-8-sig', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['menus', 'prices'])
    for menu, price in zip(all_menu_texts, all_price_texts):
        writer.writerow([menu, price])