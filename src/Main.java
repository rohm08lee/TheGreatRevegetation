import java.util.*;
import java.io.*;
public class Main {
    // Put the values inside a 2D array graph. Then use the graph to find where a grass type
    // will be needed. Then use the boolean list to deduct which types of grass are already used.
    // Then print out the types of grass each fields will use.
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter("revegetate.out");

        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[][] cow = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            cow[a][b] = true;
            cow[b][a] = true;
        }

        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            boolean[] grass = new boolean[4];
            for (int j = 0; j < i; j++) {
                if (cow[i][j]) {
                    grass[ans[j]] = true;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (grass[j] == false) {
                    ans[i] = j;
                    break;
                }
            }
        }

        for (int c : ans) {
            pw.print(c+1);
        }
        pw.close();
    }
}