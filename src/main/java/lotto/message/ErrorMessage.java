package lotto.message;

public enum ErrorMessage {

    ENTER_WINNER_NUMBER_ERROR("[ERROR] 로또 번호는 1부터 45 사이로 구성된 6개의 숫자를 입력해야 합니다. 다시 시도해주시길 바랍니다."),
    NOT_UNITS_OF_THOUSAND_ERROR("[ERROR] 돈을 잘못 입력했습니다. 1000원 단위로 다시 입력해주시기 바랍니다"),
    ENTER_BONUS_NUMBER_ERROR("[ERROR] 보너스 숫자는 당첨번호와 겹치지 않는 1부터 45 사이의 숫자여야 합니다. 다시 입력해주시기 바랍니다"),
    WRONG_LOTTO_ERROR("[ERROR] 당첨번호와 보너스번호가 잘못 입력되었습니다. 다시 입력해주시기 바랍니다");
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
