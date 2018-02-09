import java.io.*;

public class MFDriver {
  private static final String filename = "OliversResults" + ".csv";

  public static int[][] populate(int size) {
    int[][] array = new int[size][size];
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        array[i][j] = (i + j) * 2;
      }
    }
    return array;
  }

  public static void main(String[] args) {
    long timeEnd;
    long timeStart;
    int ARRAY_SIZE = 1000;
    int target;
    int[][] array;
    System.out.println("Working...");
    String loadingBar;

    try(FileWriter fw = new FileWriter(filename, true);
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter out = new PrintWriter(bw)) {
        out.println( "TRIAL,ARRAY_SIZE,TIME");
      } catch (IOException e) {
        e.printStackTrace();
      }
    for(int trial = 0; trial < 100; trial++) {
      /* RUN TESTS */
      ARRAY_SIZE += 10;
      array = populate(ARRAY_SIZE);
      //start timer
      timeStart = System.currentTimeMillis();
      //start testing
      for(int i = 0; i < 100000; i++) {
        target = (int) (Math.random() * 5000.0);
        MatrixFinder.locateCoord(array, target);
      }
      timeEnd = System.currentTimeMillis();

      /* LOG TIME TO CSV */
      try(FileWriter fw = new FileWriter(filename, true);
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter out = new PrintWriter(bw)) {
        out.println(trial + "," + ARRAY_SIZE + "," + (timeEnd - timeStart));
      } catch (IOException e) {
        e.printStackTrace();
      }

      /* UPDATE LOADING BAR */
      loadingBar = "\r|";
      for(int x = 0; x < trial/10; x++) {
        loadingBar += "=";
      }
      for(int y = 0; y < 10 - (trial/10); y++) {
        loadingBar += " ";
      }
      loadingBar += "|";
      try{
      System.out.write(loadingBar.getBytes());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.out.println("\nDone!");
  }
}
