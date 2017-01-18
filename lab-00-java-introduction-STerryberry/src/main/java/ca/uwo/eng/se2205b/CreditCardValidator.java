package ca.uwo.eng.se2205b;
import java.util.Scanner;

/**
 * Problem #3: Validates a Credit Card
 */

public class CreditCardValidator {

    public enum Card{
        VISA, MASTER, AMERICAN, DISCOVERY, NULL
    }

    Card card;

    public CreditCardValidator(Card card){

        this.card = card;
    }

    public void cardCheck(){
        switch (card){
            case VISA:
                System.out.println("The number is valid, and the card type is a Visa card.");
                break;
            case MASTER:
                System.out.println("The number is valid, and the card type is a Master card.");
                break;
            case AMERICAN:
                System.out.println("The number is valid, and the card type is an American Express card.");
                break;
            case DISCOVERY:
                System.out.println("The number is valid, and the card type is a Discovery card.");
                break;
            case NULL:
                System.out.println("The number is invalid.");
                break;
        }
    }

    /**
     * Compute if the number is a valid Credit Card Number.
     * @param //number Credit Card number to validate.
     * @return Non-{@code null} enum of the type of credit card.
     */
    public static void main(String[] args) {
        inputs();
        checkNums();
    }

    private static void inputs() {
        System.out.println("Input your credit card number: ");
        Scanner scan = new Scanner(System.in);
        long number = scan.nextLong();
        validate(number);
    }

    private static void checkNums(){
        long num = 54321L;
        validate(num);
        num = 4388576018402626L;
        validate(num);
        num = 4111111111111111L;
        validate(num);
        num = 5500000000000004L;
        validate(num);
        num = 340000000000009L;
        validate(num);
    }

    private static void validate(long number) {
        long length = (long)(Math.log10(number)+1);
        long tempLength = length;
        String sNum = Long.toString(number);
        int cardSum = 0;
        int index = 0;
        if ((length > 12)&&(length < 17)){
            while (tempLength > 0) {
                if (index % 2 == 0) {
                    cardSum = cardSum + Character.getNumericValue(sNum.charAt(index));
                } else {
                    cardSum = cardSum + (Character.getNumericValue(sNum.charAt(index)) * 2);
                }
                tempLength--;
                index++;
            }
            if (cardSum%10==0){
                if (Character.getNumericValue(sNum.charAt(0))==4){
                    CreditCardValidator validation = new CreditCardValidator(Card.VISA);
                    validation.cardCheck();
                }
                else if (Character.getNumericValue(sNum.charAt(0))==5){
                    CreditCardValidator validation = new CreditCardValidator(Card.MASTER);
                    validation.cardCheck();
                }
                else if ((Character.getNumericValue(sNum.charAt(0))==3) && (Character.getNumericValue(sNum.charAt(1))==4)){
                    CreditCardValidator validation = new CreditCardValidator(Card.AMERICAN);
                    validation.cardCheck();
                }
                else if (Character.getNumericValue(sNum.charAt(0))==6){
                    CreditCardValidator validation = new CreditCardValidator(Card.DISCOVERY);
                    validation.cardCheck();
                }
                else{
                    CreditCardValidator validation = new CreditCardValidator(Card.NULL);
                    validation.cardCheck();
                }
            }
            else{
                CreditCardValidator validation = new CreditCardValidator(Card.NULL);
                validation.cardCheck();
            }
        }
        else{
            CreditCardValidator validation = new CreditCardValidator(Card.NULL);
            validation.cardCheck();
        }

    }

}
