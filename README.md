
<h3>REPERTOIRES</h3>

Après avoir décompressé ce fichier, vous obtenez les répertoires suivants:
  
  <pre><code>   
  +
  +-README.md                  : le fichier que vous êtes en train de lire
  |
  +-src 
  |
  |   +main : code source de l'application equipe17-log720-A11-lab2 
  |   |   +-Java : contient les beans et les servlets
  |   |   |
  |   |   +-webapp
  |   |   |   +-WEB-INF : contient les différentes pages jsp 
  |   |   |   |
  |   |   |   + META-INF : contient le fichier context xml pour la definition du data source pour JNDI
  |   |   +-agent : contient les ressources accessibles par le rôle agent. C'est à dire les agents de police.
  |   |   |
  |   |   +-admin : contient les ressources disponibles pour le role admin. C'est a dire les administrateurs
  |   |   |
  |   |   +-shared : contient les ressources disponibles pour les deux roles
  |   |   |
  +-pom.xml : fichier de configuration de l'application
  </code></pre>
  
 <h3>INSTALLATIONS ET CONFIGURATIONS</h3>
 
 Avant de d'exécuter l'application, assurez vous que vous avez les outils nécessaire installés:

    - JDK
        Installez une version du JDK égale ou supèrieure à 1.6_23 à partir de http://www.oracle.com/
        Positionnez la variable JAVA_HOME
        Rajoutez le répertoire %JAVA_HOME%\bin dans votre PATH
        
    - Maven
        Installez une version de Maven égale ou supèrieure à 3.0.1 à partir de http://maven.apache.org/download.html
        Positionnez la variable MAVEN_HOME
        Rajoutez le répertoire %MAVEN_HOME%\bin dans votre PATH
        
    - Tomcat
        Installez une version du serveur Tomcat égale ou supèrieure 7.0.5 à partir de http://tomcat.apache.org/download-70.cgi
        Positionnez la variable CATALINA_HOME avec la valeure du chemin de votre installation
        Rajoutez le répertoire %CATALINA_HOME%\bin dans votre PATH
        Aller dans le dossier parent de TomCat. Dans le dossier conf, ouvrir le fichier tomcat-users.xml
        Rajouter les lignes suivantes entres les balises <tomcat-users> et </tomcat-users>
        <role rolename="policier" />
        <role rolename="admin" />
        
        <user username="cop" password="cop" roles="policier" />
        <user username="admin" password="admin" roles="admin" />
        
        C'est necéssaire pour pouvoir vous authentifier.
        
    - Si vous n'êtes pas dans l'environemment de l'ETS, assurez vous d'avoir activer le VPN vous mettant en relation avec le réseau local
      de l'ETS. le logiciel et les instructions sont disponible a l'adresse suivante: 
      http://www.etsmtl.ca/Services/sTI/Etudiants/Reseau-et-Communication/RPV

<h3>DEPLOIEMENT</h3>  

    <li>Package </li>
    Pour deploiyer l'appli, lancer votre console en vous assuarant que la variable MAVEN_HOME est bien définit et pointe sur votre installation de Maven comme indiqué en haut. A partir de votre console, aller dans le répertoir racine de l'appli, c'est a dire dans le dossier equipe17-log720-A11-lab2. Une fois dans ce dossier, lancer la commande mvn package. Si vous avez suivi les instruction, la commande devrait réussire et vous afficher "buid succes"
    Une fois la commande exécuter, aller dans le répertoir racine de l'appli a travaers votre fureteur système.
    vous devrez trouver un nouveau répertoir qui a été créé par Maven. Aller dans ce répertoir et vous y trouverai un fichier au nom de equipe17-log720-A11-lab2-SNAPSHOT-01.jar. Copiez ce fichier dans le dossier webapp contenu dans le dossier parent de votre installation tomcat.
    
  <li>Lancer l'appli </li>
  Aller dans le dossier bin de votre installation tomcat a partir de votre console et lancez le script startup.sh pour démarrer tomcat.
  Aller a l'adresse http://localhost:8080/equipe17-log720-A11-lab2-SNAPSHOT-01
  vous devez atterir sur la page d'accueil de l'appli.
  connectez avec l'un des identifiant suivants selon aue vous voulez avoir un role admin ou agent:
       - Agent de police
          identifiant: cop
          password  cop
       - Admin
          identifiant : admin
          password: admin

Vous pouvez maintenant commencer a utiliser l'application !      

  
