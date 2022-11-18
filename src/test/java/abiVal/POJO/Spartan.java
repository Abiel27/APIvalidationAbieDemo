package abiVal.POJO;

public class Spartan {
    //blue print for creating Spartan pojo
    //represent json object,  used to respresent data
    //POJO: plain old java object,
    //Encapsulated field(private field public getter and setter)
    //No Argconsractor
    // optionaly add arg constructor for creating object in one shot
    // toString method to view the printed result

    private String name;
    private String gender;
    private long phone;

    public Spartan(){

    }

    public Spartan(String name, String gender, long phone) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }
}
