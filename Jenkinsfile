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
                            credentialsId: 'jenkins_github',
                            url: 'https://github.com/YacineRAFES/webSpringboot.git'
                }
            }
        }
        stage('Nettoyage et package JAR Maven') {
            steps {
                sh 'mvn clean package'
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
}

