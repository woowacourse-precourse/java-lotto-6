package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.vaildator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        return InputValidator.purchaseMoney(userMoney);
    }

    public List<Integer> inputWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winNumber = Console.readLine();
        String[] numberStrings = winNumber.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            winNumbers.add(number);
        }
        return winNumbers;
    }

    public int inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String userMoney = Console.readLine();
        return Integer.parseInt(userMoney);
    }

}
