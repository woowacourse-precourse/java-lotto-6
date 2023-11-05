package lotto.constants;

public enum MessageConstant {
    BUYMESSAGE("구입금액을 입력해 주세요."),BUYCOMPLETE("개를 구매했습니다."),INPUTWINNUM("당첨 번호를 입력해 주세요."),INPUTBONUS("보너스 번호를 입력해 주세요.");
    private String value;


    MessageConstant(String value) {
        this.value = value;
    }
    public String addString(int count){
        return Integer.toString(count) + this.value;
    }

    @Override
    public String toString() {
        return value;
    }
}
