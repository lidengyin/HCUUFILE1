pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                sh 'source /etc/profile'
                
                sh 'mvn clean package spring-boot:repackage'
                sh 'printenv' 
            }
         
        }
    }
}
