import java.util.*;

class SRT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter no of process : ");
        int n = in.nextInt();
        int a[] = new int[10];
        int b[] = new int[10];
        int x[] = new int[10];
        int waiting[] = new int[10];
        int turnaround[] = new int[10];
        int completion[] = new int[10];
        double avg = 0, tt = 0;
        int small, count = 0, time, end, c;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Arrival Time of Process : ");
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Burst Time of Process : ");
            b[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++)
            x[i] = b[i];
        b[n] = 9999;

        for (time = 0; count != n; time++) {
            small = 9;
            for (int i = 0; i < n; i++) {
                if (a[i] <= time && b[i] < b[small] && b[i] > 0) {
                    small = i;
                }
            }
            b[small]--;

            if (b[small] == 0) {
                count++;
                end = time + 1;
                completion[small] = end;
                waiting[small] = end - a[small] - x[small];
                turnaround[small] = end - a[small];
            }
        }
        System.out.println("\nprocess	burst-time	Arrival-time	waiting-time	turnaround	completion");
        for (int i = 0; i < n; i++) {
            c = i + 1;
            System.out.println("\n" + c + "\t" + x[i] + "\t" + a[i] + "\t" + waiting[i] + "\t" + turnaround[i] + "\t"
                    + completion[i]);
            avg = avg + waiting[i];
            tt = tt + turnaround[i];
        }
        System.out.println("\n average waiting time : " + avg / n);
        System.out.println("average turnaround time : " + tt / n);

    }
}