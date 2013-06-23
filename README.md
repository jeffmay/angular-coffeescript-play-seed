#  Play 2 Hello World clickstart

This clickstart sets up a SBT build service, repository and a basic Play 2 application.

<a href="https://grandcentral.cloudbees.com/?CB_clickstart=https://raw.github.com/CloudBees-community/play2-clickstart/master/clickstart.json"><img src="https://d3ko533tu1ozfq.cloudfront.net/clickstart/deployInstantly.png"/></a>

Launch this clickstart and glory could be yours too ! Use it as a building block if you like.

You can launch this on Cloudbees via a clickstart automatically, or follow the instructions below. 

# Deploying manually: 

## To build and deploy this on CloudBees, follow those steps:

Create application:

    bees app:create MYAPP_ID

Create a new software project in Jenkins, changing the following:

* Add this git repository (or yours, with this code) on Jenkins
* Change JDK to:
    
        Oracle JDK 1.7 (Latest)
    
* Add an "Execute Shell" build step with:
    
        java -Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=384M -jar /opt/sbt/sbt-launch-0.11.3-2.jar -Dsbt.log.noformat=true dist
    
* Also add a post-build step "Deploy to CloudBees" with those parameters:

        Applications: First Match
        Application Id: MYAPP_ID
        Filename Pattern: dist/*.zip
    
Then finally update your application from your own computer:
    
    bees config:set -a MYAPP_ID -Rjava_version=1.7 containerType=play2 proxyBuffering=false
    bees app:restart MYAPP_ID

## To build this locally:

You will need play2 installed, or sbt (this jenkins build currently uses SBT).

In the play2-clickstart directory, open a command line, and then type:

    play dist

Then deploy it on cloudbees typing:

    bees app:deploy -a MYAPP_ID -t play2 -Rjava_version=1.7 dist/*.zip proxyBuffering=false

## To run this locally:


You will need a locally running MySQL server for this instance, 
or you can use your cloudbees DB created above as part of of the clickstart.

provide the environment variables so Play can connect to your DB: 
    
    export DATABASE_URL_DB=mysql://URL_TO_DB_HERE
    export DATABASE_PASSWORD_DB=PASSWORD_HERE
    export DATABASE_USERNAME_DB=USERNAME_HERE


Use the following command, and then browse to localhost:9000:

    play run
    
    
To get your cloudbees DB info - run bees db:info -p youraccount/appname(from your clickstart)    



angular-seed-play
=================

This project illustrates how [WebJars](http://www.webjars.org/) can be used along with
[requirejs](http://requirejs.org/) in relation to the popular
[angular-seed](https://github.com/angular/angular-seed) project.

<a href="https://grandcentral.cloudbees.com/?CB_clickstart=https://raw.github.com/typesafehub/angular-seed-play/master/clickstart.json"><img src="https://d3ko533tu1ozfq.cloudfront.net/clickstart/deployInstantly.png"/></a>

The main idea is to show how little impact there is on JavaScript when using it in the context of Play and WebJars.
The project also illustrates the intrinsic support of JavaScript development from within Play. We hope that the sample
serves to show that Play is not strongly opinionated about how JavaScript development is to be done, but that it can
really help. Our goal when using Play is that you should not require other task runners or package management tools for
your JavaScript development [1].

The following things enhance the regular angular-seed project:

1. index.html does not require explicit script statements to load the other js files - we leverage requirejs to do
this for us. This makes the maintenance of files easier by enforcing the
[DRY](http://en.wikipedia.org/wiki/Don't_repeat_yourself) principle.
2. There is a single script statement for loading requirejs from index.html and a data-main attribute declaring the
JavaScript to invoke upon loading it. This declaration is entirely conventional requirejs.
3. Each JavaScript file has an AMD define declaration which declares the AMD modules (these are different to
angular modules - check out (this issue)[https://github.com/angular/angular.js/issues/2078]). Using define() and
require() is conventional for AMD usage.
4. AngularJs is declared as a WebJar - check out the project/Build.scala file to see its declaration. requirejs is also
declared this way so you can easily upgrade its version as new ones become available. By being brought in as a WebJar
you have all of the advantages that artifact repositories including Maven and Ivy based ones bring; in particular
dependency management.

[1] We are not there yet. Play 2.3 plans significant functionality to assist further including linting, unit testing,
optimization and so forth.