package lotto.exception;

import java.util.List;

public class WinnerNumberException {
    private static final int WINNER_NUM_START = 1;
    private static final int WINNER_NUM_FINISH = 45;
    private static final int WINNER_NUM_COUNT = 6;
    private static final String IS_NUMBER_MESSAGE = "당첨 번호는 숫자로 입력해야 합니다.";
    private static final String IS_BLANK_MESSAGE = "입력하신 당첨 번호가 공백입니다.";
    private static final String IS_SIZE_MESSAGE = "당첨 번호는 6개를 입력해야 합니다.";
    private static final String IS_DUPLICATE_MESSAGE = "입력하신 당첨 번호에 중복이 있습니다.";
    private static final String IS_COMMA_MESSAGE = "당첨번호의 구분자로는 ,를 사용해주십시오.";
    private static final String IS_RIGHT_RANGE_MESSAGE = "당첨번호는 1부터 45 사이의 숫자로만 구성되어야 합니다.";



    public void isNumber(String winnerNum) {
        try{
            Integer.parseInt(winnerNum);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(IS_NUMBER_MESSAGE);
        }
    }

    public void isBlank(List<Integer> winnerNum) {
        if(winnerNum.size() == 0){
            throw new IllegalArgumentException(IS_BLANK_MESSAGE);
        }
    }

    public void isRightRange(List<Integer> winnerNum) {
        if(winnerNum.stream().anyMatch(i -> i <WINNER_NUM_START || i > WINNER_NUM_FINISH)){
            throw new IllegalArgumentException(IS_RIGHT_RANGE_MESSAGE);
        }
    }

    public void isSize(List<Integer> winnerNum) {
        if(winnerNum.size() != WINNER_NUM_COUNT){
            throw new IllegalArgumentException(IS_SIZE_MESSAGE);
        }
    }

    public void isDuplicate(List<Integer> winnerNum) {
        if(winnerNum.size() != winnerNum.stream().distinct().count()){
            throw new IllegalArgumentException(IS_DUPLICATE_MESSAGE);
        }
    }

    public void isComma(String winnerNum) {
        if(!winnerNum.contains(",")){
            throw new IllegalArgumentException(IS_COMMA_MESSAGE);
        }
    }
}
