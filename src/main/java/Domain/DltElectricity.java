package Domain;

public class DltElectricity {

    int id;
    int ammeter_id;
    String activepower;
    String currentd_a;
    String currentd_b;
    String currentd_c;
    String currentd_d;
    String voltage_a;
    String voltage_b;
    String voltage_c;
    String voltage_d;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmmeter_id() {
        return ammeter_id;
    }

    public void setAmmeter_id(int ammeter_id) {
        this.ammeter_id = ammeter_id;
    }

    public String getActivepower() {
        return activepower;
    }

    public void setActivepower(String activepower) {
        this.activepower = activepower;
    }

    public String getCurrentd_a() {
        return currentd_a;
    }

    public void setCurrentd_a(String currentd_a) {
        this.currentd_a = currentd_a;
    }

    public String getCurrentd_b() {
        return currentd_b;
    }

    public void setCurrentd_b(String currentd_b) {
        this.currentd_b = currentd_b;
    }

    public String getCurrentd_c() {
        return currentd_c;
    }

    public void setCurrentd_c(String currentd_c) {
        this.currentd_c = currentd_c;
    }

    public String getCurrentd_d() {
        return currentd_d;
    }

    public void setCurrentd_d(String currentd_d) {
        this.currentd_d = currentd_d;
    }

    public String getVoltage_a() {
        return voltage_a;
    }

    public void setVoltage_a(String voltage_a) {
        this.voltage_a = voltage_a;
    }

    public String getVoltage_b() {
        return voltage_b;
    }

    public void setVoltage_b(String voltage_b) {
        this.voltage_b = voltage_b;
    }

    public String getVoltage_c() {
        return voltage_c;
    }

    public void setVoltage_c(String voltage_c) {
        this.voltage_c = voltage_c;
    }

    public String getVoltage_d() {
        return voltage_d;
    }

    public void setVoltage_d(String voltage_d) {
        this.voltage_d = voltage_d;
    }

    @Override
    public String toString() {
        return "DltElectricity{" +
                "id=" + id +
                ", ammeter_id=" + ammeter_id +
                ", activepower='" + activepower + '\'' +
                ", currentd_a='" + currentd_a + '\'' +
                ", currentd_b='" + currentd_b + '\'' +
                ", currentd_c='" + currentd_c + '\'' +
                ", currentd_d='" + currentd_d + '\'' +
                ", voltage_a='" + voltage_a + '\'' +
                ", voltage_b='" + voltage_b + '\'' +
                ", voltage_c='" + voltage_c + '\'' +
                ", voltage_d='" + voltage_d + '\'' +
                '}';
    }
}
