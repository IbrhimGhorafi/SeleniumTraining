pipeline {
    agent any

    stages {
        stage('Compile Stage') {
            steps {
                withMaven(maven: 'maven_3_9_6') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test Stage') {
            steps {
                withMaven(maven: 'maven_3_9_6') {
                    sh 'mvn test'
                }
            }
        }

        stage('Cucumber Reports') {
            steps {
                script {
                    cucumber buildStatus: "UNSTABLE",
                             fileIncludePattern: "rapport/cucumber.json",
                             jsonReportDirectory: "report"
                }
            }
        }
    }
}
