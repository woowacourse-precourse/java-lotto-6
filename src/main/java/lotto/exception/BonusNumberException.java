package lotto.exception;

import java.util.List;

public class BonusNumberException {
    private static final int BONUS_NUMBER_START = 1;
    private static final int BONUS_NUMBER_FINISH = 45;
    private static final String IS_NUMBER_MESSAGE = "보너스 숫자는 숫자를 입력해주셔야 합니다.";
    private static final String IS_RIGHT_RANGE_MESSAGE = "보너스 숫자의 유효범위는 1부터 45까지 입니다.";
    private static final String IS_BLANK_MESSAGE = "입력하신 보너스 숫자가 공백입니다.";
    private static final String IS_DUPLICATE_MESSAGE = "입력하신 보너스 숫자가 당첨 번호와 중복인 숫자가 있습니다.";
    private static final String IS_ONLY_ONE_MESSAGE = "보너스 숫자는 한 개만 입력해주세요";



    public void isNumber(String input) {
        try{
            Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(IS_NUMBER_MESSAGE);
        }
    }

    public void isRightRange(int input) {
        if(input < BONUS_NUMBER_START || input > BONUS_NUMBER_FINISH){
            throw new IllegalArgumentException(IS_RIGHT_RANGE_MESSAGE);
        }
    }

    public void isBlank(String input) {
        if(input.trim().isEmpty()){
            throw new IllegalArgumentException(IS_BLANK_MESSAGE);
        }
    }

    public void isDuplicateWithWinnerNum(int bonusNum, List<Integer> winnerNum) {
        if(winnerNum.stream().anyMatch(i -> i == bonusNum)){
            throw new IllegalArgumentException(IS_DUPLICATE_MESSAGE);
        }
    }

    public void isNumberOnlyOne(String input) {
        if(input.split(",").length != 1){
            throw new IllegalArgumentException(IS_ONLY_ONE_MESSAGE);
        }
    }
}
