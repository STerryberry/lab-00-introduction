package ca.uwo.eng.se2205b;

/**
 * Problem #1: FizzBuzz
 */
public class FizzBuzz {

    /**
     * Driver method for FizzBuzz
     * @param args
     */
    public static void main(String[] args) {
        for(int i=1; i<=100; i++) {
            if ((i%5==0) && (i%3==0)) {
                System.out.println(i + " Fizzbuzz  ");
            }
            else if (i%5==0){
                System.out.println(i + " Buzz  ");
            }
            else if (i%3==0) {
                System.out.println(i + " Fizz  ");
            }
            else {
                System.out.println(i + "  ");
            }
        }
    }

}
