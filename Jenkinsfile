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
                sh 'docker build -t koggiri97/testspring:0.1.0 .'
                sh 'docker push koggiri97/testspring:0.1.0'
            }
        }
        stage('pull') {
            steps {
                sshPublisher(publishers: [
                  sshPublisherDesc(
                      configName: 'deploy_server',
                      transfers: [
                        sshTransfer(
                            execCommand: 'docker login -u koggiri97 -p @gudcks132 docker.io'
                        ),
                        sshTransfer(
                            execCommand: 'docker pull koggiri97/testspring:0.1.0'
                        ),
                        sshTransfer(
                            execCommand: 'docker ps -q --filter name=test_server| grep -q . && docker rm -f $(docker ps -aq --filter name=test_server)'
                        ),
                        sshTransfer(
                            execCommand: 'docker run -d --name test_server -p 5001:8080 koggiri97/testspring:0.1.0'
                        )                          
                      ]
                  )
                ])
            }
        }
    }
}
