package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Validation;

public class InputView {

    public Integer inputPrice() {
        String strPrice = Console.readLine()
                .trim();


        Validation.onlyNumberCheck(strPrice);

        return Integer.parseInt(strPrice);
    }

    public String inputLotto() {
        String lotto = Console.readLine();
        lottoValidate(lotto);
        return lotto;
    }

    private void lottoValidate(String lotto) {
        List<Integer> numbers = Arrays.stream(lotto.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        Validation.lottoSize(numbers);
        Validation.lottoDuplicate(numbers);
        Validation.lottoLimit(numbers);
    }

    public String inputBonus() {
        String bonus = Console.readLine();
        bonusValidation(bonus);
        return bonus;
    }

    private void bonusValidation(String bonus) {
        Validation.onlyNumberCheck(bonus);
    }
}
