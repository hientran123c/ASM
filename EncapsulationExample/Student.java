package EncapsulationExample;

public class Student {
    private String id;
    private String name;
    private int mark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark >= 0 && mark <= 10) {
            this.mark = mark;
        } else {
            System.out.println("Invalid mark. Must be between 0 and 10.");
        }
    }
}

