package lotto;

public enum ErrorMessages {
    BONUS_INCLUDED_WINNINGS("[ERROR] 당첨 번호와 중복 될 수 없습니다.\n"),
    BONUS_INCORRECT_SIZE("[ERROR] 잘못된 보너스 번호의 갯수를 입력하였습니다.\n"),
    NUMBER_INCORRECT_SIZE("[ERROR] 잘못된 당첨번호 갯수를 입력하였습니다.\n"),
    NUMBER_DUPLICATED("[ERROR] 중복된 당첨번호를 입력 하였습니다.\n"),
    INPUT_IS_NOT_NUMBER("[ERROR] 입력 된 값이 숫자가 아닙니다.\n"),
    NUMBER_IS_INCORRECT_RANGE("[ERROR] 범위를 벗어난 숫자를 입력하였습니다.\n"),
    INPUT_NOT_UNIT_MONEY("[ERROR] 1000원단위의 금액을 입력해 주세요.\n");

    private final String description;

    ErrorMessages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
