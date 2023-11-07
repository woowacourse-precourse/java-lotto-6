package constant;

public enum ConfigMessage {
    DELIMITER(",");

    private final String message;

    ConfigMessage(String message){
        this.message = message;
    }

    public String getValue(){
        return message;
    }
    @Override
    public String toString(){
        return message;
    }
}
