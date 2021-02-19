pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                sh './mvnw clean compile'
            }
        }
        stage('Build And Push Image') {
            environment {
               DOCKERHUB_CREDS = credentials('dockerhub_id')
            }
            steps {
                sh './mvnw compile jib:build -Djib.to.auth.username=DOCKERHUB_CREDS_USR -Djib.to.auth.password=DOCKERHUB_CREDS_PSW'
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