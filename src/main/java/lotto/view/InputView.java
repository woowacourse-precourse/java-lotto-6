package lotto.view;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.ErrorMessage.INVALID_INTEGER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;

public class InputView {
    private static final String INPUT_BUY_MONEY = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_JOIN_DELIMITER = ",";


    public int getMoney(){
        while (true) {
            System.out.println(INPUT_BUY_MONEY);
            try {
                return changeToInt(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinNumbers(){
        System.out.println(INPUT_WINING_NUMBERS);
        List<Integer> winNumbers = new ArrayList<>();
        String numbers =  Console.readLine();
        for (String s : numbers.split(NUMBER_JOIN_DELIMITER)){
            winNumbers.add(changeToInt(s));
        }
        return winNumbers;
    }

    public int getBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return changeToInt(Console.readLine());
    }

    public int changeToInt(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
