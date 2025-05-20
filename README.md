**How to set up the project**
<br><br>
We will need to create an user called "prueba" with the password "12345" on our MySQL instance and grant it permissions to read, create, update and delete registries using the commands found below, alternatively we can modify the "application.properties" file to configure our own username and password combo:
<br><br><br>
*CREATE USER 'prueba'@'localhost' IDENTIFIED BY '12345';*
<br><br>
*GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on \*.\* TO 'prueba'@'localhost' WITH GRANT OPTION;*
<br><br><br>
A database named "SpringBootActivityFive" is also required, we can create it using the following command:
<br><br><br>
*CREATE DATABASE SpringBootActivityFive;*
<br><br><br>
It's not necessary to create the database tables manually, as the application will do it automatically, however it's required that we insert these values in the "roles" table before using the application as otherwise it would not run correctly:
<br><br><br>
*INSERT INTO roles(name) VALUES('ROLE_USER');*
<br>
*INSERT INTO roles(name) VALUES('ROLE_MODERATOR');*
<br>
*INSERT INTO roles(name) VALUES('ROLE_ADMIN');*
<br><br><br>
**How to run the application**
<br><br>
The application runs on port 8080, it will require authentication to access almost all the endpoints, therefore first it will be necessary that we register an user and then we login with said user.
<br><br><br>
The application uses JWT tokens that will be returned in a cookie when a login request is succesful, reducing the need to consistently authenticate ourselves for future requests, at least until the token expires.
<br><br><br>
There are three types of endpoints, public information endpoints that won't require any type of authentication, secret information endpoints that will require an authorized user with the "user" or "admin" role and super secret information endpoints that will work exclusively with an authorized user with an "admin" role.
<br><br><br>
**API endpoints and sample requests for testing**
<br><br>
The application has three authentication endpoints:
<br><br><br>
*POST /api/auth/signup*
<br><br><br>
We can use it to register new users by sending a request body with the properties of an uesr object, as presented below:
<br><br><br>
{
"username": "BartSimpson25",
"email": "futurama@gmail.com",
"password": "aycaramba",
"role": ["user"]
}
<br><br><br>
We can't have two users with the same username or email, note that we are sending a roles array therefore an user can have multiple roles
<br><br><br>
*POST /api/auth/signin*
<br><br><br>
We can use it to login with a registered user by sending a request body its credentials, as presented below:
<br><br><br>
*{*
*"username": "BartSimpson25",*
*"password": "aycaramba"*
*}*
<br><br><br>
This will return us a cookie with a JWT token to authenticate ourselves in further requests
<br><br><br>
*POST /api/auth/signout*
<br><br><br>
We can use it to logout an already authenticated user, this will invalidate the cookie with its JWT token as it will expire automatically
<br><br><br>
The application also has six functional endpoints
<br><br><br>
*GET /api/test/public-info*
<br><br><br>
This will return a list with all the public info registered in the "public_info" table (No authentication required)
<br><br><br>
*POST /api/test/public-info*
<br><br><br>
We can send a request body with the properties of a publicInfo object to create and insert it in the "public_info" table as presented below (No authentication required):
<br><br><br>
{
"id": 1,
"message": "Hello"
}
<br><br><br>
*GET /api/test/secret-info*
<br><br><br>
This will return a list with all the secret info registered in the "secret_info" table (Authentication with an "user" or "admin" role required)
<br><br><br>
*POST /api/test/secret-info*
<br><br><br>
We can send a request body with the properties of a secretInfo object to create and insert it in the "secret_info" table as presented below (Authentication with an "user" or "admin" role required)
<br><br><br>
{
"id": 1,
"message": "Secret hello"
}
<br><br><br>
*GET /api/test/super-secret-info*
<br><br><br>
This will return a list with all the super secret info registered in the "super_secret_info" table (Authentication with an "admin" role required)
<br><br><br>
*POST /api/test/super-secret-info*
<br><br><br>
We can send a request body with the properties of a superSecretInfo object to create and insert it in the "super_secret_info" table as presented below (Authentication with an "admin" role required)
<br><br><br>
{
"id": 1,
"message": "Super secret hello"
}
