pipeline {
    agent any
    environment {
        registry = "yacinerafes/webspringboot2025"
        registryCredential = 'jenkins_dockerID'
        dockerImage = ''
    }
    stages {
        stage('Nettoyage de workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Git Checkout') {
            steps {
                script {
                    git branch: 'main',
                            credentialsId: 'jenkins_githubID',
                            url: 'https://github.com/YacineRAFES/webSpringboot.git'
                }
            }
        }
        stage('Nettoyage et package JAR Maven') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('yacinerafes/webspringboot2025:latest', '-f Dockerfile .')
                }
            }
        }
        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        docker.image('yacinerafes/webspringboot2025:latest').push()
                    }
                }
            }
        }

        stage('Deploiement docker-compose') {
            steps {
                script {
                    bat 'docker-compose up -d --build --force-recreate --remove-orphans'
                }
            }
        }
    }
    post {
        success {
            discordSend description: 'Pipeline CI/CD AppWeb réussie', result: 'SUCCESS', title: 'AppWeb CI/CD Pipeline', webhookURL: env.DS_WEBHOOK_URL
        }
        failure {
            discordSend description: 'Pipeline CI/CD AppWeb a été échoué', result: 'FAILURE', title: 'AppWeb CI/CD Pipeline', webhookURL: env.DS_WEBHOOK_URL
        }
    }
}

