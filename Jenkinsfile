pipeline {
    agent any
    stages {
        stage('Git Checkout')
            steps {
                script {
                    git branch: 'main',
                    credentialsId: 'jenkins_github',
                    url: 'https://github.com/YacineRAFES/webSpringboot.git'
                }
            }
        }
    }
}