import java.util.Random;
import java.util.Scanner;

public class SemesterProject_Julian_Spindola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Declaring Scanner object to accept input

        int passwordLength = 0; //Declaring and initializing variable passwordLength as type int
        String userChoice; //Declaring variable userChoice as type String
        boolean choice1, choice2, choice3; //Declaring 3 boolean variables

        System.out.println("Do you want letters, yes or no: "); //Prompt user
        userChoice = input.next(); //Obtains user input and assigns it to variable userChoice
        choice1 = userChoice.equalsIgnoreCase("yes"); //if user enters "yes," boolean variable choice1 is set to true

        System.out.println("Do you want numbers, yes or no: "); //Prompt user
        userChoice = input.next(); //Obtains user input and assigns it to variable userChoice
        choice2 = userChoice.equalsIgnoreCase("yes"); //if user enters "yes," boolean variable choice2 is set to true

        System.out.println("Do you want special characters, yes or no: "); //Prompt user
        userChoice = input.next(); //Obtains user input and assigns it to variable userChoice
        choice3 = userChoice.equalsIgnoreCase("yes"); //if user enters "yes," boolean variable choice3 is set to true

        System.out.println("Please enter length of password: "); //Prompt user
        passwordLength = input.nextInt(); //Obtains user input and assigns it to variable passwordLength

        System.out.println("Your generated password is: " + generatePassword(passwordLength, choice1, choice2, choice3)); //Prints out generated password
    }

    public static int choice(boolean choice1, boolean choice2, boolean choice3){ //Method declaration. Determines whether to generate a letter, number, or special character.
        Random rand = new Random(); //Creating random object to generate random numbers

        int number = 0;
        int choice = 0;

        if (choice1){ //If user enters "yes" for first prompt
            if(choice2){ //If user enters "yes" for second prompt
                if(choice3){ //If user enters "yes" for third prompt
                    choice = 1 + rand.nextInt(3); //random number is generated from 1-3 and assigned to choice variable
                }
                else { //if user enters "no" for third prompt
                    choice = 1 + rand.nextInt(2); //random number is generated from 1-2 and assigned to choice variable
                }
            }
            else { //If user enters "no" for second prompt
                if (choice3){ //If user enters "yes" for third prompt
                    number = rand.nextInt(2); //random number, either 0 or 1 is generated
                    if (number == 0) { //If number is 0
                        choice = 1; //Choice is set to 1
                    }
                    if (number == 1) { //If number is 1
                        choice = 3; //Choice is set to 2
                    }
                }
                else { //If user enters no for third prompt
                    choice = 1; //choice is assigned value of 1
                }
            }
        }
        else { //If user enters "no" for first prompt
            if (choice2){ //if user enters "yes" for second prompt
                if (choice3){ //if user enters "yes" for second prompt
                    choice = 2 + rand.nextInt(2); //choice is assigned value 2-3
                }
                else { // If user enters "no" for third prompt
                    choice = 2; //choice is assigned value of 2
                }
            }
            else { // Is user enters "no" for second prompt
                choice = 3; //choice is assigned to value 3 as a false-false-false condition
            }
        }

        return choice; //Value of variable choice is returned
    }

    public static String generatePassword(int passwordLength, boolean choice1, boolean choice2, boolean choice3){ //Method declaration. Password is generated depending on choices given by user
        Random rand = new Random(); //Creating random object to generate random numbers

        char[] passwordArray = new char[passwordLength]; //New array of data type char is created with length specified by user

        for (int i = 0; i < passwordLength; i++){ //For loop
            int numberChoice = choice(choice1, choice2, choice3); //Value returned from "choice" method is assigned to variable
            int capitalization = rand.nextInt(2); //Capitalization variable is created to determine whether to capitalize letter. Generates either 0 or 1
            if (numberChoice == 1){ //If choice "letter" is created
                int generatedNumber; //generatedNumber variable is initialized as type int
                if(capitalization == 1){ //If capitalization is equal to 1
                    generatedNumber = 65 + rand.nextInt(26); //uppercase letter unicode value is generated
                }
                else{ //If capitalization is equal to 0
                    generatedNumber = 97 + rand.nextInt(26); //lowercase letter unicode value is generated
                }
                passwordArray[i] = (char) generatedNumber; //generated letter value is cast to char data type, and assigned to passwordArray[i]

            }
            else if (numberChoice == 2){ //If choice "number" is created
                int generatedNumber = 48 + rand.nextInt(9); //Digit 0-9 is created
                passwordArray[i] = (char) generatedNumber; //Generated digit is cast to char data type, and assigned to passwordArray[i]
            }
            else { //If choice "special character" is created
                int generatedNumber = 33 + rand.nextInt(14); //Generated special character unicode value is generated
                passwordArray[i] = (char) generatedNumber; //Generated special character unicode value is cast to char data type, and assigned to passwordArray[i]
            }
        }
        return String.valueOf(passwordArray); //Once loop is completed, String of array values is returned to user.
    }
}