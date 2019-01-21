
public class NameCheck {

    private int seq;

    // method for looking up name against a list

    /**
     * modify this method to switch-case
     *
     * @param name
     */
    public String nameCheck(String name, String[][] fileimport) {

        String status = "UNKNOWN";

        label:
        for (int i = 0; i < fileimport.length; i++) {

            if (name == fileimport[i][2]) {

                status = "ALIVE";
                seq = i;
                break;
            } else if (name == fileimport[i][4]) {

                switch (fileimport[i][3]) {
                    case "FOUND":

                        status = "ALIVE";
                        seq = i;
                        break label;

                    case "LOST":

                        status = "DEAD";
                        seq = i;
                        break label;

                    default:

                        System.out.println(status);

                        break;
                }

            }

        }
        return status;

    }

    public int GetSeq() {

        return seq;
    }

}