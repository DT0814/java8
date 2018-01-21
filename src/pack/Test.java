package pack;

import java.io.Serializable;

public class Test implements Serializable {

    private static final long serialVersionUID = -8968350748602548887L;

    public Test(Integer nun, String name) {
        this.nun = nun;
        this.name = name;
    }

    private Integer nun;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNun() {
        return nun;
    }

    public void setNun(Integer nun) {
        this.nun = nun;
    }
}