pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                dir('/data/shanhy'){
      sh '(source /etc/profile;source ~/.bash_profile;sh ./demo.sh)'
    }
                sh 'mvn clean package spring-boot:repackage'
                sh 'printenv' 
            }
        }
    }
}
