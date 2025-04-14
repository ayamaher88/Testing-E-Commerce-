pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'Asmaasaida', url: 'https://github.com/Asmaasaida/Demoplaze_Fullproject.git'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'your_test_command --report=test_report.xml' // Replace with your actual test command
                echo 'Publishing test results...'
                junit 'test_report.xml' // Adjust report path if needed
            }
        }
        // Add other build, package, deploy stages as needed
    }
}
