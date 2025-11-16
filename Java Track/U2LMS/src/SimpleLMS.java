import java.util.Scanner;

public class SimpleLMS {
    static int maxSize = 100;
    // maximum limit of the classroom
    static String[] learnerNames = new String[maxSize];
    // array for storing the learner Names (maximum storage)
    static int[] learnerAges = new int[maxSize];
    // array for storing the learner Ages (maximum storage)
    static int[] learnerXP = new int[maxSize];
    // array for storing the learner XP (maximum storage)
    static int learnerCount = 0;
    // Counter variable for counting number of students created
    static Scanner sc = new Scanner(System.in);
    // creates scanner sc for getting input from keyboard

    public static void main(String[] args) throws Exception {
        runProgram();
    }

    static void runProgram() {

        int userChoice = 0;
        do {
            displayMenu();
            userChoice = sc.nextInt();
            processChoice(userChoice);
        } while (userChoice != 4);
    }

    static void displayMenu() {
        System.out.println("\n=== Learner Management System ===");
        System.out.println("1. Add new learner");
        System.out.println("2. List all learners");
        System.out.println("3. Calculate average XP");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    static void processChoice(int choice) {
        if (choice == 1) {
            addNewLearner();
        } else if (choice == 2) {
            displayAllLearners();
        } else if (choice == 3) {
            CalculateAvgXP();
        } else if (choice == 4) {
            exitProgram();
        } else {
            System.out.println("Enter a valid input b/w 1-4");
        }
    }

    static void addNewLearner() {
        // condition for checking availability
        if (learnerCount > maxSize) {
            System.out.println("Currently no seats available");
            return;
        }

        System.out.println("Enter learner Name");
        String name = sc.next();
        System.out.println("Enter the age of the learner");
        int age = sc.nextInt();

        // condition for checking eligibility using helper function
        if (!validateAge(age)) {
            System.out.println("Sorry" + name + ", age must be 18 - 30");
            return;

        }
        System.out.println("Enter XP for " + name + " : ");
        int xp = sc.nextInt();

        // add the user name to array list based on the admission number

        learnerNames[learnerCount] = name;
        learnerAges[learnerCount] = age;
        learnerXP[learnerCount] = xp;
        learnerCount++;
        // increasing the learner count after successfull application
    }

    static boolean validateAge(int age) {
        return age >= 18 && age <= 30;
    }

    static void displayAllLearners() {
        // 0 to inform if there are no learners
        if (learnerCount == 0) {
            System.out.println("No learners to Display");
            return;
        }
        System.out.println("Displaying all users");
        for (int i = 0; i < learnerCount; i++) {
            System.out.println("Name " + learnerNames[i]
                    + "|Age " + learnerAges[i]
                    + "|XP " + learnerXP[i]);

        }
        System.out.println("Total Users is " + learnerCount);
    }

    static void CalculateAvgXP() {
        // 0 users
        if (learnerCount == 0) {
            System.out.println("No learners to calculate average");
            return ;
        }

        int totalXp = 0 ;
        for (int i=0; i<learnerCount ;i++){
            totalXp += learnerXP[i];
        }
        int avgXP = totalXp/learnerCount;
        System.out.println( "Average XP of Learners is : "+ avgXP);
    }

    static void exitProgram() {
        System.out.println("Thank you for using Learner Management System!");
        System.out.println("Goodbye!");

    }
}
