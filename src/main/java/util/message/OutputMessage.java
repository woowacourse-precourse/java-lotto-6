package util.message;

import util.EnumUtil;

public enum OutputMessage implements EnumUtil<String, String>{
    ;

    private final String message;

    OutputMessage(final String message){
        this.message = message;
    }


    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return name();
    }
}
