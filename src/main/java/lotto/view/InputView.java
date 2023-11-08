package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.constatnt.Constant.COMMA;

public class InputView {
    public int purchaseMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> numbers() {
        String number = Console.readLine();
        String[] numbers = number.split(COMMA);
        return converseNumbers(numbers);
    }

    public int bonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> converseNumbers(String[] numbers) {
        List<Integer> number = new ArrayList<>();

        for (String s : numbers) {
            number.add(Integer.parseInt(s));
        }
        return number;
    }
}
