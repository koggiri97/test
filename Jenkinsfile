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
        stage('SSH transfer') {
            script {
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: 'deploy_server',
                            transfers: [
                                sshTransfer(
                                    cleanRemote: false, excludes: '',
                                    execCommand: '''
                                    docker login -u koggiri97 -p @gudcks132 docker.io
                                    docker pull koggiri97/testspring:0.1.0
                                    docker ps -q --filter name=test_server| grep -q . && docker rm -f $(docker ps -aq --filter name=test_server)
                                    docker run -d --name test_server -p 5001:8080 koggiri97/testspring:0.1.0''',
                                    execTimeout: 120000,
                                    flatten: false,
                                    makeEmptyDirs: false,
                                    noDefaultExcludes: false,
                                    patternSeparator: '[, ]+'
                                    remoteDirectory: '',
                                    remoteDirectorySDF: false, 
                                    removePrefix: '',
                                    sourceFiles: ''
                                )
                            ],
                            usePromotionTimestamp: false,
                            useWorkspaceInPromotion: false,
                            verbose: false
                        )
                ])
            }
        }
    }
}
