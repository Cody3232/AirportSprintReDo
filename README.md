Airport Sprint ReDo

This project is a supplementary sprint assignment for Keyin College Software Development.
It demonstrates a full-stack application built with Java Spring Boot (backend) and React (frontend).

Project Overview

The goal of the sprint was to build an API with CRUD operations, model several relationships, and provide a frontend that answers four specific questions using GET requests.

Entities

City – has many airports

Airport – belongs to one city, can be used by many aircraft

Passenger – belongs to one city, can fly on many aircraft

Aircraft – belongs to one airline, can fly to/from many airports, and carry many passengers

Airline (extra entity, added for realism) – has many aircraft

Relationships

A City has many Airports

A Passenger lives in one City and can fly on many Aircraft

An Aircraft can carry many Passengers and use many Airports

An Airport belongs to one City

Questions Answered (Frontend)

What airports are there in each city?

What aircraft has each passenger flown on?

What airports do aircraft take off from and land at?

What airports have passengers used?

Tech Stack

Backend: Java 21, Spring Boot 3.2, MySQL, JPA/Hibernate

Frontend: React (Vite), JavaScript, CSS

Database: MySQL (with Docker Compose for setup)

How to Run
Backend
# start MySQL via Docker
docker compose up -d

# run Spring Boot app
mvn spring-boot:run


Backend runs on http://localhost:8080

Frontend
cd frontend
npm install
npm run dev


Frontend runs on http://localhost:5173

Notes

Airline entity was added beyond requirements as an extension.

The backend supports full CRUD (GET, POST, PUT, DELETE).

The frontend focuses on answering the four required GET questions.
