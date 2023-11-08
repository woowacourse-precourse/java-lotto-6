package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerInput {
    //금액 입력받기
    public int InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            ErrorValidate.isNumberFormat(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_IS_NUMBER.getErrorMessage());
            InputMoney();
        }
        int money = Integer.parseInt(input);
        return money;
    }

    public List<Integer> LottoNumber() {
        List<Integer> winNumber = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for (String number : input.split(",")) {
            try {
                ErrorValidate.inputNumberLimit(Integer.parseInt(number));
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.ERROR_NUMBER_RANGE.getErrorMessage());
                LottoNumber();
            }
            winNumber.add(Integer.parseInt(number));
        }
        return winNumber;
    }

    public int BonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
