TP effectué par Nicolas BUISSET et Sarah ZAIEM

API REST : Gestion de Librairie
Ce projet est une API REST développée sous **Spring Boot (Java 21)** pour gérer les entités `Livre` et `Auteur`.
L'API supporte les opérations **CRUD** complètes (Création, Lecture, Mise à jour, Suppression) pour la ressource `Book` et les routes principales pour `Author`.

1. Lancement du Projet
  * Java JDK 21
  * MySQL (base de données nécessaire)
  * IntelliJ IDEA

**Étapes de Démarrage :**
  1.  **Base de Données :** Importer le fichier SQL fourni (`votre_base_de_donnees.sql`) dans votre serveur MySQL.
  2.  **Configuration :** Dans `src/main/resources/application.properties`, s'assurer que les identifiants MySQL (utilisateur et mot de passe) sont corrects.
  3.  **Lancement :** Démarrer l'application via IntelliJ en exécutant la classe principale **`LibraryApplication.java`**.

L'application sera lancée sur le port **8080**.


2. Architecture et Points Clés du Code

Le projet est organisé en couches standard (Controller → Service → Repository).
  **Intégrité des Données :** Le service vérifie toujours l'existence de l'Auteur (`authorId`) avant de créer ou de modifier un Livre.
  **Gestion d'Erreur :** En cas de tentative d'accès à une ressource non trouvée (ex: `GET /books/999`), l'API retourne un statut clair **404 Not Found**.
  **Validation :** Des DTOs sont utilisés pour structurer les requêtes `POST` et `PUT`, intégrant des validations comme l'unicité de l'ISBN.


3. Endpoints (Routes de l'API)

Toutes les routes sont testables via le fichier d'export Postman fourni.

| Rôle | Méthode | Endpoint | Description 
| :---: | :---: | :---: | :---: 
| Création | `POST` | `/authors` | Crée un auteur. 
| Création | `POST` | `/books` | Crée un livre (avec liaison `authorId`). 
| Lecture | `GET` | `/books/{id}` | Lit un livre par ID. 
| Lecture | `GET` | `/books` | Lit tous les livres. 
| Modification | `PUT` | `/books/{id}` | Met à jour un livre. 
| Suppression | `DELETE` | `/books/{id}` | Supprime un livre. 



4. Livraison

Ce projet est livré sous forme d'une archive contenant :
1.  Le code source complet (dossier IntelliJ).
2.  Le fichier `README.md`.
3.  L'export de la base de données.
4.  L'export de la collection Postman .
