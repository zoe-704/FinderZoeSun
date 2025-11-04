import java.io.*;
import java.util.ArrayList;

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
    static final int P = 524287;
    static final int MAX_N = 1000000;
    String k, v;



    public class Hash {
        private static int bucket;
        private ArrayList<String[]> table;
        public Hash(int bucket) {
            this.bucket = bucket;
            this.table = new ArrayList<String[bucket];
            for (int i = 0; i < table.size(); i++) {
                table[i] = new ArrayList<String>();
            }
        }
        // Creates hash using horner's method
        public static int hashKey(String s) {
            int h = 0;
            for (int i = 0; i < s.length(); i++) {
                h = (h * RADIX + s.charAt(i)) % P;
            }
            return h % bucket;
        }

        public void insert(String key, String value) {
            int keyHash = hashKey(key);
            table[keyHash].append(value);
        }
    }
    // creating the data structure
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        String line = br.readLine();
        String[] arr = line.split(",");
        k = arr[keyCol];
        v = arr[valCol];
        insert(k, v);
        br.close();
    }
    // getting the value from the data structure given the key
    public String query(String key){
        // TODO: Complete the query() function!
        int keyLength = key.length() % MAX_N;

        String[] queryTable = new String[MAX_N];
        queryTable[keyHash] = v;

        return INVALID;
    }
}