pipeline {
  agent any
  environment {
    DOCKER_IMAGE = 'conradosetti/ac2_ca_staging'
  }
  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/AlanEdward19/ac2_qaDevOps.git'
      }
    }
    stage('Build Image') {
      steps {
        sh 'docker build -t ${DOCKER_IMAGE} -f Dockerfile .'
      }
    }
    stage('Push Image') {
      steps {
        sh 'docker push ${DOCKER_IMAGE}'
      }
    }
  }
}
