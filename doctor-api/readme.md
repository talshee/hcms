# Allocator Rest Harness

## Folder Structure

- allocator-test-harness :  RESTful web harness which will be used to expose the following APIs

            GET allocator/pull
			POST allocator/launch
			GET allocator/run/{run_id}/outputfile
			
			
			
			
			The Tomcat container needs to be started with 3 volumes; 2 for docker.sock and 1 to use the run_allocator.sh script
				- docker run -it --rm -p 9966:8080 -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):/usr/bin/docker cep/allocator-harness:v3
				
				docker run -it -p 9966:8080 -v /c/Users/ramanakr/allocator/allocator/war:/usr/local/tomcat/webapps -v /c/Users/ramanakr/allocator/script:/usr/local/bin/ -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):/usr/bin/docker  -v /c/Users/ramanakr/allocator/allocator/:/allocator/output cep/allocator-harness:v11 catalina.sh run
				
  
## Deploying the harness locally

		mvn clean install tomcat7:run -Dspring.profiles.active="T2"
 




