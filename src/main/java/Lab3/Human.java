package Lab3;

public class Human {
    private String fio;
    private int yearOfBirth;

    public Human(String fio, int yearOfBirth) {
        this.fio = fio;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFio() {
        return fio;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
