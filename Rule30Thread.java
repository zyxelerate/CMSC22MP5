public class Rule30Thread extends Thread{

    private static String in;
    private int min;
    private int max;
    private String result = "";
    
    public Rule30Thread(int min, int max, String in) {
        if (min > max || min < 0 || max < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        this.min = min;
        this.max = max;
        this.in = in;
    }

    @Override
    public void run() {
        for(int i = min; i <= max; i++){
            result += R30T(i);
        }
    }
    
    public static char R30T(int x){
        char res = '0';
        
        if (x == 0){
            if (in.charAt(x) == '0' && in.charAt(x + 1) == '1'){
              res = '1';
            }
            if (in.charAt(x) == '1' && in.charAt(x + 1) == '0'){
              res = '1';
            }
            if (in.charAt(x) == '1' && in.charAt(x + 1) == '1'){
              res = '1';
            }
          }
          else if (x == (in.length() - 1)){
            if (in.charAt(x - 1) == '0' && in.charAt(x) == '1'){
              res = '1';
            }
            if (in.charAt(x - 1) == '1' && in.charAt(x) == '0'){
              res = '1';
            }
          }
          else {
            if (in.charAt(x - 1) == '0' && in.charAt(x) == '0' && in.charAt(x + 1) == '1'){
              res = '1';
            }
            if (in.charAt(x - 1) == '0' && in.charAt(x) == '1' && in.charAt(x + 1) == '0'){
              res = '1';
            }
            if (in.charAt(x - 1) == '0' && in.charAt(x) == '1' && in.charAt(x + 1) == '1'){
              res = '1';
            }
            if (in.charAt(x - 1) == '1' && in.charAt(x) == '0' && in.charAt(x + 1) == '0'){
              res = '1';
            }
          }
        return res;
    }
    
  public String getRes(){
    return result;
  }
}