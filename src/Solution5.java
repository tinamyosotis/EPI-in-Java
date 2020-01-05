import java.util.Collections;
import java.util.List;

public class Solution5 {
    //    time complexity is O(n), the space complexity is O(1)
    public static void evenOdd(List<Integer> A) {
        int nextEven = 0, nextOdd = A.size() - 1;
        while (nextEven < nextOdd) {
            if (A.get(nextEven) % 2 == 0) {
                nextEven++;
            } else {
                swap(A, nextEven, nextOdd--);
            }
        }
    }

    public static void swap(List<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    public enum Color {RED, WHITE, BLUE}

    public static void dutchFlagPartition(int pivotIdx, List<Color> A) {
        Color pivot = A.get(pivotIdx);
        //        group the smaller elements
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(j).ordinal() < pivot.ordinal()) {
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }
        //        group the elements larger than pivot
        for (int i = A.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(j).ordinal() > pivot.ordinal()) {
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }
    }

    public static void dutchFlagPartition2(int pivotIdx, List<Color> A) {
        Color pivot = A.get(pivotIdx);
        int smaller = 0, equal = 0, larger = A.size() - 1;
        while (equal < larger) {
            if (A.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(A, smaller++, equal++);
            } else if (A.get(equal).ordinal() == pivot.ordinal()) {
                equal++;
            } else {
                Collections.swap(A, larger--, equal);
            }
        }
    }

    public static double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, res = Double.MIN_VALUE;
        for (Double price : prices) {
            res = Math.max(res, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return res;
    }

//    public static List<Integer> matrixSpiralOrder(List<List<Integer>> m) {
//
//    }
}
