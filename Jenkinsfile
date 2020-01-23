pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                sh 'source /etc/profile' 
                sh 'mvn clean package spring-boot:repackage'
                sh 'printenv'
                sh 'java -jar hcuufile-0.0.1-SNAPSHOT.jar &'

            }
         
        }
    }
}
