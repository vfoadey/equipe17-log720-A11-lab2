
<h3>REPERTOIRES</h3>
  
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
        
    - Si vous n'êtes pas dans l'environemment de l'ETS, assurez vous d'avoir activer le VPN vous mettant en relation avec le réseau local
      de l'ETS. le logiciel et les instructions sont disponible a l'adresse suivante: 
      http://www.etsmtl.ca/Services/sTI/Etudiants/Reseau-et-Communication/RPV

<h3>DEPLOIEMENT</h3>  
  <h4>Package</h4>
    <ul>
      <li>Décompresser le dossier de remise dans un endroit qui vous convient.</li>
      <li>A partir de votre console, aller dans le répertoir racine du dossier de remise décompresser, c'est a dire dans le dossier equipe17-log720-A11-lab2.</li>
      <li>Une fois dans ce dossier, lancer la commande "mvn package". Après quelques secondes, la commande devrait réussire et vous afficher "BUILD SUCCESS".</li>
      <li>Une fois la commande exécuter, retourner dans le répertoire racine du dossier de remise, un répertoire "target" devrait maintenant y apparaitre.</li>
      <li>Dans ce dossier, vous trouverez le fichier ".war" que la commande package à généré</li>
      <li>Copiez ce fichier dans le dossier "webapp" de votre installation de Tomcat.</li>
    </ul>
  
  <h4>Lancement de l'application</h4>
  <ul>
    <li>Copier le fichier tomcat-users.xml fournit dans le dossier de remise sous le répertoire /conf. Ajouter le à votre installation Tomcat, sous le même répertoire /conf.</li>
    <li>Aller dans le dossier bin de votre installation Tomcat et lancer le script de démarage "startup".</li>
    <li>Dans un browser, diriger vous vers l'adresse http://localhost:8080/equipe17-log720-A11-lab2</li>
  </ul>

  <h4>Utilisation de l'application</h4>
    Utilisez les identifiants suivant afin d'accèder au différente fonctionnalité de l'application :
    <ul>
      <li>Agent de police : cop // cop</li>
      <li>Administrateur : admin // admin</li>
    </ul>
  
Vous pouvez maintenant commencer a utiliser l'application !