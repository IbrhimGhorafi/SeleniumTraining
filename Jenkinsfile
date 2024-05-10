pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven(maven: 'maven_3_9_6') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Test') {
            steps {
                withMaven(maven: 'maven_3_9_6') {
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
