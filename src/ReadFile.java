import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {

    @SuppressWarnings("resource")
    static public String[][] ReadArrayFile(String filename, String sep) {
        String res[][] = null;
        try {
            BufferedReader input = null;
            input = new BufferedReader(new FileReader(filename));
            String line = null;
            int ncol = 0;
            int nrow = 0;

            while ((line = input.readLine()) != null) {
                ++nrow;
                String[] columns = line.split(sep);
                ncol = Math.max(ncol, columns.length);
            }
            res = new String[nrow][ncol];
            input = new BufferedReader(new FileReader(filename));
            int i = 0, j = 0;
            while ((line = input.readLine()) != null) {

                String[] columns = line.split(sep);
                for (j = 0; j < columns.length; ++j) {
                    res[i][j] = columns[j];
                }
                ++i;
            }
        } catch (Exception E) {
            System.out.println("+++ReadArrayFile: " + E.getMessage());
        }
        return (res);
    }
}