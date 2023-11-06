package lotto;

public enum Message {
    ERROR_MESSAGE("[ERROR]"),
    ONE_HUNDRED_DIVIDE("1,000 단위로 입력해주세요."),
    INPUT_VALUE_OVERHEAD("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    final String filed;
    Message(String filed){
        this.filed = filed;
    }
}
