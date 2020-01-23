pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                script{
                    !/bin/bash -ilex
                }
                sh 'mvn clean package spring-boot:repackage'
                sh 'printenv' 
            }
        }
    }
}
