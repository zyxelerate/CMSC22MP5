import java.util.*;
public class KiunisalaMP1 {
 public static void main(String[] args) {
  System.out.println("Enter desired size:");
  Scanner sc = new Scanner(System.in);
  long startTime = System.currentTimeMillis();
  int x = sc.nextInt();
  char[] cell = new char[x];
  char[] newCell = new char[x];
  int k;
  for (k = 0; k < x; k++){ //initialize first string
         newCell[k] = '0';
         cell[k] = '0';
     }
  cell[x/2] = '1';
  for (k = 0; k < x; k++){
   System.out.print(cell[k]);
  }
  System.out.print("\n");
  for (int i = 0; i < x - 1; i++){ //x-1 since there is an initial printing of the first line
   for (int j = 0; j < x; j++){
    if (j == 0){
     if (cell[j] == '0' && cell[j+1] == '0'){
      newCell[j] = '0';
     }
     else if (cell[j] == '0' && cell[j+1] == '1'){
      newCell[j] = '1';
     }
     else if (cell[j] == '1' && cell[j+1] == '0'){
      newCell[j] = '1';
     }
     else if (cell[j] == '1' && cell[j+1] == '1'){
      newCell[j] = '1';
     }
    }
    else if (j == x-1){
     if (cell[j-1] == '0' && cell[j] == '0'){
      newCell[j] = '0';
     }
     else if (cell[j-1] == '0' && cell[j] == '1'){
      newCell[j] = '1';
     }
     else if (cell[j-1] == '1' && cell[j] == '0'){
      newCell[j] = '1';
     }
     else if (cell[j-1] == '1' && cell[j] == '1'){
      newCell[j] = '0';
     }
    }
    else {
     if (cell[j-1] == '0' && cell[j] == '0' && cell[j+1] == '0'){
      newCell[j] = '0';
     }
     else if (cell[j-1] == '0' && cell[j] == '0' && cell[j+1] == '1'){
      newCell[j] = '1';
     }
     else if (cell[j-1] == '0' && cell[j] == '1' && cell[j+1] == '0'){
      newCell[j] = '1';
     }
     else if (cell[j-1] == '0' && cell[j] == '1' && cell[j+1] == '1'){
      newCell[j] = '1';
     }
     else if (cell[j-1] == '1' && cell[j] == '0' && cell[j+1] == '0'){
      newCell[j] = '1';
     }
     else if (cell[j-1] == '1' && cell[j] == '0' && cell[j+1] == '1'){
      newCell[j] = '0';
     }
     else if (cell[j-1] == '1' && cell[j] == '1' && cell[j+1] == '0'){
      newCell[j] = '0';
     }
     else if (cell[j-1] == '1' && cell[j] == '1' && cell[j+1] == '1'){
      newCell[j] = '0';
     }
    }
   }
   for (k = 0; k < x; k++){
    cell[k] = newCell[k];
    System.out.print(cell[k]);
                newCell[k] = '0';
   }
   System.out.print("\n");
  }
  System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
 }
}
