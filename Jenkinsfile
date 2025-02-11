pipeline {
    agent any
    triggers {
        githubPush()  // Trigger when code is pushed to GitHub
    }
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/vwoo-hub/SauceDemo.git'
            }
        }
        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test -P Regression -Dbrowser=chromeheadless'
            }
        }
    }
}