package object;

public class Student {
    private int id;
    private String fio;
    private String sex;
    private int groupId;

    public Student(int id, String fio, String sex, int groupId) {
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


