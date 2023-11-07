package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.Reader;
import lotto.util.Writer;

public class Game {
    private Validator validator;
    private Integer purchaseAmount;
    private Lottos lottos = new Lottos();
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    private Map<Grade, Integer> result;
    private Double rateOfReturn;

    public Game() {
        validator = new Validator();
    }

    public void start() {
        Writer.purchaseAmount();
        purchaseAmount = Reader.purchaseAmount();
        issuance(purchaseAmount);
        Writer.lottos(lottos);
        Writer.winningNumbers();
        List<Integer> winningNumbers = Reader.winningNumbers();
        setWinningNumbers(winningNumbers);
        Writer.bonusNumbers();
        Integer bonusNumber = Reader.bonusNumber();
        setBonusNumber(bonusNumber);
        setResult();
        Writer.result(result);
        rateOfReturn = calculateRateOfReturn();
        Writer.rateOfReturn(rateOfReturn);
    }

    private Double calculateRateOfReturn() {
        Integer revenue = 0;
        for (Grade grade : result.keySet()) {
            revenue += result.get(grade) * grade.getPrice();
        }
        return (double) revenue / purchaseAmount;
    }

    public void issuance(Integer purchaseAmount) {
        validator.validatePurchaseAmount(purchaseAmount);
        lottos.inssuance(purchaseAmount);
    }

    public void setResult() {
        result = lottos.grade(winningNumbers, bonusNumber);
    }

    private void setWinningNumbers(List<Integer> winningNumbers) {
        validator.validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void setBonusNumber(Integer bonusNumber) {
        validator.validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
