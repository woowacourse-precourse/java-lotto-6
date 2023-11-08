package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerInput {
    private static final int Lotto_PRICE = 1000;
    //금액 입력받기
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            ErrorValidate.isNumberFormat(input);
            ErrorValidate.isMinimumInputMoney(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.ERROR_IS_NUMBER.getErrorMessage());
            inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_MINIMUM_INPUT_MONEY.getErrorMessage());
            inputMoney();
        }
        int money = Integer.parseInt(input);
        System.out.println("\n" + (money / Lotto_PRICE) + "개를 구매했습니다.");
        return money;
    }

    public List<Integer> inputLottoNumber() {
        List<Integer> winNumber = new ArrayList<>();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for (String number : input.split(",")) {
            try {
                ErrorValidate.inputNumberLimit(Integer.parseInt(number));
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.ERROR_NUMBER_RANGE.getErrorMessage());
                inputLottoNumber();
            }
            winNumber.add(Integer.parseInt(number));
        }
        System.out.println();
        return winNumber;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusNumber;
    }
}
