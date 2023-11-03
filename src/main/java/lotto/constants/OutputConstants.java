package lotto.constants;

public enum OutputConstants {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String value;

    OutputConstants(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}
