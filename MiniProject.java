import java.util.*;
import java.util.regex.*;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;


public class MiniProject {

    public static void main(String[] args) throws InterruptedException {

        // Running User Custom Tests
        System.out.println();
        System.out.println("----------------------Custom Tests-----------------------");

        // Creating a scanner to read user input
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Would you like to test your own sentences?: Y/N");
        String answer = sc.nextLine();

        // An if statement to process user input
        if (answer.equals("Y")) {
            String userSentence;
            do {
                // A do while loop to continuously request and process user input
                System.out.println();
                System.out.println("Please enter your sentence or enter STOP at anytime to end tests");
                userSentence = sc.nextLine();
                System.out.println();

                // An if else statement to catch users request to stop
                if (userSentence.equals("STOP")) {

                } else {
                    tests(userSentence);
                    //One second pause to enable a more readable output
                    TimeUnit.SECONDS.sleep(1);
                }
            } while (!userSentence.equals("STOP"));
        }

        sc.close();
    }
    public static boolean tests(String str) {

        //Create a Logger
        Logger log = Logger.getLogger(MiniProject.class.getName());

        log.info("Testing: "+str);

        // Setting test criteria, a string must pass 5 tests to be validated
        int testsPassed = 0;
        boolean passed = false;

        // Creating a Regex pattern and matcher to validate the first character of the string is a capital letter
        Pattern test1 = Pattern.compile("(^[A-Z])");
        Matcher matcher = test1.matcher(str);
        boolean capsMatch = matcher.find();

        // An if else statement to pass or fail the string based on the result of the above Regex
        if (capsMatch) {
            testsPassed++;
        }else{
            log.info("Sentence does not begin with a Capital Letter");
        }

        // Setting a variable and creating a loop to count the number of quotation marks within a string
        int quoteCount = 0;

        for (int x = 0; x < str.length(); x++) {
            if (str.charAt(x) == '"') {
                quoteCount++;
            }
        }

        // Applying the modulus operator with a value of 2 to the quoteCount variable to test for an even number of quotation marks
        if ((quoteCount % 2) == 0) {
            testsPassed++;
        }else{
            log.info("Sentence contains an uneven amount of Quotation Marks");
        }

        // Creating a Regex pattern and matcher to validate the last character of the string is either a . ! or ?
        Pattern test3 = Pattern.compile("([?.!]$)");
        Matcher matcher2 = test3.matcher(str);
        boolean suffixMatch = matcher2.find();

        // An if else statement to pass or fail the string based on the result of the
        // above Regex
        if (suffixMatch) {
            testsPassed++;
        }else{
            log.info("Sentence does not end with either . ! or ?");
        }

        // Setting a variable and creating a loop to count the number of . ! and ? within a string
        int periodCount = 0;

        for (int x = 0; x < str.length(); x++) {
            if (str.charAt(x) == '.' || str.charAt(x) == '?' || str.charAt(x) == '!') {
                periodCount++;
            }
        }

        // An if else statement to pass or fail the string based on the result of the above Regex
        //As I have separately tested to find a . ! or ? at the end of the sentence no false positives will occur if the only instance of one of these characters
        // occcurs outside the final character of the string
        if (periodCount < 2) {
            testsPassed++;
        }else{
            log.info("Sentence contains either . ! or ? before the termination of the sentence.");
        }

        // Creating a Regex pattern and matcher to find any numeric representations of the numbers 0-12
        Pattern test5 = Pattern.compile("(\b[0-9]\b|1[0-2])");
        Matcher matcher3 = test5.matcher(str);
        boolean numMatch = matcher3.find();

        // An if else statement to pass or fail the string based on the result of the above Regex
        if (numMatch == false) {
            testsPassed++;
        }else{
            log.info("Sentence contains the numeric format of a number below 13");
        }

        // A final if else statement using the test criteria (the testPassed variable) to output the result of the string based on whether all 5 tests have been passed
        if (testsPassed == 5) {
            passed = true;
            log.info("This Sentence Is Valid");
        }else{
            log.info("This Sentence Is Invalid");
        }

        return passed;
    }
}
