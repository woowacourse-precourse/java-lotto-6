package lotto.view;

public enum InputMessage {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    LOTTO_RANDOM_PRINT("개를 구매했습니다.");

    final String filed;
    InputMessage(String filed){
        this.filed = filed;
    }
}
