package DCP;

/**
 * Problem: Given an array of integers,
 * return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i.
 * NOTE: Should not use division operator
 */

public class Day2 {
    
    /**
     * We compute the product array by initially computing the prefix products for each element,
     * then we compute the suffix product and multiply it with the prefix products to get the product array
     */
    private static long[] getProductArray(int[] arr, int n) {
        long[] productArray = new long[n];
        long prefixProduct = 1;
        for (int i = 0; i < n; ++i) {
            productArray[i] = prefixProduct;
            prefixProduct *= arr[i];
        }
        long suffixProduct = 1;
        for (int i = n-1; i >= 0; --i) {
            productArray[i] *= suffixProduct;
            suffixProduct *= arr[i];
        }
        return productArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 5;
        long[] productArray = getProductArray(arr, n);
        for (Long i: productArray)
            System.out.print(i + " ");
    }
}
