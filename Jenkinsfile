pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
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
        stage('Package') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn package'
                }
            }
        }

        stage('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                         fileIncludePattern: "rapport/cucumber.json",
                         jsonReportDirectory: "report"
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'report',
                    reportFiles: 'cucumber-html-reports/**.html',
                    reportName: 'Cucumber Reports',
                    reportTitles: 'Cucumber Reports'
                ])
            }
        }
    }
}
