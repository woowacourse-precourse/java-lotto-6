package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Validation;

public class InputView {

    private String input;

    public Integer inputPrice() {
        while (true) {
            try {
                input = Console.readLine().trim();
                Validation.onlyNumberCheck(input);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(input);
    }

    public String inputLotto() {
        while (true) {
            try {
                input = Console.readLine();
                lottoValidate(input);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return input;
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
        while (true) {
            try {
                input = Console.readLine();
                bonusValidation(input);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return input;
    }

    private void bonusValidation(String bonus) {
        Validation.onlyNumberCheck(bonus);
    }
}
