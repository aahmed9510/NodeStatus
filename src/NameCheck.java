
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

        for (int i = 0; i < fileimport.length; i++) {

            if (name == fileimport[i][2]) {

                status = "ALIVE";
                seq = i;
                break;
            } else if (name == fileimport[i][4]) {

                if (fileimport[i][3].equals("FOUND")) {

                    status = "ALIVE";
                    seq = i;
                    break;

                } else if (fileimport[i][3].equals("LOST")) {

                    status = "DEAD";
                    seq = i;
                    break;

                } else {

                    System.out.println(status);

                }

            }

        }
        return status;

    }

    public int GetSeq() {

        return seq;
    }

}