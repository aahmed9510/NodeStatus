import java.util.ArrayList;

/**
 * Array Builder generator for Array to ArrayList conversion
 */

public class ArrayBuilder {

    private static ArrayList<String> localMS_Al = new ArrayList<String>();
    private ArrayList<String> localNode_Al = new ArrayList<String>();
    private ArrayList<String> status_Al = new ArrayList<String>();

    public void StringArray(String[][] fileimport) {

        String localStatus_str = "";

        // get all the values to separate into 3 arrays/ columns
        for (String[] aFileimport : fileimport) {

            for (int j = 0; j < aFileimport.length; j++) {

                if (j == 0) {

                    String localMS_str = aFileimport[j];
                    localMS_Al.add(localMS_str);
                }

                if (j == 1) {

                    String localNode_str = aFileimport[j];
                    localNode_Al.add(localNode_str);
                }

                if (j > 1) {

                    if (aFileimport[j] != null) {

                        localStatus_str = localStatus_str + aFileimport[j] + " ";
                    }

                }

            }
            status_Al.add(localStatus_str);
            localStatus_str = "";
        }
    }

    public ArrayList<String> GetMS() {

        return localMS_Al;
    }

    public ArrayList<String> GetNode() {

        return localNode_Al;
    }

    public ArrayList<String> GetStatus() {

        return status_Al;
    }

}