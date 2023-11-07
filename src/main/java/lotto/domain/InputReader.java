package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public int readAndValidatePurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().replace(" ", "");
        Validator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public List<Integer> readAndValidateNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine().replace(" ", "");
        Validator.validateNumbers(input);
        String[] inputStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String inputString : inputStrings) {
            numbers.add(Integer.parseInt(inputString));
        }
        return numbers;
    }

    public int readAndValidateBonumNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine().replace(" ", "");
        Validator.validateLottoNumber(input);
        return Integer.parseInt(input);
    }

}
