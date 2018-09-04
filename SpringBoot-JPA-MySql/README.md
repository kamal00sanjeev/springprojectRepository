
About:
==========
This project is used to manipulate Table data in MysqlDatabse - food<br>
Table name - restaurent, restaurent_menu, menu_items <br>
<b>restaurent</b> has a <b>Menu</b> - One-To-One mapping <br>
<b>Menu</b> has <b>Set'Item'</b> - One-To-Many mapping <br>

Execution:
==============
Check if application works fine, hit url - GET
http://localhost:8080/rest/restaurent/


See all Restaurent details present in table - GET
http://localhost:8080/rest/restaurent/all


See particular Restaurent details based on id - GET
http://localhost:8080/rest/restaurent/#id


Save a new Restaurent in DB - POST
http://localhost:8080/rest/restaurent/addnew <br>
Input data format - 
{"resturentName":"name","address":"address","contactInfo":1234567890}


Delete a Restaurent from table based on id - DELETE
http://localhost:8080/rest/restaurent/delete/#id

****************
Add Menu details to Restaurent - POST
http://localhost:8080/rest/restaurent/{restaurentId}/menu <br>
Input data format - 
{"menuName":"combo-Menu"}


See Menu details for a particular Restaurent - GET
http://localhost:8080/rest/restaurent/{restaurentId}/menu

*******************
Add a new item to menu of Restaurent - POST
http://localhost:8080/rest/restaurent/{restaurentId}/menu/item <br>
Input data format - 
{"itemName":"name","price": #double-rate,"quantity":"FULL"}


See all menu items for a Restaurent - GET
http://localhost:8080/rest/restaurent/{restaurentId}/menu-items

*********************
EhCache implementation for Restaurent details based on id - GET
http://localhost:8080/rest/restaurent/{id} <br>

Swagger:
==============
To check API info and test endpoints:  http://localhost:8080/swagger-ui.html