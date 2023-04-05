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
    // Primitive - for storing simple values
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
    // Reference - for storing complex objects

class Types {
    public static void types() {
        byte age = 30;
        long viewCount = 3_123_543L; // when using long, must add suffix "L (or l)" to end. Also, can use _ to seperate numbers instead of ',' to make it easier to read
        float price = 10.99F;        // similar to long, java recognizes decimals as 'doubles', however we want to use float in this case because it takes up less memory but still provides the necessary range, so we have to add the 'F' suffix to the end
        char letter = 'A';
        boolean isElible = true;
    }
}