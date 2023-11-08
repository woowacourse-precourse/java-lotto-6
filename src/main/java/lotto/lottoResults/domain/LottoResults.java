package lotto.lottoResults.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.lottoResults.domain.NumberStringParser.parseToInteger;
import static lotto.lottoResults.domain.NumberStringParser.parseToIntegers;
import static lotto.lottoResults.domain.NumberValidator.validate;
import static lotto.lottoResults.domain.NumberValidator.validateNumberRange;
import static lotto.lottoResults.domain.NumberValidator.validateUniqueWithBonus;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {

    private List<Integer> winningNumbers;

    private Integer bonus;

    public LottoResults() {
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
