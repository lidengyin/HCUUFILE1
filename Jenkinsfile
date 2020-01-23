pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                sh 'source /etc/profile' 
                
                
                sh 'java -jar hcuufile-0.0.1-SNAPSHOT.jar &'
              
            }
         
        }
    }
}
