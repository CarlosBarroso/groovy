#!/groovy
/*
def call() {
    node {
      sh '''
        git version       
        dotnet --list-sdks
        dotnet --list-runtimes
      '''
    }
}
*/
/*
def call() {
    pipeline {
        agent any
        environment {
            MODULE='m4'
        }
        stages {
            stage('Verify') {                  
                steps {
                    echo "Module"                    
                }
            }
        }
    }
}
*/


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
                    sh 'ls -l "$WORKSPACE"'
                }
            };
        }
    }
}

