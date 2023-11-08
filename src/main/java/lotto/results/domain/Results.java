package lotto.results.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.component.parser.NumberStringParser.parseToInteger;
import static lotto.component.parser.NumberStringParser.parseToIntegers;
import static lotto.component.validation.NumberValidator.validate;
import static lotto.component.validation.NumberValidator.validateNumberRange;
import static lotto.component.validation.NumberValidator.validateUniqueWithBonus;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private List<Integer> winningNumbers;

    private Integer bonus;

    public Results() {
    }

    public void insultWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String numbers = readLine();
            winningNumbers = parseToIntegers(numbers);
            validate(winningNumbers);
        } catch (IllegalArgumentException e) {
            insultWinningNumbers();
        }
    }

    public void insultBonus() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String number = readLine();
            bonus = parseToInteger(number);
            validateNumberRange(bonus);
            validateUniqueWithBonus(winningNumbers, bonus);
        } catch (IllegalArgumentException e) {
            insultBonus();
        }
    }

    public List<Integer> getWinningNumbersWithBonus() {
        List<Integer> winningNumbersWithBonus = new ArrayList<>(winningNumbers);
        winningNumbersWithBonus.add(bonus);
        return winningNumbersWithBonus;
    }

}
