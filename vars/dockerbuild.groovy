def call(String project, String hubUser) {
   sh "docker image build -t ${hubUser}/${project}:${env.BUILD_NUMBER} ."
   withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
    sh "docker image push ${hubUser}/${project}:${env.BUILD_NUMBER}"
}

