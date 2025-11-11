public class Hashmap {
    // Constants for calculations and returns
    private static final String INVALID = "INVALID KEY";
    private static final int INITIAL_SIZE = 2000003;
    private static final double LOAD_FACTOR = 0.5;
    private static final int RADIX = 256;

    // Instance variables and constructor to set variables
    private Pair[] map;
    private int mapLength;
    private int numPairs;

    public Hashmap() {
        map = new Pair[INITIAL_SIZE];
        mapLength = INITIAL_SIZE;
        numPairs = 0;
    }
    // Inserts key-value pair into hashmap by linear probing and resizing table
    public void insert(Pair p) {
        int keyHash = hash(p.getKey());
        // Check size of hashmap before inserting
        if ((1.0) * numPairs / mapLength> LOAD_FACTOR) {
            resize();
            keyHash = hash(p.getKey());
        }
        // Linear probing in case of collusion to insert pair into hashmap
        while (map[keyHash] != null) {
            keyHash = (keyHash + 1) % mapLength;
        }
        // Insert pair into open spot of the hashmap
        map[keyHash] = p;
        numPairs++;
    }
    // Inserts key-value pair into hashmap without resizing check
    public void insertResized(Pair[] mp, Pair pair) {
        int keyHash = hash(pair.getKey());
        // Linear probing to prevent collision
        while (mp[keyHash] != null) {
            keyHash = (keyHash + 1) % mp.length;
        }
        // Insert pair into hashmap
        mp[keyHash] = pair;
    }
    // Horner's method to hash key of each pair
    public int hash(String key) {
        int h = 0;
        for (int i = 0; i < key.length(); i++) {
            h = (RADIX * h + key.charAt(i)) % mapLength; // Mod by mapLength so hash of key fits into hashmap
        }
        return h % mapLength;

    }

    // Searches for key in hashmap and returns its associated value or INVALID
    public String findValue(String key) {
        int keyHash = hash(key);
        int start = keyHash;
        // Iterate until empty spot or match in hashmap
        while (map[keyHash] != null) {
            // Return value when key is found
            if (map[keyHash].getKey().equals(key)) {
                return map[keyHash].getValue();
            }
            keyHash = (keyHash + 1) % mapLength; // Linear probing
            if (keyHash == start) break; // Prevent infinite loop
        }
        // Key not found
        return INVALID;
    }

    // Increase size of map when load factor exceeded and replace hashmap
    private void resize() {
        // Double hashmap size
        mapLength*= 2;
        Pair[] n = new Pair[mapLength];
        // Rehash and insert all pairs
        for (Pair p : map) {
            if (p != null) insertResized(n, p);
        }
        // Replace array with resized array
        map = n;
    }

}