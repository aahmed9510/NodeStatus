import java.util.ArrayList;

public class ArrayBuilder {

    static ArrayList<String> localMS_Al = new ArrayList<String>();
    static ArrayList<String> localNode_Al = new ArrayList<String>();
    static ArrayList<String> status_Al = new ArrayList<String>();

    public void StringArray(String[][] fileimport) {

        String localStatus_str = "";

        // get all the values to separate into 3 arrays/ columns
        for (int i = 0; i < fileimport.length; i++) {

            for (int j = 0; j < fileimport[i].length; j++) {

                if (j == 0) {

                    String localMS_str = fileimport[i][j];
                    localMS_Al.add(localMS_str);
                }

                if (j == 1) {

                    String localNode_str = fileimport[i][j];
                    localNode_Al.add(localNode_str);
                }

                if (j > 1) {

                    if (fileimport[i][j] != null) {

                        localStatus_str = localStatus_str + fileimport[i][j] + " ";
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