package UglyNumber;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class UglyNumber {

    // static TreeSet<Integer> uglyNumberSet = new TreeSet<>();
    static HashSet<Integer> uglyNumberSet = new HashSet<>(10000);
    // static HashSet<Integer> nonUglyNumberSet = new HashSet<>(10000);
    // static HashMap<Integer, Boolean> resultNumberMap = new HashMap<>(10000);

    static boolean isContainFactor(int number, int factor) {
        return (number % factor) == 0;
    }

    static boolean isUglyNumber(int number) {
        if(isContainFactor(number, 2)) {
            if(isUglyNumber(number/2)) {
                return true;
            }
            return false;
        }

        if(isContainFactor(number, 3)) {
            if(isUglyNumber(number/3)) {
                return true;
            }
            return false;
        }

        if(isContainFactor(number, 5)) {
            if(isUglyNumber(number/5)) {
                return true;
            }
            return false;
        }

        if (number > 1) {
            return false;
        }

        if (number == 1) {
            return true;
        }

        return false;
    }

    public static int GetUglyNumber_Solution(int index) {
        int countUglyNumber = 0;
        int result = 1;
        int i = 0;

        while(true){
            i++;
            if(isUglyNumber(i)) {
                countUglyNumber++;
                // System.out.println("count = " + countUglyNumber + ", i = " + i);

                if(countUglyNumber == index) {
                    result = i;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World !");
        int index = 1000;

        Instant start_New = Instant.now();
        int result_New = GetUglyNumber_Solution_New(index);
        // System.out.println("uglyNumberSet size = " + uglyNumberSet.size());
        Instant end_New = Instant.now();

        System.out.println("result_New: " + result_New);
        long timeElapsed_New = Duration.between(start_New, end_New).toMillis();  //in millis
        System.out.println("Time: " + timeElapsed_New + " millis");

        System.out.println(" ----------------------------- ");

        Instant start = Instant.now();
        // int result = GetUglyNumber_Solution(index);
        int result = generateUglyNumber(index);
        Instant end = Instant.now();

        System.out.println("result: " + result);
        long timeElapsed = Duration.between(start, end).toMillis();  //in millis
        System.out.println("Time: " + timeElapsed + " millis");




    }


    private static int generateUglyNumber(int index) {
        // 一共有 3个 因子 factors
        // 2, 3, 5

        // 保存 丑数 的数组（从小到大）
         ArrayList<Integer> uglyNumberArray = new ArrayList<>();
        // ArrayList<int> uglyNumberArray = new ArrayList<>();

        // 3个因子的 对应的 在数组中的下标位置
        int positionTwo = 0;
        int positionThree = 0;
        int positionFive = 0;

        // 用作 临时保存和比较的 TreeMap，可以方便从 三个候选的丑数 中，选择最小的 丑数。
        TreeMap<Integer, Integer> compareTreeMap = new TreeMap<>();
        // TreeMap<int, int> compareTreeMap = new TreeMap<>();

        // 先将第一个 丑数 加入ArrayList中
        uglyNumberArray.add(1);

        // 接着 计算3个 候选的 丑数，放入临时的 Tree Map 中
        int newPotential_UglyNumber = 0;

        newPotential_UglyNumber = 2 * uglyNumberArray.get(positionTwo);
        compareTreeMap.put(newPotential_UglyNumber, 2);     // (Key = 2, Value = 2）

        newPotential_UglyNumber = 3 * uglyNumberArray.get(positionThree);
        compareTreeMap.put(newPotential_UglyNumber, 3);     // (Key = 3, Value = 3）

        newPotential_UglyNumber = 5 * uglyNumberArray.get(positionFive);
        compareTreeMap.put(newPotential_UglyNumber, 5);     // (Key = 5, Value = 5）


        int min_UglyNumber = 0;
        int minUglyNumber_Factor = 0;

        while(uglyNumberArray.size() < index) {

            // 提取了 最小的丑数 放进 数组中，并且 删除临时 TreeMap 中的对应的元素。
            min_UglyNumber = compareTreeMap.firstKey();
            minUglyNumber_Factor = compareTreeMap.get(min_UglyNumber);
            uglyNumberArray.add(min_UglyNumber);
            // System.out.println("min_UglyNumber: " + min_UglyNumber);
            compareTreeMap.remove(min_UglyNumber);

            // 然后对应的 因子的位置 向前加一, 再计算 它对应的 新的 候选丑数，然后放进 TreeMap 中。
            switch(minUglyNumber_Factor) {
                case 2:
                    positionTwo++;
                    newPotential_UglyNumber = 2 * uglyNumberArray.get(positionTwo);

                    // 如果 TreeMap 中已经存在 相同的 候选丑数，就只能继续 向前移动因子的位置，重新计算新的 候选丑数。
                    while(compareTreeMap.containsKey(newPotential_UglyNumber)) {
                        positionTwo++;
                        newPotential_UglyNumber = 2 * uglyNumberArray.get(positionTwo);
                    }

                    compareTreeMap.put(newPotential_UglyNumber, 2);
                    break;

                case 3:
                    positionThree++;
                    newPotential_UglyNumber = 3 * uglyNumberArray.get(positionThree);

                    while(compareTreeMap.containsKey(newPotential_UglyNumber)) {
                        positionThree++;
                        newPotential_UglyNumber = 3 * uglyNumberArray.get(positionThree);
                    }

                    compareTreeMap.put(newPotential_UglyNumber, 3);
                    break;

                case 5:
                    positionFive++;
                    newPotential_UglyNumber = 5 * uglyNumberArray.get(positionFive);

                    while(compareTreeMap.containsKey(newPotential_UglyNumber)) {
                        positionFive++;
                        newPotential_UglyNumber = 5 * uglyNumberArray.get(positionFive);
                    }

                    compareTreeMap.put(newPotential_UglyNumber, 5);
                    break;

            }
        }

        // uglyNumberArray.forEach(System.out::println);
        // 返回 丑数数组 的第N个 丑数(index-1)。
        if(index == 0) {
            return 0;
        } else {
            return uglyNumberArray.get(index-1);
        }
    }



    private static int GetUglyNumber_Solution_New(int index) {

        if(index == 0) {
            return 0;
        }

        int countUglyNumber = 0;
        int result = 1;
        int i = 0;

        while(true){
            i++;
            if(isUglyNumber_New(i)) {
                // 将 丑数 加入集合 uglyNumberSet 中
                uglyNumberSet.add(i);
                // resultNumberMap.put(i, true);

                countUglyNumber++;
                // System.out.println("count = " + countUglyNumber + ", i = " + i);

                if(countUglyNumber == index) {
                    result = i;
                    break;
                }
            }
//            else {
//                // 将 非丑数 加入集合 nonUglyNumberSet 中
//                // nonUglyNumberSet.add(i);
//                resultNumberMap.put(i, false);
//            }
        }

        return result;
    }


    static boolean isUglyNumber_New(int number) {
        if(isContainFactor(number, 2)) {
            int new_Number = number/2;
//            if(resultNumberMap.get(number/2)) {
//                return true;
//            } else {
//                return false;
//            }
            if(uglyNumberSet.contains(new_Number)) {
                return true;
            }
//            else {
//                if(nonUglyNumberSet.contains(new_Number)){
//                    return false;
//                }
            return false;
//            }
        }

        if(isContainFactor(number, 3)) {
            int new_Number = number/3;
//            if(resultNumberMap.get(number/3)) {
//                return true;
//            } else {
//                return false;
//            }
            if(uglyNumberSet.contains(new_Number)) {
                return true;
            }
//            } else {
//                if(nonUglyNumberSet.contains(new_Number)){
//                    return false;
//                }
            return false;
//            }
        }

        if(isContainFactor(number, 5)) {
            int new_Number = number/5;
//            if(resultNumberMap.get(number/5)) {
//                return true;
//            } else {
//                return false;
//            }
            if(uglyNumberSet.contains(new_Number)) {
                return true;
            }
//            } else {
//                if(nonUglyNumberSet.contains(new_Number)){
//                    return false;
//                }
            return false;
//            }
        }

        if (number > 1) {
            return false;
        }

        if (number == 1) {
            return true;
        }

        return false;
    }
}
