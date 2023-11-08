package lotto.view;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.ErrorMessage.INVALID_INTEGER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseMoney;

public class InputView {
    private static final String INPUT_BUY_MONEY = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_JOIN_DELIMITER = ",";


    public LottoPurchaseMoney inputMoney(){
        try {
            System.out.println(INPUT_BUY_MONEY);
            int inputMoney = changeToInt(Console.readLine());
            return new LottoPurchaseMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    public Lotto inputWinNumbers(){
        try {
            System.out.println(INPUT_WINING_NUMBERS);
            List<Integer> winNumbers = new ArrayList<>();
            String numbers =  Console.readLine();
            for (String s : numbers.split(NUMBER_JOIN_DELIMITER)){
                winNumbers.add(changeToInt(s));
            }
            Lotto winLotto = new Lotto(winNumbers);
            return winLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinNumbers();
        }
    }

    public BonusNumber getBonusNumber() {
        try {
            System.out.println(INPUT_BONUS_NUMBER);
            int bonusNumber = changeToInt(Console.readLine());
            return new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    public int changeToInt(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_INTEGER_INPUT.getMessage());
        }
    }
}
