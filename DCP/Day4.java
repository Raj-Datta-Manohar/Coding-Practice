package DCP;

public class Day4 {

    private static int getLowestMissingPositive() {
        int positiveBegin = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] <= 0) {
                arr[positiveBegin] ^= arr[i];
                arr[i] ^= arr[positiveBegin];
                arr[positiveBegin] ^= arr[i];
                ++positiveBegin;
            }
        }
        for (int i = 0; i < n; ++i) {
            int k = Math.abs(arr[i]);
            if (k-1 < n && arr[k-1] > 0)
                arr[k-1] = -1*arr[k-1];
        }
        for (int i = 0; i < n; ++i) {
            if (arr[i] > 0)
                return ++i;
        }
        return n+1;
    }
    
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            String[] temp = reader.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(temp[i]);
            System.out.println(getLowestMissingPositive(arr, n));
        }
    }
}
