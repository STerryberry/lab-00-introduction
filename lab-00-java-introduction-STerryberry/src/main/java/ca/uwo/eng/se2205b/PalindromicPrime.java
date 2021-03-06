package ca.uwo.eng.se2205b;

import java.util.Iterator;

    /**
     * Creates an iterator that returns prime palindrome numbers.
     *
     * @return Non-{@code null} iterator to get palindrome prime numbers.
     */

public class PalindromicPrime implements Iterable<Integer> {
    private int counter = 0;
    private int max;

        public PalindromicPrime(int max) {
            this.max = max;
        }

        public Iterator<Integer> iterator() {
            Iterator<Integer> itr = new palindromeIterator(max);
            return itr;
        }

        private class palindromeIterator implements Iterator<Integer> {
            private int max;
            private int p;

            public palindromeIterator(int max) {
                this.max = max;
                p = 2;
            }

            private int nextPrime() {
                while (true) {
                    p++;
                    if (p <= 3) {
                        counter ++;
                        return p;
                    }
                    if (isPrime(p) == true && isPalindrome(p) == true){
                        counter ++;
                        return p;
                    }
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            @Override
            public boolean hasNext() {
                if (counter < max){
                    return true;
                }
                else{
                    return false;
                }
            }
            @Override
            public Integer next() {
                int prev = p;
                nextPrime();
                return prev;
            }
        }

        public static void main(String[] args) {
            Iterable<Integer> primes = new PalindromicPrime(100);
            Iterator<Integer> primeIter = primes.iterator();
            while (primeIter.hasNext()) {
                int i = 0;
                while (i < 10) {
                    System.out.print(primeIter.next());
                    System.out.print("\t");
                    i++;
                }
                System.out.println("  ");
            }
        }

        public static boolean isPrime(int num) {
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isPalindrome(int num) {
            String sNum = Integer.toString(num);
            int length = (int) (Math.log10(num) + 1);
            int tempLength = length;
            if (tempLength > 2) {
                for (int k = 0; k < (length / 2); k++) {
                    if ((Character.getNumericValue(sNum.charAt(k))) == (Character.getNumericValue(sNum.charAt(tempLength-1)))) {
                        tempLength--;
                    } else {
                        return false;
                    }
                }
                return true;
            }
            else if (tempLength == 2){
                if ((Character.getNumericValue(sNum.charAt(0))) == (Character.getNumericValue(sNum.charAt(1)))) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else{
                return true;
            }
        }
    }