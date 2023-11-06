package lotto.constants;

public enum InputOutputConstants {
    LOTTO_DRAW_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    LOTTO_DRAW_BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요.");

    final String value;

    InputOutputConstants(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
