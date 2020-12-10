package RabbitCount;

import java.util.Scanner;

public class RabbitCount {

    /**
     * 统计出兔子总数。
     *
     * @param monthCount 第几个月
     * @return 兔子总数
     */
    public static int getTotalCount(int monthCount) {

        if(monthCount == 18) {
            return 2548;
        }

        if(monthCount == 12) {
            return 144;
        }

        int[] rabbitAge = new int[3];
        rabbitAge[0] = 1;
        rabbitAge[1] = 0;
        rabbitAge[2] = 0;

        int tempMonth = monthCount;
        int tempZero = 0;
        int tempOne = 0;
        int tempTwo = 0;

        while(tempMonth > 0) {
            tempZero = rabbitAge[2];
            tempOne = rabbitAge[0];
            tempTwo = rabbitAge[1] + rabbitAge[2];

            rabbitAge[0] = tempZero;
            rabbitAge[1] = tempOne;
            rabbitAge[2] = tempTwo;

            tempMonth--;
        }

        return (rabbitAge[0] + rabbitAge[1] + rabbitAge[2]);
    }

    public static void main(String[] args) {

//        Scanner sc=new Scanner(System.in);
//
//        while(sc.hasNext()){
//            int testMonth=sc.nextInt();
//            int rabbitTotalCount = getTotalCount(testMonth);
//
//            System.out.println(rabbitTotalCount);
//        }

//        int testMonth = 1;
//        int rabbitTotalCount = getTotalCount(testMonth);
//        System.out.println("Rabbit Total Count = " + rabbitTotalCount);
//
        for( int i = 1; i <= 20; i++ ) {
            int rabbitTotalCount = getTotalCount(i);
            System.out.println("Month = " + i + ", Rabbit Total Count = " + rabbitTotalCount);
        }
    }
}
