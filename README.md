# Запуск автоматизированных тестов в Jenkins <img alt="Jenkins" height="25" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" width="25"/></a>

## <a>**Задача:**</a>
1. Разработать автотесты на проверку [формы](https://demoqa.com/automation-practice-form):
- Реализовать тесты на **Page Object Model**
- Использовать аннотации **JUnit5**
- Добавить генерацию тестовых данных с помощью библиотеки **Faker**
3. Добавить в проект **Allure Report** и аттачи для него – скриншот, page source, console.log и видео

4. Настроить запуск теста в **Jenkins**
- Cделать сборку 
- Передать адрес удаленного браузера (**Selenoid**)
- Сделать возможность выбора браузера и разрешения
5. Добавить уведомления о результатах прохождении автотестов с помощью **Telegram-бота**

## <img alt="Jenkins" height="25" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" width="25"/></a><a name="Сборка в Jenkins"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C27-universe_data_ui_tests/)</a>

<p align="center">  
<img title="Jenkins" src="images/screenshots/jenkins.png" width="850">  
</p>

## <img alt="Allure" height="25" src="https://github.com/ozhegov/universe_data_ui_tests/blob/main/images/logo/Allure.svg" width="25"/></a><a name="Интеграция с Allure Report"></a>Интеграция с [Allure Report](https://jenkins.autotests.cloud/job/C27-universe_data_ui_tests/allure/)</a>

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Report" src="images/screenshots/allure.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Test Cases" src="images/screenshots/allure_tc.png" width="850">  
</p>

## <img alt="Telegram" height="25" src="https://upload.wikimedia.org/wikipedia/commons/8/83/Telegram_2019_Logo.svg" width="25"/></a><a name="Уведомления в Telegram при помощи бота"></a>Уведомления в Telegram при помощи бота</a>
<p align="center">  
<img title="Telegram Notifications" src="images/screenshots/telegram.jpg" width="450">  
</p>
