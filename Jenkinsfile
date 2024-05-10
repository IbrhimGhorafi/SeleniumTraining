pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Test') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn test'
                }
            }
        }
        stage('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                         fileIncludePattern: "rapport/cucumber.json",
                         jsonReportDirectory: "report"
            }
        }
    }
}
