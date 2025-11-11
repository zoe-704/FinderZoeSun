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

    // Read and insert data from csv file into hashmap
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            // Process data in each line of csv file to get the key and value
            String[] arr = line.split(",");
            String key = arr[keyCol];
            String value = arr[valCol];
            // Insert key value pair into hashmap
            hashmap.insert(new Pair(key, value));
        }
        br.close();
    }
    // Return the value of a key in the hashmap
    public String query(String key){
        return hashmap.findValue(key);
    }
}