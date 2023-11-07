package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.validator.LottoValidator.LottoWinNumbers;


public class InputView {

    public static int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        return InputValidator.purchaseMoney(userMoney);
    }

    public List<Integer> inputWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winNumber = Console.readLine();
        if (winNumber.isEmpty()) {
            return LottoWinNumbers(winNumber);
        }
        String[] numberStrings = winNumber.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            winNumbers.add(number);
        }
        return LottoWinNumbers(winNumber);
    }

    public int inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

}
