package lotto;

public enum Message {
    ERROR_MESSAGE("[ERROR]"),
    ONE_HUNDRED_DIVIDE("1,000 단위로 입력해주세요."),
    INPUT_VALUE_OVERHEAD("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_MONEY("구입금액을 입력해 주세요."),
    LOTTO_RANDOM_PRINT("개를 구매했습니다.");

    final String filed;
    Message(String filed){
        this.filed = filed;
    }
}
