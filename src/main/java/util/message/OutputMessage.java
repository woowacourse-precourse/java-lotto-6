package util.message;

import util.EnumUtil;

public enum OutputMessage implements EnumUtil<String, String>{
    LOTTO_PURCHASE_COUNT("%d개를 구매했습니다.");

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
        return message;
    }
}
