
<h2>REPERTOIRES</h2>

Après avoir décompressé ce fichier, vous obtenez les répertoires suivants:
  
  <pre><code>   +
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
  +-pom.xml : fichier de configuration de l'application
  </code></pre>
  
 
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
        Positionnez la variable CATALIBNA_HOME
        Rajoutez le répertoire %CATALINA_HOME%\bin dans votre PATH
        
    - Si vous n'êtes pas dans l'environemment de l'ETS, assurez vous d'avoir activer le VPN vous mettant en relation avec le réseau local
      de l'ETS. le logiciel et les instructions sont disponible a l'adresse suivante: 
      http://www.etsmtl.ca/Services/sTI/Etudiants/Reseau-et-Communication/RPV
      
      
