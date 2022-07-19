 # CRM Backend - T.A.M.



> CRM Backend created for T.A.M's recruitment proccess.
> The project is a REST API to manage a CRM Customer Data
### Base requirements

All the following base requirements were met:

- [x] API only accessible after authentication
- [x] Customer CRUD - Accessible by Regular and Admin users
- [x] Images upload management
- [x] Customer references to: Picture - Creation User - Last Update User
- [x] User CRUD - Accessible only by Admin users


### Adjustments and improvements

The project is still in development and the next updates will focus on the following tasks:

- [x] JWT authentication and authorization
- [x] OpenAPI + Swagger-ui for API documentation
- [x] Fully running on Docker
- [x] Only "2-commands" set-up
- [ ] Auto build project inside the Docker container with DevTools
- [ ] Fix /login and /token not showing in API visual documentation (swagger-ui)
- [ ] OAuth 2 authentication
- [ ] Write Unit Tests for the REST access points
- [ ] ~~Get a better computer so that DiffBlue tests generation doesn't crash my Linux~~
- [ ] Integrate Unit Tests with H2
- [ ] Decrease Maven's first-build time
- [ ] Get JWT Secret and DB access from cloud services (AWS)
- [ ] Deploy to a cloud service (Heroku)

## 💻 Prerequisites

Before starting, make sure you've met the following requirements:
* You have `docker` installed
* You have `docker-component` installed
* You have read the `getting started` guide.

## 🚀 Getting Started

To install the CRM API and get it running, follow these steps:

Linux (and MacOS?):

Clone the repo (or download the .ZIP file and extract it):
```
git clone https://github.com/aufgfua/CRM-Backend-AM main
```

Enter the project folder:
```
cd CRM-Backend-AM
```

Create the Docker Image:
```
docker build -t crm-api .
```

Run the project:
```
docker-component up
```

Windows:

Download Git Bash and run the commands above.


## ☕ Using the CRM API

> All the API paths, methods, and expected inputs can be visually seen from `http://localhost:8080/swagger-ui/index.html`.
> A JSON with the paths is also available through `http://localhost:8080/api-docs/`


Notes:
```
Login currently needs to be done manually from another source (postman, curl, etc...). 
OpenAPI does not support JWT login, only authentication
As a requisite, User CRUD is only accessible by Admin users.
All CRM api functionalities are accessible through the path /api/_
```

To use the CRM API, you need to authenticate first.
By default (as there is no auto registration involved), the system creates a predefined Admin user.
The username is `admin`, and the password is set inside the `.env` file ("example" by default).

To authenticate, the default spring security path is used (so the `username` and `password` should be sent as `x-www-form-urlencoded`):
```
POST -> http://localhost:8080/login
```

The server will answer with a JSON:
```
{
    "access_token": access_token,
    "refresh_token": refresh_token
}
```

Any request sent to the API needs to pass the access_token in its header in the following format:
```
"Authorization": "Bearer "+access_token
```

The `access_token` has a default duration of 10 minutes, and the `refresh_token` has a duration of 15 days.
After the access token is expired, a request must be sent to:
```
GET -> http://localhost:8080/token/refresh
Authorization: "Bearer " + refresh_token
```
! Notice that the `refresh_token` should be passed this time.
The server will answer with the same previous format, with a new access_token (and a new refresh_token too).
That way, the user will only be logged out after 15 days of non-use.

Again, after having the token, all requests can be tested and visually understood through `http://localhost:8080/swagger-ui/index.html`
If preferred, a JSON with the available paths can be get through `http://localhost:8080/api-docs/`



## 📫 Contributing to the project

To contribute to the CRM API project, follow these steps

1. Hire me.

(I am so sorry, but I could not help myself 😂)

## 🤝 Collaborators

We thank the following people who contributed to this project.

* All code was created by Augusto Flach <github.com/aufgfua>
* All requisites were created by T.A.M's team, and they provided all the support needed to develop the application.

For now I am referring to them by their nickname, to avoid exposing their recruitment proccess or any protected data.
If allowed, I will be giving them their credits.



### And if you got until here, thank you for your attention, patience and support!



## 📝 License

Anyone can use any piece of code created by Augusto Flach for this project.
No need to ask.
But I'll be happy to know if someone does so!

[⬆ Back to the top ](#CRM Backend - T.A.M.)<br>
