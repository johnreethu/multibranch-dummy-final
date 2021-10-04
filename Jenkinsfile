pipeline 
{
    agent
    {
        node 
	{
            label 'maven'    
        }
    }
    
   stages 
    {
        stage ('checkout') 
        {
            steps 
            {
                echo "This is my CheckOut step"
            }
        }
        
        stage ('Build')
        {
           parallel
            {
              stage ('Build with Java 8') 
              
                {
                  agent 
		 	{
		   		node
                    		{
                        		label 'java8'
                    		}
		 
                    		steps 
                    		{
                        		//sh 'mvn compile'
                        		echo "This is my build step"
                    		}
                	}  
			
		}
                stage ('build with java 11') 
                {
                  agent 
		  	{
		   		node		
                    		{
                        		label 'java11'
                    		}
                  
                    		steps 
                    		{
                        		//sh 'mvn compile'
                        		echo "This is my build step"
                    		}
                
                	}  
                
            	}  
       	  }
     }
       
      stage ('test') 
      {
        parallel
        {
          stage ('Unit Test') 
            {
                steps 
                {
                    //sh 'mvn test'
                    echo "This is my unit test"
                }
            
            }  
            stage ('API Test') 
            {
                steps 
                {
                    echo "This is my build step"
                }
            
            }  
            stage ('System Test') 
            {
                steps 
                {
                    echo "This is my build step"
                }
            
            }  
        } 
      }
       
        
        stage ('Build-Push') 
        {
            stages 
            {
                stage ('build image')
                {
                    steps
                    {
                        echo "Build image from Docker Plugin"
                    }
                    
                }
                stage ('login and push')
                {
                    steps
                    {
                        echo "Login to docker hub and push the image to repository using plugin"
                    }
                    
                }
            }
            
            post  ('logout')
            {
                always 
                {
                    echo "Logout from Docker Hub by using plugin"
                }
            }
            
        }
        stage ('production') 
        {
            steps 
            {
                echo "This is my Production step"
            }
        }
    }
}

