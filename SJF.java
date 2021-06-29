import java.util.*;

public class SJF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of process:");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n]; // rrival time
        int bt[] = new int[n]; // burst time
        int ct[] = new int[n]; // complete time
        int ta[] = new int[n]; // turn around time
        int wt[] = new int[n]; // waiting time
        int f[] = new int[n];
        int st = 0, tot = 0;
        float avgwt = 0, avgta = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("process " + (i + 1) + " waktu datang:");
            at[i] = sc.nextInt();
            System.out.println("process " + (i + 1) + " waktu butuh:");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
            f[i] = 0;
        }

        boolean a = true;
        while (true) {
            int c = n, min = 999;
            if (tot == n)
                break;

            for (int i = 0; i < n; i++) {

                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }

            if (c == n)
                st++;
            else {
                ct[c] = st + bt[c];
                st += bt[c];
                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                f[c] = 1;
                tot++;
            }
        }

        System.out.println("\nprocess  waktu datang  waktu butuh  complete	turn  waiting");
        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgta += ta[i];
            System.out
                    .println(pid[i] + "\t  	" + at[i] + "\t  " + bt[i] + "\t\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }
        System.out.println("\nrata-rata turn around time " + (float) (avgta / n));
        System.out.println("rata-rata wait time : " + (float) (avgwt / n));
        sc.close();
    }
}