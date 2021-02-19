pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                sh './mvnw clean compile'
            }
        }
        stage('Build And Push Image') {
            steps {
                sh './mvnw compile jib:build'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}