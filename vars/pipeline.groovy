#!/groovy

def call() {
    pipeline {
        agent any
        environment {
            MODULE='m4'
        }
        stages {
            stage('Verify') {                  
                steps {
                    echo "Module: ${MODULE}"
                    sh 'git version'
                }
            }
        }
    }
}
/*def call() {
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
*/

return this;
