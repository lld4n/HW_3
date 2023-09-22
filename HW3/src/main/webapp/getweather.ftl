<html lang="ru">
<#include "base.ftl">

<#macro title>Получение погоды</#macro>

<#macro main__title>Получение погоды</#macro>

<#macro main__content>
    <p>Пример города: </p>
    <form action="getweather" method="post">
        <label>
            <div>Город:</div>
            <input type="text" name="town">
        </label>


        <input type="submit" value="Получить погоду">
    </form>

</#macro>

</html>