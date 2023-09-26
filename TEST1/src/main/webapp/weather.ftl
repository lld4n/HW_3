<html lang="ru">
<#include "base.ftl">

<#macro title>Погода</#macro>

<#macro main__title>
    Результаты
</#macro>

<#macro main__content>
    <div>
        <b>
            Town:
        </b>
        <#if townName?has_content>
            ${townName}
        </#if>
        <br>
        <b>
            Temperature:
        </b>
        <#if temperature?has_content>
            ${temperature}
        </#if>
        <br>
        <b>
            Humidity:
        </b>
        <#if humidity?has_content>
            ${humidity}
        </#if>
        <br>
        <b>
            Precipitation:
        </b>
        <#if precipitation?has_content>
            ${precipitation}
        </#if>
    </div>
</#macro>

</html>