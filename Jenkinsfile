pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                sh 'source /etc/profile'
                sh 'source ~/.bash_profile'
                sh 'source ./demo.sh'
                sh 'mvn clean package spring-boot:repackage'
                sh 'printenv' 
            }
         
        }
    }
}
