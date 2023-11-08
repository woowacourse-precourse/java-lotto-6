package lotto.view.message.exception;

public enum WinningCombinationInputErrorMessage {
    INCORRECT_FORMET_WINNING_NUMBERS("[ERROR] 올바른 형식에 맞게 숫자를 입력하세요"),
    NOT_NUMBER_BONUS_NUMBER("[ERROR] 보너스 번호 숫자를 입력하세요"),
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 중복된 숫자를 입력하지 마세요"),
    INCORRECT_SIZE("[ERROR] 당첨 숫자입력 시 6개를 입력해야 합니다.");

    private final String message;

    WinningCombinationInputErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void displayMessage(){
        System.out.println(message);
    }
}
