public class Hashmap {
    private static final String INVALID = "INVALID KEY";
    private static final int INITIAL_SIZE = 31;
    private static final double LOAD_FACTOR = 0.5;

    private Pair[] map;
    private int size;

    static int RADIX = 256;
    static int P = 524287;

    public Hashmap() {
        map = new Pair[INITIAL_SIZE];
        size = 0;
    }

    public void insert(String key, String value) {
        if ((double) size / map.length > LOAD_FACTOR) {
            resize();
        }
        int keyHash = hash(key);
        while (map[keyHash] != null && !map[keyHash].getKey().equals(key)) {
            keyHash = (keyHash + 1) % map.length;
        }
        map[keyHash] = new Pair(key, value);
        size++;
    }


    public int hash(String key) {
        int h = 0;
        for (int i = 0; i < key.length(); i++) {
            h = (h * RADIX + key.charAt(i)) % P;
        }
        return h % map.length;

    }

    public String findValue(String key) {
        int keyHash = hash(key);
        int start = keyHash;
        while (map[keyHash] != null) {
            if (map[keyHash].getKey().equals(key)) {
                return map[keyHash].getValue();
            }
            keyHash = (keyHash + 1) % map.length;
            if (keyHash == start) break;
        }

        return INVALID;
    }

    private void resize() {
        Pair[] old = map;
        map = new Pair[old.length * 2];
        size = 0;

        for (Pair p : old) {
            if (p != null) insert(p.getKey(), p.getValue());
        }
    }
}