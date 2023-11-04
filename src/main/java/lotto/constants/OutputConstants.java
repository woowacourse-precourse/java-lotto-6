package lotto.constants;

public enum OutputConstants {

    INPUT_PAYMENT("구입금액을 입력해 주세요."),
    BOUGHT_N("%d개를 구매했습니다.");

    private final String value;

    OutputConstants(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}
