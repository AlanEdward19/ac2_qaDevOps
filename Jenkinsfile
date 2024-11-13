pipeline {
  agent any
  environment {
    DOCKER_IMAGE = 'conradosetti/ac2_ca_staging'
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
