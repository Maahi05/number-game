import java.util.*;

class gradeCalc {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of subjects:");
        int n = in.nextInt();

        if (n <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            in.close();
            return;
        }

        int a[] = new int[n];

        int sum = 0;

        System.out.println("Enter marks (0-100):");

        for(int i = 0; i < n; i++) {

            System.out.println("Marks in subject " + (i + 1) + ":");

            a[i] = in.nextInt();

            if (a[i] < 0 || a[i] > 100) {
                System.out.println("Invalid marks. Please enter values between 0 and 100.");
                in.close();
                return;
            }

            sum += a[i];
        }

        double avg = (double)sum / n;

        System.out.println("Total Marks: " + sum);
        System.out.println("Average Percentage: " + String.format("%.2f%%", avg));

        if (avg >= 90) {
            System.out.println("Grade A");
        }
        else if(avg >= 80) {
            System.out.println("Grade B");
        }
        else if(avg >= 70) {
            System.out.println("Grade C");
        }
        else if(avg >= 60) {
            System.out.println("Grade D");
        }
        else {
            System.out.println("Grade E");
        }
        in.close();
    }
}