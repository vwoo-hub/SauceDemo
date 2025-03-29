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
                sh 'mvn test -D browser=chromeheadless'
            }
        }
        stage('Generate Allure Report') {
            steps {
                sh 'allure generate target/allure-results -o target/allure-report --clean'
            }
        }
    }
    post {
        always {
            allure includeProperties: false, reportBuildPolicy: 'ALWAYS', results: [[path: 'target/allure-results']]
        }
    }
}