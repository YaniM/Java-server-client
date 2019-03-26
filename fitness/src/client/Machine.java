package client;

public class Machine {
    private String id;
    private Integer seconds;

    public Machine(String id, Integer seconds) {
        this.id = id;
        this.seconds = seconds;
    }

    public Machine() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
