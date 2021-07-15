def call() {
  pipeline {
    agent {
        docker {
            image 'mcr.microsoft.com/dotnet/core/sdk:3.1.101'
        }
    }
    stages {
        stage('verify') {
            steps {
                sh '''
                  dotnet --list-sdks
                  dotnet --list-runtimes
                '''
                sh 'printenv'
//                sh 'ls -l "$WORKSPACE"'
            }
        }
    }
  }
}
