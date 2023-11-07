package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.NumValidator.*;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT ="구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS ="당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER ="보너스 번호를 입력해주세요.";

    private static List<Integer> winningNumbers;

    private static final int MAX_LOTTO_NUM=45;
    private static final int LOTTO_NUM=6;


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
        checkCntNumber(winningNumbers);
        return winningNumbers;
    }


    public static int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        String input= Console.readLine();
        int num=checkNumber(input);
        checkRange(num);
        return num;
    }


}
