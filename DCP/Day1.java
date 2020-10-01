package DCP;

import java.util.HashSet;
/**
 * Problem : Given a list of numbers and a number k,
 * return whether any two numbers from the list add up to k
 */

class Day1 {

    /**
     * This method uses hashing approach
     * TC: O(n)
     * SC: O(n)
     */
    private static boolean hasSumK(int[] arr, int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i: arr) {
            if (set.contains(k-i))
                return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {10, 15, 3, 7};
        int k = 17;
        if (hasSumK(arr, n, k))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}