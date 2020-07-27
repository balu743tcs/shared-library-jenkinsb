def call(String project) {
  sh "docker stack rm ${project}:${env.BUILD_NUMBER}"
}

