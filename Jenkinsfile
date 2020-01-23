pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                sh 'source /etc/profile'
                sh '/root/.bash_profile'
                sh './demo.sh'
                sh 'mvn clean package spring-boot:repackage'
                sh 'printenv' 
            }
         
        }
    }
}
