package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Util.Validation;

public class InputView {

    public static int getAvailableMoney() {
        int availableMoney = 0;

        try {
            String input = Console.readLine();
            availableMoney = Validation.validateAvailableMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return availableMoney;
    }

    public static List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        try {
            String input = Console.readLine();
            numbers = Validation.validateLottoNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return numbers;
    }

    public static int getBonusNumber(List<Integer> lottoNumbers) {
        int bonusNumber = 0;

        try {
            String input = Console.readLine();
            bonusNumber = Validation.validateBonusNumber(lottoNumbers, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return bonusNumber;
    }
}
