package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.enums.InputMessageEnum;

public class InputView {

    public int inputPurchasePrice() {
        System.out.println(InputMessageEnum.INPUT_PURCHASE_PRICE_MESSAGE.getMessage());
        String amount = Console.readLine();
        // validate(amount); // TODO : 검증 로직 작성
        return Integer.parseInt(amount);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(InputMessageEnum.INPUT_WINNING_NUMBERS_MESSAGE.getMessage());
        String numbers = Console.readLine();
        // validate(numbers); // TODO : 검증 로직 생성
        String[] splittedNumbers = numbers.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : splittedNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(InputMessageEnum.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        String number = Console.readLine();
        // validate(number); // TODO : 검증 로직 생성
        return Integer.parseInt(number);
    }
}
