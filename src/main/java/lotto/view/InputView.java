package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT ="구입금액을 입력해 주세요.";
    private static final String TYPE_ERROR ="숫자가 아닌 값을 입력하셨습니다.";
    private static final String INPUT_WINNING_NUMBERS ="당첨 번호를 입력해주세요.";
    private static List<Integer> winningNumbers;
    private static final String RANGE_ERROR="[ERROR] 옳지 않은 범위의 숫자를 입력하셨습니다.";
    private static final int MAX_LOTTO_NUM=45;

    public static int inputPlayerAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertToInt(Console.readLine());
    }

    public static int convertToInt(String inputAmount) {
        return Integer.parseInt(inputAmount);
    }

    public static List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
        return  convertToList(Console.readLine());
    }

    private static List<Integer> convertToList(String inputNumbers){
        String [] result= inputNumbers.split(",");
        winningNumbers= new ArrayList<>();
        for(int i=0; i<result.length; i++){
            int num=checkNumber(result[i]);
            checkRange(num);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private static int checkNumber(String num){
        try{
            return Integer.parseInt(num);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    private static int checkRange(int num){
        if(num<=0 || num>MAX_LOTTO_NUM){
            throw new IllegalArgumentException(RANGE_ERROR);
        }
        return num;
    }





}
