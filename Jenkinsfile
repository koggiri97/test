pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'building the application...'
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
        stage('test') {
            steps {
                echo 'testing the application...'
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying the application...'
                sh 'docker login -u koggiri97 -p @gudcks132 docker.io'
                sh 'docker build -t koggiri97/testspring:0.1.0 ./build/libs'
                sh 'docker push koggiri97/testspring:0.1.0'
            }
        }
    }
}
