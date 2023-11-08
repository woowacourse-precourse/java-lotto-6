package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.util.Reader;
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
            purchaseAmount = Reader.purchaseAmount();
            issuance(purchaseAmount);
        } catch (IllegalArgumentException exception) {
            Writer.exception(exception);
            setLottos();
        }
    }

    private void setBonusNumber() {
        try {
            Writer.bonusNumbers();
            Integer bonusNumber = Reader.bonusNumber();
            validator.validateBonusNumber(winningNumbers, bonusNumber);
            this.bonusNumber = bonusNumber;
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

    private void issuance(Integer purchaseAmount) {
        validator.validatePurchaseAmount(purchaseAmount);
        lottos.issuance(purchaseAmount);
    }

    private void setResult() {
        result = lottos.grade(winningNumbers, bonusNumber);
    }

    private void setWinningNumbers() {
        try {
            Writer.winningNumbers();
            List<Integer> winningNumbers = Reader.winningNumbers();
            validator.validateWinningNumbers(winningNumbers);
            this.winningNumbers = winningNumbers;
        } catch (IllegalArgumentException exception) {
            Writer.exception(exception);
            setWinningNumbers();
        }
    }
}
