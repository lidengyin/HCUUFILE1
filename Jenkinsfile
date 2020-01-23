pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                sh 'source /etc/profile' 
                
                
                sh 'java -jar /var/lib/jenkins/workspace/Pipeline_HCUUFILE_47/target/hcuufile-0.0.1-SNAPSHOT.jar &'
              
            }
         
        }
    }
}
