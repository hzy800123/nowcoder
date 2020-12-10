package CutRope;

public class CutRope {
    public static void main(String[] args) {
        // E.g.
        // target = 2, result = 1
        // target = 3, result = 2
        // target = 4, result = 4   ( 2, 2 )        // % 3 = 1  ->  3x, 2, 2
        // target = 5, result = 6   ( 3, 2 )        // % 3 = 2  ->  3x, 2
        // target = 6, result = 9   ( 3, 3 )        // % 3 = 0  ->  3x
        // target = 7, result = 12  ( 3, 2, 2 )
        // target = 8, result = 18  ( 3, 3, 2 )
        // target = 9, result = 27  ( 3, 3, 3 )
        // target = 10, result = 36 ( 3, 3, 2, 2 )
        // target = 11, result = 54 ( 3, 3, 3, 2 )
        // target = 12, result = 81 ( 3, 3, 3, 3 )

        String s1 = "1";
        int i2 = 2;

        Integer integer1 = new Integer(s1);
        i2 = integer1.intValue();
        String s2 = String.valueOf(i2);






        System.out.println("Compare Result: " + s1.equalsIgnoreCase(s2));
        System.out.println("Compare Result: " + (s1 == s2));
        // s1 == s2 ???


        int target = 4;
        //int result = cutRope(target);
        for( int i = 2; i <= 12; i++ ) {
            System.out.println("target = " + i + ", result = " + cutRope(i));
        }
        // System.out.println("result: " + result);
    }

    public static int cutRope(int target) {



        // E.g.
        // target = 2, result = 1
        // target = 3, result = 2
        // target = 4, result = 4   ( 2, 2 )        // % 3 = 1  ->  3x, 2, 2
        // target = 5, result = 6   ( 3, 2 )        // % 3 = 2  ->  3x, 2
        // target = 6, result = 9   ( 3, 3 )        // % 3 = 0  ->  3x
        // target = 7, result = 12  ( 3, 2, 2 )
        // target = 8, result = 18  ( 3, 3, 2 )
        // target = 9, result = 27  ( 3, 3, 3 )
        // target = 10, result = 36 ( 3, 3, 2, 2 )
        // target = 11, result = 54 ( 3, 3, 3, 2 )
        // target = 12, result = 81 ( 3, 3, 3, 3 )

        if (target <= 3) {
            return target - 1;
        }

        int remainingPart = target % 3;
        int times;
        int partialResult;
        int finalResult = 0;

        switch (remainingPart) {
            case 0:
                times = target / 3;
                partialResult = (int) Math.pow(3, times);
                finalResult = partialResult;
                break;

            case 1:
                times = (target - 2 - 2) / 3;
                partialResult = (int) Math.pow(3, times);
                finalResult = partialResult * 2 * 2;
                break;

            case 2:
                times = (target - 2) / 3;
                partialResult = (int) Math.pow(3, times);
                finalResult = partialResult * 2;
                break;
        }

        return finalResult;
    }
}
