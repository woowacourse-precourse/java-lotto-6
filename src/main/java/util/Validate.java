package util;

import domain.WinningLotto;

public class Validate {
    private final Parser parser = new Parser();
    private static final String NOT_IN_RANGE_ERROR= "[ERROR]번호는 1~45 이내에 있어야 합니다.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 숫자를 입력해야 합니다.";
    private static final String INCORRECT_BONUS_LENGTH_ERROR = "[ERROR]보너스 번호의 길이가 올바르지 않습니다.";
    private static final String NOT_DIVIDED_BY_1000_WON = "[ERROR]1000원으로 나누어 떨어지지 않는 값입니다.";
    private static final String INCORRECT_WINNING_LENGTH_ERROR = "[ERROR]당첨 번호의 길이가 올바르지 않습니다.";
    private static final String CONTAINS_SPACE_ERROR = "[ERROR] 입력에 빈 칸이 포함되어 있습니다.";
    private static final String SPACE = " ";

    public void CheckMoneyInput(String input){ // 로또 구입 금액 체크
        CheckEmpty(input);
        CheckIsNumeric(input);
        CheckIs1000Divisible(parser.parseInteger(input));
    }
    public void CheckWinningNumber(String input){ // 당첨 번호 체크
        String[] Checkinput = input.split(",");

        CheckEmpty(input);
        CheckWinningNumberLength(Checkinput);

        for(int i=0; i< Checkinput.length; i++){
            CheckNumberInRange(parser.parseInteger(Checkinput[i]));
            CheckIsNumeric(Checkinput[i]);
        }
    }
    public void CheckBonusNumber(String input){ // 보너스 번호 체크
        CheckEmpty(input);
        CheckBonusNumberLength(input);
        CheckIsNumeric(input);
        CheckNumberInRange(parser.parseInteger(input));
    }

    // 구입 금액 사용
    private void CheckIs1000Divisible(int input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException(NOT_DIVIDED_BY_1000_WON);
        }
    }

    // 당첨 번호 사용
    private void CheckWinningNumberLength(String[] Checkinput){
        if(Checkinput.length != 6){
            throw new IllegalArgumentException(INCORRECT_WINNING_LENGTH_ERROR);
        }
    }

    // 보너스 번호 사용
    private void CheckBonusNumberLength(String input){
        if(input.length() != 1 || input.length() != 2){
            throw new IllegalArgumentException(INCORRECT_BONUS_LENGTH_ERROR);
        }
    }
    // 공통 사용
    private void CheckEmpty(String input){
        if(input.contains(SPACE)){
            throw new IllegalArgumentException(CONTAINS_SPACE_ERROR);
        }
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
}
