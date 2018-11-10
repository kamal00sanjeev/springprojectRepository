Test:
===========
Enables https using SSL certificate
Run the application
https://localhost:8443/home

SSL configuration is present in application.properties file with .jks file

Command to generate .jks file:

keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass changeit -storepass changeit -keystore ssl-server.jks