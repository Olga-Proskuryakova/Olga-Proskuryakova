package object;

public class Group {
    private int id;
    private String name;
    private int curatorId;

    public Group(int id, String name, int curatorId) {
        this.id = id;
        this.name = name;
        this.curatorId = curatorId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(int curatorId) {
        this.curatorId = curatorId;
    }
}

