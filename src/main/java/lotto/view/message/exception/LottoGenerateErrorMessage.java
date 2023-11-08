package lotto.view.message.exception;

public enum LottoGenerateErrorMessage {
    DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복이 없어야 합니다."),
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INCORRECT_SIZE("[ERROR] 로또 숫자 생성시 6개를 입력해야 합니다.");

    private final String message;

    LottoGenerateErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void displayMessage(){
        System.out.println(message);
    }
}
