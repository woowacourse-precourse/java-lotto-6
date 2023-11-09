package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.model.AmountMoney;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.utils.Validator;

public class InputView {

    public static AmountMoney promptPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        int amountMoney = getAmountMoney();
        return new AmountMoney(amountMoney);
    }

    public static Lotto promptMakeLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> listOfNumbers = getListOfNumbers();
        return new Lotto(listOfNumbers);
    }

    public static BonusNumber promptBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int number = getNumber();
        return new BonusNumber(number);
    }

    private static int getAmountMoney() {
        String input = Console.readLine();
        Validator.validateInputValue(input);

        return Integer.parseInt(input);
    }

    private static List<Integer> getListOfNumbers() {
        String[] lottoNumbers = Console.readLine().split(",");
        Validator.validateInputValue(lottoNumbers);

        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }

    private static int getNumber() {
        String bonusNumberInput = Console.readLine();
        Validator.validateInputValue(bonusNumberInput);

        return Integer.parseInt(bonusNumberInput);
    }

}
