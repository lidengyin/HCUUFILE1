pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                sh '#!/bin/bash -ilex'
                sh 'mvn clean package spring-boot:repackage'
                sh 'printenv' 
            }
        }
    }
}
