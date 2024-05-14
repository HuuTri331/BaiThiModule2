public class Patient {
    private int id;
    private String idBA;
    private String idBN;
    private String name;
    private int dayout;
    private int dayin;
    private String namepatient;
    private String role;

    public Patient(int id, String idBA, String idBN, String name, int dayout, int dayin, String namepatient, String role) {
        this.id = id;
        this.idBA = idBA;
        this.idBN = idBN;
        this.name = name;
        this.dayout = dayout;
        this.dayin = dayin;
        this.namepatient = namepatient;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdBA() {
        return idBA;
    }

    public void setIdBA(String idBA) {
        this.idBA = idBA;
    }

    public String getIdBN() {
        return idBN;
    }

    public void setIdBN(String idBN) {
        this.idBN = idBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDayout() {
        return dayout;
    }

    public void setDayout(int dayout) {
        this.dayout = dayout;
    }

    public int getDayin() {
        return dayin;
    }

    public void setDayin(int dayin) {
        this.dayin = dayin;
    }

    public String getNamepatient() {
        return namepatient;
    }

    public void setNamepatient(String namepatient) {
        this.namepatient = namepatient;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
