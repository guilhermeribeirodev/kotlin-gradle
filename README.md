```
aws ecr create-repository --repository-name hello-repository

docker tag hello-world 246611553559.dkr.ecr.us-east-1.amazonaws.com/hello-repository

aws ecr get-login --no-include-email

aws ecs register-task-definition --cli-input-json file://customer-task-def.json --debug

aws ecs run-task --task-definition hello-world

```