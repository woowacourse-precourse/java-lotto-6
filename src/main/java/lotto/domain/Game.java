package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.util.Writer;

public class Game {
    private final Validator validator;
    private Integer purchaseAmount;
    private final Lottos lottos = new Lottos();
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    private Map<Grade, Integer> result;
    private Double rateOfReturn;

    public Game() {
        validator = new Validator();
    }

    public void start() {
        setLottos();
        Writer.lottos(lottos);
        setWinningNumbers();
        setBonusNumber();
        setResult();
        Writer.result(result);
        setRateOfReturn();
        Writer.rateOfReturn(rateOfReturn);
    }

    private void setLottos() {
        try {
            Writer.purchaseAmount();
            String userInput = Console.readLine();
            issuance(userInput);
        } catch (IllegalArgumentException exception) {
            Writer.exception(exception);
            setLottos();
        }
    }

    private void setBonusNumber() {
        try {
            Writer.bonusNumbers();
            String userInput = Console.readLine();
            this.bonusNumber = validator.validateBonusNumber(winningNumbers, userInput);
        } catch (IllegalArgumentException exception) {
            Writer.exception(exception);
            setBonusNumber();
        }
    }

    private void setRateOfReturn() {
        int revenue = 0;
        for (Grade grade : result.keySet()) {
            revenue += result.get(grade) * grade.getPrice();
        }
        rateOfReturn = ((double) revenue / purchaseAmount) * 100;
    }

    private void issuance(String input) {
        purchaseAmount = validator.validatePurchaseAmount(input);
        lottos.issuance(purchaseAmount);
    }

    private void setResult() {
        result = lottos.grade(winningNumbers, bonusNumber);
    }

    private void setWinningNumbers() {
        try {
            Writer.winningNumbers();
            String input = Console.readLine();
            this.winningNumbers = validator.validateWinningNumbers(input);
        } catch (IllegalArgumentException exception) {
            Writer.exception(exception);
            setWinningNumbers();
        }
    }
}
