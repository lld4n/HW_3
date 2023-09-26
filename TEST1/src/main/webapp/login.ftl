<html lang="ru">
<#include "base.ftl">

<#macro title>Авторизация</#macro>

<#macro main__title>Авторизация</#macro>

<#macro main__content>
    <p>Пример логина и пароля для теста: LOGIN = "lldan" и PASSWORD = "itis"</p>
    <form action="login" method="post">
        <label>
            <div>Логин:</div>
            <input type="text" name="login">
        </label>
        <label>
            <div>Пароль:</div>
            <input type="password" name="password">
        </label>


        <input type="submit" value="Войти">
    </form>

</#macro>

</html>