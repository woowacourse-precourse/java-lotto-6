package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPrice;
import lotto.validation.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static LottoPrice inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            validateString(input);
            return new LottoPrice(Integer.parseInt(input));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPrice();
        }
    }

    public static Lotto inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] inputs = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        try {
            for(String s : inputs) {
                validateString(s);
                winningNumber.add(Integer.parseInt(s));
            }
            return new Lotto(winningNumber);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    public static BonusNumber inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            validateString(input);
            return new BonusNumber(Integer.parseInt(input));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    public static void validateString(String inputString) {
        for(char c : inputString.toCharArray()){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException(ErrorMessage.NOT_INTGER_ERROR.getMessage());
        }
    }
}
