pipeline {
    agent {
         dockerfile true
    }
    stages {
        stage('Compile') {
            steps {
                sh './mvnw clean compile'
            }
        }
        stage('Docker login') {
            environment {
                DOCKERHUB_CREDS = credentials('dockerhub_id')
            }
            steps {
                sh 'docker login -u DOCKERHUB_CREDS_USR -p DOCKERHUB_CREDS_PSW'
            }
        }
        stage('Build And Push Image') {

            steps {
                sh './mvnw package'
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