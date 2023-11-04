package util;

import domain.WinningLotto;

public class Validate {
    private final Parser parser = new Parser();
    private static final String NOT_IN_RANGE_ERROR= "[ERROR] 번호는 1~45 이내에 있어야 합니다.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 번호는 숫자여야 합니다.";
    private static final String INCORRECT_BONUS_LENGTH_ERROR = "[ERROR] 보너스 번호의 길이가 올바르지 않습니다.";
    public void CheckMoneyInput(String input){ // 로또 구입 금액 체크

    }
    public void CheckWinningNumber(String input){ // 당첨 번호 체크

    }
    public void CheckBonusNumber(String input){ // 보너스 번호 체크
        BonusNumberLengthCheck(input);
        CheckIsNumeric(input);
        CheckNumberInRange(parser.parseNumberOfMoney(input));
    }

    private void CheckNumberInRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(NOT_IN_RANGE_ERROR);
        }
    }

    private void CheckIsNumeric(String input) {
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private void BonusNumberLengthCheck(String input){
        if(input.length() != 1){
            throw new IllegalArgumentException(INCORRECT_BONUS_LENGTH_ERROR);
        }
    }
}
