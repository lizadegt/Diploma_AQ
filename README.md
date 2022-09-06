#Дипломный проект профессии «Тестировщик»
Дипломный проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

<img width="647" alt="service" src="https://user-images.githubusercontent.com/85506686/188310337-b0834a4f-cfc5-484b-a9d5-510ccb741138.png">

О сервисе:
Приложение педставляет собой веб-сервис и предлагает купить тур по определённой цене с помощью двух способов:
1. Обычная оплата по дебетовой карте

   <img width="654" alt="pay" src="https://user-images.githubusercontent.com/85506686/188310342-0f61b8f5-35fb-486a-ab32-a183c53d50be.png">
   
2. Уникальная технология: выдача кредита по данным банковской карты
  <img width="654" alt="credit" src="https://user-images.githubusercontent.com/85506686/188310380-0c43e12d-3349-4ddc-8679-bb4a7579bd9f.png">


Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
- сервису платежей;
- кредитному сервису.

Документация
1. План автоматизации
2. Отчётные документы по итогам тестирования
3. Отчётные документы по итогам автоматизации

###Необходимое ПО:
1. [IntelliJ Idea](https://www.jetbrains.com/ru-ru/idea/download/#section=windows) 
2. [Docker](https://www.docker.com/products/docker-desktop/) 

###Запуск 
1. Скачать проект с удаленного репозитория на локальный компьютер, с помощью команды `git clone https://github.com/lizadegt/Diploma_AQ`
2. Запустить Docker 
3. Запустить контейнер командой `docker-compose up --build`
4. Запустить SUT для одной из двух баз:
   - для mysql `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`
   - для postgresql `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`
5. При желании, можно открыть в браузере сам сервис по url: [http://localhost:8080/]()
6. Для запуска тестов ввести следуюющую команду: 
 - для mysql `gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`
 - для postgresql `gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"`
Если в ответ сообщение "zsh: command not found: gradlew", то введите следующую команду:
 - для mysql `./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`
 - для postgresql `./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"`
7. Для формирования и просмотра отчета о прохождении тестов, введите следующие команда:
   - `gradlew allureReport (./gradlew allureReport)`
   - `gradlew allureServe (./gradlew allureServe)`
8. Для завершения работы SUT, необходимо в терминале, где был запущен SUT нажать на комбинацию клавищ Ctrl+C
9. Для остановки работы контейнеров, необходимо ввести команду `docker-compose down`


