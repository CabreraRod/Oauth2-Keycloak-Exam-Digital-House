# Oauth2-Keycloak-Exam-Digital-House
Online Movie system develop with Spring microservices , IAM (Keycloak) with OAuth2 
![image](https://user-images.githubusercontent.com/29583728/202910484-bc63f527-a3f8-41b4-ad6b-b55bcca0e52b.png)
Requirements:
*Unique identification and centralized user validation.

*Management of consistent roles according to the business logic of the application.

*Effective management of a user session.

*Manage logged in users to disable them in the event of incorrect behavior.

*Secure communication between the microservices of the solution.

*User identification standard among all services.

*Possibility of user identification through social networks.

*Reduce the use of the database to obtain trivial user information.

*Uniquely identify all applications that use the movie system APIS.

*Discriminate users according to type of service, to avoid loss of billing by allowing common users to view premium movies.

#1 Initialize docker container to deploy keycloak on port 8082

    - docker run -p 8082:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev
    
#2 Import realm settings in keycloak interface 

    - add realm -> import 'realm export (4)'
    
#3 Create 3 Users in Keycloak (Keycloak dosen't export users configurations"

  - 1 admin user
  - 1 provider user
  - 1 client user

