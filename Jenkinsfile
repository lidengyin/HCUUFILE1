pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                script{
                    
                }
                sh '#!/bin/bash -ilex'
                sh 'mvn clean package spring-boot:repackage'
                sh 'printenv' 
            }
        }
    }
}
