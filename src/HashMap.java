import java.util.ArrayList;

public class HashMap {
    private static final String INVALID = "INVALID KEY";
    static final int RADIX = 256;
    static final int P = 524287;
    static final int MAX_N = 10001;
    private int mapLength;
    String k, v;
    Hash l = new Hash(MAX_N);

    public static class Hash {
        // insert
        public void insert(Pair pair) {

        }
        public int hash(String key) {
            int h = 0;
            for (int i = 0; i < key.length(); i++) {
                h = (h * RADIX + key.charAt(i)) % mapSize;
            }
            return h % table_size;

        }
        public String findValue(String key) {

        }
        public void resize() {

        }


        private static int table_size;
        private ArrayList<String[]> table;
        public Hash(int table_size) {
            Hash.table_size = table_size;
            table = new ArrayList<String[table_size];
            for (int i = 0; i < table.size(); i++) {
                table.set(i, new ArrayList<String>());
            }
        }
        // Creates hash using horner's method
        public static int hashKey(String s) {
            int h = 0;
            for (int i = 0; i < s.length(); i++) {
                h = (h * RADIX + s.charAt(i)) % P;
            }
            return h % table_size;
        }

        public void insert(String key, String value) {
            int keyHash = hashKey(key);
            table[keyHash].append(value);
        }
        public String findValue(String key) {
            return INVALID;
        }
    }

}
