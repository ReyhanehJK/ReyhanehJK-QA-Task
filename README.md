# ReyhanehJK-QA-Task

I have done the home task as #Cypress and #Selenium and #Testproject

# 1_QA_Task_Selenium

Tools and Technologies
======================
- Java
- Maven
- JUnit
- TestNG
- Eclipse
- POM
- Testproject

Prerequisite
==================
Maven (For managing dependencies)
IntelliJ or Eclipse
Installation
==================
Install from git (using git clone)
Run "mvn clean test" from project directory

### Dependencies
Maven (For managing dependencies) IntelliJ or Eclipse Installation
Install from git (using git clone) Run "mvn clean test" from project directory

Setup automation project
*. Checkout the project

*. Download and install JDK 1.8.

*. Add the environment paths

Type defaults write com.apple.finder AppleShowAllFiles YES in terminal to view hidden files

Alt+Right click on finder and click relaunch to activate changes

Navigate to your user's directory

If you don't have a .bash_profile file, you can create one by following these steps: Start up Terminal Type cd ~/ to go to your home folder Type touch .bash_profile to create your new file. Edit .bash_profile with your favorite editor (or you can just type open -e .bash_profile to open it in TextEdit.

Add the following to the bash_profile: export JAVA_HOME=/Library/Java/JavaVirtualMachines/{jdk version}/Contents/Home/ export PATH=${JAVA_HOME}/bin:$PATH


### Executing program
*. Run tests
*. Import the project in Eclipse/IntelliJ IDEA 

Right-click on a test src\test\java\StepDefinitions\FunctionalTest.java file and select Run As cucumber or click on the TestRuner class and Run as TestNG

Result will be stored in custom report HTML file

Note:
I used the "Thread.sleep" on my code for better visibility of actions of any steps(I always use the implicit and explicit wait on selenium).



# 2_QA_Task_Testproject
Note:
""I have synced my project on the Testproject.
you just need to download and install Testproject Agent and Run code and check result and reports""(It needs to give permission in the Testproject dashboard so I have attached the video record of the test running in the repository)

- I have synced my project on the Testproject

- 1- Download and install the Test project Agent
- 2- Login and sync your agent with the testprogect
- 3- Click on the agent's tab(your agent status should be ready)
- 4- Click on the project tab
- 5-  On the right side "Jobs",  click on "..." and "Edit" buttons in the Mobimeo_S_BahnBerlinConnect and "Next" button, and on the Select browsers tab, you should click on your ready agent and Next and Save.
- 6- Now you can run the code with click on the Run button(it is like the play button, on the left the "...")



# 3_QA_Task_Cypress


<B>» Pre-requisites to this course include:</B>

- Node.js: https://nodejs.org/en/download/
- Visual Studio Code: https://code.visualstudio.com/download


<B>» Steps to use this project:</B>

1. Download or clone this repo
2. Install dependencies by running the following command in terminal (from inside your app directory i.e. where package.json is located): <I><B>npm install </I></B>

## Installation

npm install --save-dev cypress-axe


In order to create the package.json, open Terminal in Visual Studio Code Menu and type the command below:

npm init

On entering npm init in the terminal, it asks for a set of questions. Answer them or hit [Enter] [Enter] until it finishes. 

Finally, it asks – Is this OK? (yes). Then, hit [Enter].

Now the file named package.json is automatically created in the root folder of the project.

Install Cypress

Cypress is a NodeJS based automation tool, available as an npm package. Cypress can be also downloaded as an installer, but the recommended way is to install from npm.

In the root Project Folder (CypressJavascript) > Terminal > type 

npm install cypress --save-dev


Open Cypress Window

Once Cypress packages have been installed, Cypress, by default, configures some folders. Typically 4 folders will be created inside the Cypress folder namely plugins, support, integration, fixtures – the first time when the tester opens Cypress. In order to open the Cypress window, use one of the following commands:

node ./node_modules/cypress/bin/cypress open  

Or 

npx cypress open


Run tests in Cypress Window/UI

To run tests in the Cypress window, do the following:

In the terminal, enter the command

npx cypress open

and run the test and then the html rport preper in the report folder




## Authors
Reyhaneh Janikeh
Email: r.janikeh@gmail.com
