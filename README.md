# PuppyFriend Backend - Sistema èer la Gestione delle Adozioni e Cure Veterinarie

## 🐾 Panoramica del Progetto
Questo progetto è un'applicazione backend sviluppata con Spring Boot per facilitare la gestione di rifugi per animali, il processo di adozione e il tracciamento delle visite veterinarie.
L'applicazione implementa un sistema di sicurezza basato su **JWT**, integrazioni con API di terze parti (Cloudinary per le immagini e SMTP per le notifiche email) e una gestione complessa del dominio con 9 tabelle relazionali

## Configurazione Ambiente
Crea un file `application.properties` (o modifica quello esistente in `src/main/resources`) inserendo le tue credenziali:

## Requisiti e Setup
Per avviare il progetto localmente, assicurati di avere installato:
* Java 17 o superiore
* Maven
* PostgreSQL

## Funzionalità Principali
* **Gestione Utenti & Auth**: Registrazione e login basati su **JWT**. Gestione dei profili utente inclusa l'immagine del profilo tramite integrazione con **Cloudinary**.
* **Sistema di Ruoli**: Implementazione di ruoli distinti (`USER`, `ADMIN`) con diversi livelli di accesso.
* **Gestione Animali**: Monitoraggio completo (Taglia, Specie, Stato di salute)
* **Servizio Medico**: Gestione delle visite veterinarie (`VetVisit`) e delle vaccinazioni (`Vaccination`) associate a ogni animale.
* **Notifiche Email**: Invio automatico di email per conferme di registrazione `EmailService`.

## Tecnologie Utilizzate
* **Java 17 / Spring Boot 3.x**
* **Spring Security & JWT** (Stateless authentication)
* **PostgreSQL** (Database Relazionale)
* **Spring Data JPA**
* **Cloudinary API** (Gestione immagini)
* **Maven** (Dependency Management)

## Struttura del Database
Il modello di dominio è composto da **8 tabelle principali** interconnesse:
1. `users`: Dati personali e credenziali.
2. `roles`: Definizione dei permessi.
3. `animals`: Anagrafica degli animali.
4. `sizes`: Classificazione taglie.
5. `medical_records`: Cartella clinica principale.
6. `vaccinations`: Registro dei vaccini.
7. `vet_visits`: Registro delle visite mediche.
8. `adoption_requests`: Gestione delle domande di adozione.
9. `users_roles`: Tabella di giunzione per la gestione dei ruoli.

## Variabili d'Ambiente Necessarie
Per far funzionare l'applicazione, configura le seguenti variabili nel tuo file `application.properties` o come variabili di sistema:

```properties
# Database
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/nome_db
SPRING_DATASOURCE_USERNAME= username
SPRING_DATASOURCE_PASSWORD= password

# JWT
JWT_SECRET= chiave_32bit
JWT_EXPIRATION= 86400000

# Cloudinary API (Immagini Profilo)
cloudinary.cloud_name= username
cloudinary.api_key= chiave_pubblica 
cloudinary.api_secret= chiave_privata 

# Mailtrap
SPRING_MAIL_HOST= sandbox.smtp.mailtrap.io
SPRING.MAIL.PORT=2525
SPRING_MAIL_USERNAME= username
SPRING_MAIL_PASSWORD= password
```

## Istruzioni per l'Avvio:
* Clona il repository:
```bash
mvn spring-boot:run
npm install
git clone https://github.com/user/repo.git
```
* Esegui
  ```bash
  mvn clean install 
  ```
  per scaricare le dipendenze.
* Configura il database PostgreSQL.
* Esegui il build con Maven: mvn clean install.
* Avvia l'app:
 ```bash
 mvn spring-boot:run
```
## Testing con Postman
All'interno del progetto è presente la collezione Postman
