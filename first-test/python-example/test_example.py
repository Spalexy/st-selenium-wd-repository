import pytest
from selenium import webdriver

@pytest.fixture
def driver(request):
    wd = webdriver.Chrome()
    request.addfinalizer(wd.quit)
    return wd


def test_example(driver):
    driver.get("http://ya.ru/")
    driver.refresh()
    driver.refresh()
    driver.find_element_by_name("text").send_keys("webdriver")
    driver.refresh()
    driver.refresh()

