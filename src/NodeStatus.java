import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NodeStatus {

    static String file_name = "input.txt";
    static String[][] fileimport = readtextfile(file_name);

    public static String[][] readtextfile(String x) {
        String sep = " ";
        String[][] arr = ReadFile.ReadArrayFile(x, sep);
        return (arr);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        // sorts 2d array
        Arrays.sort(fileimport, new ColumnComparator(0));

        ArrayBuilder arrBuilder = new ArrayBuilder();
        arrBuilder.StringArray(fileimport);

        // store arraylist into string array
        ArrayList<String> MS = arrBuilder.GetMS();
        ArrayList<String> node = arrBuilder.GetNode();
        ArrayList<String> stat = arrBuilder.GetStatus();

        String[] localMSArr = MS.toArray(new String[0]);
        String[] localNodeArr = node.toArray(new String[0]);
        String[] status_Arr = stat.toArray(new String[0]);

        // get names from columns 3 and 5 and place into arraylist
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> names2 = new ArrayList<String>();

        for (int i = 0; i < fileimport.length; i++) {

            String x = fileimport[i][2];
            names.add(x);

            if (fileimport[i][4] != null) {

                String y = fileimport[i][4];
                names2.add(y);
            }
        }

        // merge the two arraylists
        names.addAll(names2);

        // convert arraylist to String array
        String[] temp = names.toArray(new String[0]);

        // get only the distinct names
        String[] unique = Arrays.stream(temp).distinct().toArray(String[]::new);

        for (int i = 0; i < unique.length; i++) {

            NameCheck nc = new NameCheck();
            String status = nc.nameCheck(unique[i], fileimport);
            int seq = nc.GetSeq();

            System.out.println("Line " + (i + 1) + " :" + unique[i] + " " + status + " " + localMSArr[seq] + " "
                    + status_Arr[seq]);

        }

    }

}

// compares and sorts arrays
/**
 * @author AlamMac Website:
 *         http://techthinking.net/2010/02/sorting-two-dimensional-string-array-using-java/
 */
@SuppressWarnings("rawtypes")
class ColumnComparator implements Comparator {
    int columnToSort;

    ColumnComparator(int columnToSort) {
        this.columnToSort = columnToSort;
    }

    // overriding compare method
    public int compare(Object o1, Object o2) {
        String[] row1 = (String[]) o1;
        String[] row2 = (String[]) o2;
        // compare the columns to sort
        return row2[columnToSort].compareTo(row1[columnToSort]);
    }

}