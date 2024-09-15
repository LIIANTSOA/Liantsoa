# PROJET DE GESTION FINANCIERE

## Fonctionnalité
- Ajout d'actif et passif 
- Ajout des dettes et capitaux 
- Analyse des ratios 
    - $Liquidité = actif/passif$
    
## Technologie
### Postgres 
POSTGRESQL, également connu sous le nom de POSTGRES, est une base de données relationnelle (SGBDR), ce qui signifie qu'elle présente une structure de données organisée. C'est une base de données open source reconnue pour sa robustesse et ses fonctionnalités avancées.

    La particularité de POSTGRES réside dans son extensibilité, offrant la possibilité de créer des extensions personnalisées. Cette caractéristique représente un avantage significatif pour notre projet, nous permettant d'adapter la base de données à nos besoins spécifiques de manière flexible et personnalisée.

### SPRING BOOT (JAVA)
SPRING BOOT est un framework web de JAVA, léger et open source, développé par SPRING. Il s'avère particulièrement utile pour la création d'applications web et de micro-services.

    SPRING BOOT, étant multithread, a la capacité de traiter plusieurs services simultanément. Cette caractéristique revêt une importance particulière pour notre projet, étant donné qu'il sera utilisé par plusieurs clients simultanément

*Pour plus de détails, [Voir le fiche technique](docs/fiche_technique.pdf)* 


## Environnement
### POSTGRES
- Installez et configurez postgres 14
- Ouvrir sql shell (psql)
- Copié le script SQL dans le dossier `src/database/script.sql`

### JAVA
- Installer JDK 17
- Ouvrir le dossier bin contenu dans JDK 17 et copié le chemin vers bin qui devrait etre en format `C:\Program Files\Java\jdk-17\bin`
- Copié ce chemin dans le `Path` dans les variables d'environnement

### SPIRNG BOOT
- Ouvrir le fichier `application.properties` dans le chemin suivant `src/src/main/resources/application.properties`
- Et modifier les informations de la base de donnée par rapport aux configurations faits pendant l'installation de Postgres
    
        spring.datasource.username=postgres
        spring.datasource.password=[password]

## Lancer le projet
Pour lancer le projet, on entre dans le dossier `src/` et on ouvrir le terminal et on execute les commandes suivantes :
- `.\mvnw clean install`
- `.\mvnw spring-boot:run`

