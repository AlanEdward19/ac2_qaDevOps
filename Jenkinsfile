pipeline {
    agent any

    environment {
        APP_ENV = 'staging'
    }

    stages {
        stage('Checkout') {
            steps {
                // Faz o checkout do código-fonte do repositório
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Executa o build da aplicação, por exemplo, para um projeto Maven
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Executa os testes de unidade
                sh 'mvn test -Dspring.profiles.active=staging'
            }
            post {
                always {
                    // Publica os relatórios JUnit, referenciando o caminho onde os relatórios XML são gerados
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                // Exemplo de deploy usando Docker
                sh 'docker-compose -f docker-compose.yml up --build -d'
            }
        }
    }

    post {
        success {
            echo "Pipeline Staging concluído com sucesso."
        }
        failure {
            echo "Pipeline Staging falhou."
        }
    }
}
