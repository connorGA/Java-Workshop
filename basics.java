import java.text.NumberFormat;
import java.util.Arrays; // import package for Arrays; using toString to take string identifier for address in memory of array object and parsing it to the actual array value
import java.util.Date;   // this is imported when we run package below(in reference types, we selected Date.util package)
import java.util.Scanner;

// HOW TO RUN CODE
    // first, check that file has a method called 'main' within the file class (in this case its 'Basics'). The Java Virtual Machine will execute the main method in the Basics class, and your program will run, printing the output to the terminal.
    // running code will only run whats in the main method, so if you want the later methods to run, call them inside of main method
    // in terminal, type 'javac <fileName>' so in this case we would type 'javac Basics.java'
        // this command will generate a '.class' file (e.g. 'Basics.class') containing the compiled bytecode of your java file
    // Run the compiled bytecode using the 'java' command, in this case 'java Basics'



class Main {         // defines class 'Main'
    void method() {    // method = function that belongs to a class
        //main
    }

    //MORTGAGE CALCULATOR
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        NumberFormat mortgageFormatted = NumberFormat.getCurrencyInstance();
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}

// In Java, classes and methods should have an "access modifier". 
// An access modifier is a special keyword that determines if other classes and methods can access those classes/methods
// Example: public, private, etc.

public class Basics {   // NOTE: the public type must be defined in its own file. So this works because the file and class are both called 'Basics'
    public static void main(String[] args) {
        
        IntegersClass.ages();
    }
}


// HOW JAVA CODE GETS EXECUTED

    // Two main steps = Compilation and Execution 
                    //- Source Code(.java) -> Java compiler -> Byte code(.class) -> Java Virtual Machine -> Native Code(Windows, Mac, etc)
class IntegersClass {
    public static void ages() {   // without 'static', when calling the ages method in another class you would get the error "Cannot make a static reference to the non-static method ages() from the type IntegersClassJava" This error occurs when you try to access a non-static method as if it were a static method. Non-static methods (also known as instance methods) belong to an instance of a class, and you need to create an object of the class to call them. Static methods, on the other hand, belong to the class itself and can be called without creating an object.
        int age = 30;             // initializing a variable, variable contains an int(4 bytes of memory) **NOTE- changing 'int' to 'byte' allows use to still store the 30, since bytes can range from [-128, 127], and it would only take up 1 byte of memory as opposed to the 4 bytes of memeory 'int' takes
        System.out.println(age);
    }

}

// TYPES
    // Primitive - for storing simple values (e.g. - numbers, characters, booleans)
                    //  Type    |      Bytes(memory)     |    Range
                    //------------------------------------------------
                    //  byte    |           1            |  [-128, 127]
                    //  short   |           2            |  [-32k, 32k]
                    //  int     |           4            |  [-2B, 2B]
                    //  long    |           8            |
                    //  float   |           4            |  for decimals
                    //  double  |           8            |  for decimals
                    //  char    |           2            |  A, B, C, ...
                    //  boolean |           1            |  true / false
    // Reference - for storing complex objects(e.g. - date, mail message)

class Types {
    public static void primitiveTypes() {
        byte age = 30;
        long viewCount = 3_123_543L; // when using long, must add suffix "L (or l)" to end. Also, can use _ to seperate numbers instead of ',' to make it easier to read
        float price = 10.99F;        // similar to long, java recognizes decimals as 'doubles', however we want to use float in this case because it takes up less memory but still provides the necessary range, so we have to add the 'F' suffix to the end
        char letter = 'A';
        boolean isElible = true;
    }

    public static void referenceTypes() {
        Date theDate = new Date();         // always allocate memory for reference type, use 'new' operator to allocate memory for this variable. We dont have to determine how much memorky to allocate, java runtime system will do it automatically
                                           // 'theDate' is an instance of the Date class (its an object)
        theDate.getTime();
    }
}

// STRINGS

class Strings {                                                  // Strings are reference types in java. They are also immutable(cant change them). So, string methods will always return new strings
    public static void strings() {
        String message = "hello world" + "!" ;                   // String class defined in java.lang package(automatically imported)
                                                                 // because this is a reference type, we would have to instatiate variable with 'new' operator. However, strings are reference types in java so "hello world" would function the same as new String(hello world)
        System.out.println(message);
    
        // Escape Sequences
        String templateLiteral = "hi \"Connor\"";               // this would return `hi "Connor"`
                                                                // \n would create a new line wherver placed in string. \t would add tab spacing wherver placed
    }
}
    // Common string methods
        // message.endsWith("!")  = true
        // message.startsWith("!") = false
        // message.length() = 12
        // message.indexOf("h") = 0
        // message.indexOf("sky") = -1 
        // message.replace(target: "!", replacement: "?")   NOTE: method doesnt modify original string, it creates a new one
        // message.toLowerCase()
        // message.toUpperCase()
        // message.trim()        *Removes white spaces at beginning or end of string, useful for form inputs

// ARRAYS


class Arraysss {
    public static void learnArrays() {
        int[] numbers = new int[5];     // new operator because arrays aren't reference types. The '5' in brackets indicates size of array
        numbers[0] = 1;
        numbers[1] = 2;                 // can specify values for specific index of array

        //Better way to initialize array
        int[] newNumbers = {1, 9, 3, 2, 5};     // NOTE: in Java arrays have a fixed size, so once we create them we cannot add or remove items (need to use collection class to alter array)
        Arrays.sort(newNumbers);  // would return {1, 2, 3, 5, 9}

        System.out.println(Arrays.toString(numbers));  // without 'Arrays.toString', Java returns a string based on address of this object in memory, so it would be a jumbled looking string, not the actual array data
                                                       // Array would look like [1,2,0,0,0] since we set the [0] and [1] index to those values, but didnt set anything for the remaining three indices
    }
}

// Multi-dimensional Arrays
   
class multiDimArray {
    public static void multiDimArrays() {
        int[][] numbers = new int[2][3];    // multidimensional array with 2 rows and three columns
        numbers[0][0] = 1;                  // array would print as [[1,0,0], [0,0,0]]

        //Curly brace snytax
        int[][] nums = { {1,2,3}, {4,5,6} };

        System.out.println(Arrays.deepToString(numbers));   //'deepToString' functions same as 'toString' did for one dimenstinoal arrays above, however is intended for multidimensinoal arrays

    }
}


// CONSTANTS

class constants{
    public static void constant() {
       final float PI = 3.14F;          // by adding 'final', Java compilier will treat this variable as a constant, and throw an error if pi is set equal to another value later on
    }                                   // best practice is to name constant variabls in all caps
}

// ARITHMETIC EXPRESSIONS

class arithmeticExpressions {
    public static void artith() {       
        int result = 10 + 3;           // subtraction and multiplication also work how expected, division a little different
        int divisResult = 10 / 3;      // would return 3, because in Java division of two whole numbers is a whole number
    // double divisResult = (double)10 / (double)3;    ****correct way
        int x = 1;
        x++; // increment by 1, so x would return 2
        System.out.println(result);

    }
}

// THE MATH CLASS

class mathClass{
    public static void math() {
       int result =  Math.round(1.1F); // rounds to nearest whole number
       int result2 = (int)Math.ceil(1.1F); // returns 2, nearest cieling. the .floor method would return 1
       int result3 = Math.max(1,2); // return the greater of the numbers, 2. Can also use .min
       double result4 = Math.random(); //returns random decimal between 0 and 1. Doing Math.random() * 100 would do numbers from 1 - 100 
    }
}

// CONTROL FLOW ----------

//Comparison Operators

class comparisonOps {
    public static void compare() {
        int x = 1;
        int y = 1;
        System.out.println(x == y);  // should return true
                                     // != , <, >, <=, >= all work as expected
    }
}

//Logical Operators

class logicalOps {
    public static void logic() {
       int temperature = 22;
       boolean isWarm = temperature > 20 && temperature < 30;   // && this is the 'and' operator. The 'or' operator is ||
       System.out.println(isWarm);  // would return true, if temp was 12 for example, it would be false. Java evaulates expression from left to right
    }
}

//Conditional Statements

class ifStatements{
    public static void ifStates() {
        int temp = 32;
        if (temp > 30){
            System.out.println("It's a hot day");           //NOTE only needed to use braces when code block more than one line to make cleaner, not required to put curlys like you would in javascript
        } 
        else if (temp > 20 && temp <= 30)
            System.out.println("Beautiful day");
        else 
            System.out.println("Cold day");
    }
}

//The Ternary Operator

class ternary {
    public static void tern() {
        int income = 120_000;
        String className = income > 100_000 ? "First" : "Economy";  // checks condition at beginning, if condition is true, first value is returned, else it would be the latter variable 'Economy'
                                            //ternary operator saves trouble of doing a conditional. ( conditional ? "iftrue" : "iffalse";)
    }
}


// Switch Statements

class switchStatements {
    public static void switchy() {
        String role = "admin";

        switch (role) {
            case "admin":
                System.out.println("Youre an admin");
                break;
            case "moderator":
                System.out.println("Youre a moderator");
                break;
            default:
                System.out.println("Youre a guest");
        }

        //Switch statement above works like this conditional:
        // if (role == "admin")
        //     System.out.println("Youre an admin");
        // else if (role == "moderator")
        //     System.out.println("You are a moderator");
        // else 
        //     System.out.println("Youre a guest");
    }
}

// Fizzbuzz 

class fizzBuzz {
    public static void fizzbuzz(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int number = scanner.nextInt();

        if (number % 5 == 0 && number % 3 == 0)
            System.out.println("Fizzbuzz");
        else if (number  % 5 == 0)
            System.out.println("Fizz");
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else 
            System.out.println(number);
    }
}

// For loops

class loops{
    public static void loopin() {
        for (int i = 0; i < 5; i++){                // for loop similar to javascript, just make sure you define the type of the variable(in this case int)
            System.out.println("Hello world");
            System.out.println(i);
        }
    }
}

// While loops

class whileloop{                                    // while loops useful when we dont know how many times we are going to repeat something
    public static void looper() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("quit")) {
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }
        // do while loop
        do {                                            // always get executed at least once, even if condition is false
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        } while (!input.equals("quit"));
        }
    }
  
// For Each Loop

class foreaches{
    public static void foreachloopers() {
        String[] fruits = {"Apple", "Mango", "Orange"};

        for (String fruit: fruits)
            System.out.println(fruit);              // prints "Apple" "Mango" "Orange"
    }
}