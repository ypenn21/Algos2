package com.yanni.test.snapchat;

public class SnapChatPhone {

    static final Integer NUMBER = 100;

    public static void printDigits( Integer number ) {
        for (Integer a = 1; a<number; a++) {
            int[] bucket = new int[10];
            Integer b = number-a;
            String twoDigNumB = b.toString();
            String twoDigNumA = a.toString();
            char[] arrayB =twoDigNumB.toCharArray();
            char[] arrayA =twoDigNumA.toCharArray();
            if(isDupDigits( b , arrayB, bucket ) || isDupDigits( a , arrayA, bucket )){
                continue;
            }
            System.out.println("a "+a+" b "+b);
        }

    }

    public static boolean isDupDigits( int numberIntForm , char[] number, int[] bucket ) {
        boolean isDup = false;
        if(number.length>1) {
            for(int i=0;i<number.length; i++ ){
                bucket[Integer.parseInt(number[i]+"")]++;
                if(bucket[Integer.parseInt(number[i]+"")]>1){
                    isDup = true;
                    break;
                }
            }
        } else {
            bucket[numberIntForm]++;
            if(bucket[numberIntForm]>1) {
                isDup = true;
            }
        }
        return isDup;

    }

    public static void main(String args[] ) throws Exception {
        printDigits( 100 );
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        for (Integer a = 1; a<NUMBER; a++) {
//            int[] bucket = new int[10];
//            Integer b = NUMBER-a;
//            String twoDigNumB = b.toString();
//            String twoDigNumA = a.toString();
//            boolean print = false;
//            if(twoDigNumB.length()>1) {
//                char[] arrayB =twoDigNumB.toCharArray();
//                bucket[Integer.parseInt(arrayB[0]+"")]++;
//                bucket[Integer.parseInt(arrayB[1]+"")]++;
//                if(bucket[Integer.parseInt(arrayB[0]+"")] >1) {
//                    continue;
//                }
//                if(bucket[Integer.parseInt(arrayB[1]+"")]>1){
//                    continue;
//                };
//                System.out.println("a "+Integer.parseInt(arrayB[0]+"")+" b "+Integer.parseInt(arrayB[1]+"") +" print "+ print);
//            } else {
//                bucket[b]++;
//                if(bucket[b]>1) {
//                    continue;
//                }
//            }
//
//            if(twoDigNumA.length()>1) {
//                char[] arrayA =twoDigNumA.toCharArray();
//                bucket[Integer.parseInt(arrayA[0]+"")]++;
//                bucket[Integer.parseInt(arrayA[1]+"")]++;
//                if(bucket[Integer.parseInt(arrayA[0]+"")] >1) {
//                    continue;
//                }
//                // print =Integer.parseInt(arrayA[0]+"") >1 ? false : true;
//                if(bucket[Integer.parseInt(arrayA[1]+"")] >1) {
//                    continue;
//                }
//                System.out.println("a "+Integer.parseInt(arrayA[0]+"")+" b "+Integer.parseInt(arrayA[1]+"") +" print "+ print);
//            } else {
//                bucket[a]++;
//                if(bucket[a] >1) {
//                    continue;
//                }
//            }
//            System.out.println("a "+a+" b "+b);
    }
}
