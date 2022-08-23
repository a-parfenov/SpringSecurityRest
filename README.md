# SpringSecurityRest

Приложения c авторизацией и правами доступа на основе ролей на стеке:

```Spring Boot, Spring Security, REST, Maven, Java 8 Stream API```

------------

Проект выполнен на основе трех последовательных заданий:
1) Реализация сохранения в базу ```MySQL```, ```JPA(Hibernate)```
2) Реализация клиента на ```Bootstrap (js)```
3) Реализация ```REST``` и ```AJAX``` контроллеров

#### Скриншоты:
<p float="left">
  <img width="1440" alt="Снимок экрана 2022-08-21 в 12 00 52" src="https://user-images.githubusercontent.com/86875207/186187038-5e5c26fd-5641-4e22-9d0b-4d76a012de50.png">
  <img width="1440" alt="Снимок экрана 2022-08-21 в 12 01 12" src="https://user-images.githubusercontent.com/86875207/186187160-a88b5ea9-dc42-492e-8d3b-a78837922852.png">
</p>
<p float="left">
  <img width="1440" alt="Снимок экрана 2022-08-21 в 12 01 31" src="https://user-images.githubusercontent.com/86875207/186187214-2e7c2135-9960-4ff1-bf1c-094d1413fc84.png">
  <img width="1440" alt="Снимок экрана 2022-08-21 в 12 01 45" src="https://user-images.githubusercontent.com/86875207/186187239-8227b3aa-27c0-4bde-a3f0-eca457b6e776.png">
</p>

------------

### Задание 1

Модуль Spring Security позволяет нам внедрять права доступа, а также контролировать их исполнение без ручных проверок.
Spring Security базируется на 2х интерфейсах, которые определяют связь сущностей с секьюрностью: UserDetails и GrantedAuthority.
UserDetails - то, что будет интерпретироваться системой как пользователь.
GrantedAuthority - сущность, описывающая права юзера.
Оба эти интерфейса имеют множество реализаций: просмотрите класс WebSecurityConfig, в методе configure() с помощью настроек userDetailsService() мы собираем единственный на всю программу экземпляр UserDetails с именем и паролем user , а его роль “USER” так же будет преобразована в экземпляр GrantedAuthority.

Так же мы можем использовать jdbc-аутентификацию путем написания запроса, возвращающего пользователя и роль.
Как вы понимаете, такие способы максимально просты, но лишены достаточной гибкости, потому наиболее часто используемый вариант настройки выглядит как имплементация UserDetails и GrantedAuthority в классах-сущностях с переопределением существующих методов.

Рассмотрим приложение.
Новые классы:
- WebSecurityConfig- настройка секьюрности по определенным URL, а также настройка UserDetails и GrantedAuthority.
- LoginSuccessHandler - хэндлер, содержащий в себе алгоритм действий при успешной аутентификации. Например, тут мы можем отправить пользователя с ролью админа на админку после логина, а с ролью юзер на главную страницу сайта и т.п.

1. Перенесите классы и зависимости из предыдущей задачи.
2. Создайте класс Role и свяжите User с ролями так, чтобы юзер мог иметь несколько ролей.
3. Имплементируйте модели Role и User интерфейсами GrantedAuthority и UserDetails соответственно. Измените настройку секьюрности с inMemory на userDetailService.
4. Все CRUD-операции и страницы для них должны быть доступны только пользователю с ролью admin по url: /admin/.
5. Пользователь с ролью user должен иметь доступ только к своей домашней странице /user, где выводятся его данные. Доступ к этой странице должен быть только у пользователей с ролью user и admin. Не забывайте про несколько ролей у пользователя!
6. Настройте logout с любой страницы с использованием возможностей thymeleaf.
7. Настройте LoginSuccessHandler так, чтобы админа после аутентификации направляло на страницу /admin, а юзера на его страницу /user.

### Задание 2

Реализовать отображение страниц используя Bootstrap

### Задание 3

1. Написать Rest-контроллеры для вашего приложения.
2. Переписать вывод (заполнение) таблицы, модальных окон и т.д. на JS c помощью Fetch API, допускается использование JQuery.
3. При любых изменениях данных страница приложения не должна перезагружаться!