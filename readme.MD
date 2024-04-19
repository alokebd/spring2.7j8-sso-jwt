#Singgle Sign On (SSO) by using JWT token


#NOTE
1). The new version (Springboot 3 and Freemarker) has an issue with passing RequestParam value.

(2). It is built by using Apache FreeMarker (2.3) and Springboot 2.7.4. There are two services 
(resource and JWT auth service) and it was also noticed that sometime the template file is not
loading with this version. Not sure whether it is bug in Freemarker or Springboot (workaround 
is to restart the IDE and then run those servers (first run sso-jwt-auth and then sso-jwt-resource).

# Testing 
(1. Go to browser and hit http://localhost:8080 (this resource server, it will redirect to auth 
server. The auth server login page will be shown)
(2). The log page (built as hardcoded user and password) which is mentioned the UI.




