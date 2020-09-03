# Это просто тестовое задание
> Программа открывает facebok, находит по заданному вами слову все группы, где
> есть совпадения и заносит в базу данных их мия, кол-во подписчиков, частоту 
> обновления постов
### Важно!
Программе для запуска нужны email и password от настоящего аккауния на facebook. 
Как и куда их нужно записать описано в инструкции ниже.
## КАК ЗАПУСТИТЬ
* Клонируйте репозиторий к себе на комрьютер:
  * ```git clone https://github.com/nik-kita/casino.git```
* Перейдите в папку проекта:
  * ```cd casino```
* Откройте файл **fb.credentials** и запишите свой email password и слово, по которому будут отбираться круппы (в файле есть пример как это сделать... ничего сложного)
* Запуск программы:
  * ```mvn clean test -Dsurefire.suiteXmlFiles=testng.xml```
    * После первого запуска сгенерируется файл **fb_info.db** для SQLite. Можно открыть специальной утилитой и просмотреть записи. Но впринципе, перед закрытием
    программа вычитает все результаты с базы, которые только что туда записала и выведет их в консоль.
    
