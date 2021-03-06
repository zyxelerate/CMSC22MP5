import java.util.*;
public class KiunisalaMP5 {
  public static int threadCount = 10;
  public static int charPerThread;
  private static Scanner sc;
  
  public static void main(String[] args){
    System.out.println("Enter desired size:");
    sc = new Scanner(System.in);
    int x = sc.nextInt();
    long startTime = System.currentTimeMillis();
    String init = "";
    String nxt = "";
    int min = 0, max;
    
    char[] cell = new char[x];
    
    for (int i = 0; i < x; i++){
      cell[i] = '0';
    }
    cell[x/2] = '1';
    init = String.valueOf(cell);
    System.out.println(init);
    
    if(x < threadCount){ //if size given is less than 10
    	threadCount = x;
    }
    
    Rule30Thread[] workers = new Rule30Thread[threadCount];
    charPerThread = x / threadCount;
    max = charPerThread - 1;
    
    for(int i = 0; i < x - 1; i++){
        
    	for(int j = 0; j < threadCount; j++){
    		if(j == threadCount - 1){
                max = x - 1;
            }       
            workers[j] = new Rule30Thread(min, max, init);
            min = max + 1;
            max = min + charPerThread - 1;
        }
        
        for(int j = 0; j < threadCount; j++){
            workers[j].start();
        }
        
        for (int j = 0; j < threadCount; j++) {
        	while (workers[j].isAlive()) {
        	try {
        		workers[j].join();
        	}catch (InterruptedException e) {
                System.err.println("thread interrupted: " + e.getMessage());
             }
        	}
        }
                
        for(int j = 0; j < threadCount; j++){
            nxt += workers[j].getRes();
        }
        
        System.out.println(nxt);
        
        init = nxt;
        nxt = "";
        
        min = 0;
        max = charPerThread - 1;
        
    	}
    System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));  
  }
}
