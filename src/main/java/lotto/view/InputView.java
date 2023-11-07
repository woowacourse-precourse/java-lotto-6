package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPurchasePrice() {
        int price = Integer.parseInt(Console.readLine());

        try {
            Validator.purchasePrice(price);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입 금액을 1,000원 단위로 입력하세요.");
            inputPurchasePrice();
        }

        return price;
    }

    public static List<Integer> inputWinNumber() {
        String[] nums = Console.readLine().replace(" ", "").split(",");
        List<Integer> winNumber = Arrays.stream(nums).map(number -> Integer.parseInt(number)).collect(Collectors.toList());

        return winNumber;
    }

    public static int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine().replace(" ", ""));

        return bonusNumber;
    }

}
