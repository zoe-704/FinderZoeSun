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