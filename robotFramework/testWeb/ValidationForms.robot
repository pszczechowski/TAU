*** Settings ***
Library  SeleniumLibrary

*** Variables ***
${BROWSER}   firefox
${SELSPEED}  0.0s

*** Test Cases ***
validation_Forms
    [Setup]  Run Keywords  Open Browser  http://automationpractice.com/index.php  ${BROWSER}
    ...              AND   Set Selenium Speed  ${SELSPEED}
    # open    http://automationpractice.com/index.php
    click    link=Sign in
    click    id=email_create
    type    id=email_create    test321@test4.pl
    captureEntirePageScreenshot
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]
    click    id=id_gender1
    click    id=customer_firstname
    type    id=customer_firstname    Piotr
    click    id=customer_lastname
    type    id=customer_lastname    Piotr
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='T-shirts'])[2]/following::div[1]
    captureEntirePageScreenshot
    click    id=passwd
    type    id=passwd    Test123
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='T-shirts'])[2]/following::div[1]
    select    id=days    regexp:17\s+
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::option[18]
    select    id=months    regexp:June\s
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::option[39]
    click    id=years
    select    id=years    regexp:2008\s+
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::option[58]
    click    id=newsletter
    click    id=firstname
    type    id=firstname    Piotr
    click    id=address1
    click    id=address1
    type    id=address1    Dluga
    click    id=address2
    click    id=city
    type    id=city    Gdansk
    click    id=id_state
    select    id=id_state    Connecticut
    click    id=postcode
    type    id=postcode    80800
    click    id=other
    type    id=other    Test
    click    id=phone_mobile
    click    id=phone_mobile
    type    id=phone_mobile    123123123
    click    id=alias
    type    id=alias    Adress
    captureEntirePageScreenshot
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='T-shirts'])[2]/following::div[1]
    [Teardown]  Close Browser

*** Keywords ***
open
    [Arguments]    ${element}
    Go To          ${element}

clickAndWait
    [Arguments]    ${element}
    Click Element  ${element}

click
    [Arguments]    ${element}
    Click Element  ${element}

sendKeys
    [Arguments]    ${element}    ${value}
    Press Keys     ${element}    ${value}

submit
    [Arguments]    ${element}
    Submit Form    ${element}

type
    [Arguments]    ${element}    ${value}
    Input Text     ${element}    ${value}

selectAndWait
    [Arguments]        ${element}  ${value}
    Select From List   ${element}  ${value}

select
    [Arguments]        ${element}  ${value}
    Select From List   ${element}  ${value}

verifyValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

verifyText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

verifyElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

verifyVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

verifyTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

verifyTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertConfirmation
    [Arguments]                  ${value}
    Alert Should Be Present      ${value}

assertText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

assertVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

assertTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

assertTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

waitForVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

waitForTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

waitForTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

doubleClick
    [Arguments]           ${element}
    Double Click Element  ${element}

doubleClickAndWait
    [Arguments]           ${element}
    Double Click Element  ${element}

goBack
    Go Back

goBackAndWait
    Go Back

runScript
    [Arguments]         ${code}
    Execute Javascript  ${code}

runScriptAndWait
    [Arguments]         ${code}
    Execute Javascript  ${code}

setSpeed
    [Arguments]           ${value}
    Set Selenium Timeout  ${value}

setSpeedAndWait
    [Arguments]           ${value}
    Set Selenium Timeout  ${value}

verifyAlert
    [Arguments]              ${value}
    Alert Should Be Present  ${value}
