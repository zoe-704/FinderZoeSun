import java.io.*;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Zoe Sun
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
    public Finder() {}

    static final int RADIX = 256;
    static final long P = 543_211_019;

    // Creates hash using horner's method
    public static long hash(String s, int start, int n) {
        long h = 0;
        for (int i = start; i < start + n; i++) {
            h = (h * RADIX + s.charAt(i)) % P;
        }
        return h;
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        String line = br.readLine();
        String[] arr = line.split(",");
        String key = arr[keyCol];
        String value = arr[valCol];
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
}