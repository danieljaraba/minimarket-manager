package model;

public class Client {

    private Type type;
    private String id;

    public Client(String type, String id){
        this.type = Type.valueOf(type);
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
