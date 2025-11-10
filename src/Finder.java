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

    private static Hashmap hashmap;
    public Finder() {
        hashmap = new Hashmap();
    }

    // creating the data structure
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            // Process data in each line
            String[] arr = line.split(",");
            String key = arr[keyCol];
            String value = arr[valCol];
            hashmap.insert(key, value);
        }
        br.close();
    }
    // getting the value from the data structure given the key
    public String query(String key){
        return hashmap.findValue(key);
    }
}