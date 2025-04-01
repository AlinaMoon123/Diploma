# Diploma

В репозитории проект с фреймворком лежит в каталоге framework.

* В данный файл внесите свои данные для входа в ЛК ЛЭТИ для запуска тестов.
framework\src\test\resources\config.properties

## Запуск тестов
* Для запуска всех тестов: mvn test
* Для запуска тестов только для сайта ЛЭТИ: mvn test -Dgroups=leti
* Для запуска тестов только для сайта hh.ru: mvn test -Dgroups=hh