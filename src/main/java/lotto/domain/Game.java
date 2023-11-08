package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import lotto.util.Writer;

public class Game {
    private PurchaseAmount purchaseAmount;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private Map<Grade, Integer> result;
    private Double rateOfReturn;

    public Game() {
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
            purchaseAmount = PurchaseAmount.of(userInput);
            lottos = Lottos.of(purchaseAmount);
        } catch (IllegalArgumentException exception) {
            Writer.exception(exception);
            setLottos();
        }
    }

    private void setBonusNumber() {
        try {
            Writer.bonusNumbers();
            String userInput = Console.readLine();
            this.bonusNumber = BonusNumber.from(userInput, winningNumbers);
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
        rateOfReturn = purchaseAmount.rateOfReturn(revenue);
    }

    private void setResult() {
        result = lottos.grade(winningNumbers, bonusNumber);
    }

    private void setWinningNumbers() {
        try {
            Writer.winningNumbers();
            String userInput = Console.readLine();
            this.winningNumbers = WinningNumbers.of(userInput);
        } catch (IllegalArgumentException exception) {
            Writer.exception(exception);
            setWinningNumbers();
        }
    }
}
