package object;

public class Student {
    private int id;
    private String fio;
    private String sex;
    private int id_group;

    public Student(String fio, String sex, int id_group) {
        this.fio = fio;
        this.sex = sex;
        this.id_group = id_group;
    }

    public Student(int id, String fio, String sex, int id_group) {
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.id_group = id_group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", sex='" + sex + '\'' +
                ", id_group=" + id_group +
                '}';
    }
}



