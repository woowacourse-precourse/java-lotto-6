package lotto.Controller;

import java.util.List;
import java.util.Map;
import lotto.Domain.Human;
import lotto.Domain.Lotto;
import lotto.Domain.LottoDraw;
import lotto.Domain.WinningLotto;
import lotto.Enum.WinningType;
import lotto.RandomGenerator.LottoGenerator;

public class LottoController {
    private Human human;
    private LottoDraw lottoDraw;
    private LottoInputValidator lottoInputValidator;

    public boolean gameStart(String budgets) {
        lottoInputValidator = new LottoInputValidator();
        try {
            lottoInputValidator.validateBudget(budgets);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        human = new Human(Long.parseLong(budgets));
        return false;
    }

    public void buyLottos() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        while (human.buyLotto()) {
            human.addLotto(lottoGenerator.getLottoNumber());
        }
    }

    public int getPurchasedLottoCnt() {
        return human.getLottosLength();
    }

    public List<Lotto> getPurchasedLottos() {
        return human.getLottos();
    }

    public boolean raffleLotto(String normalNumbersStr, String bonusNumberStr) {
        List<Integer> normalNumbers;
        int bonusNumber;
        try {
            normalNumbers = lottoInputValidator.validateNormalNumbersIsInteger(normalNumbersStr);
            lottoInputValidator.validateNormalNumbersInRange(normalNumbers);
            lottoInputValidator.validateNormalNumberCount(normalNumbers);
            bonusNumber = lottoInputValidator.validateBonusNumberIsInteger(bonusNumberStr);
            lottoInputValidator.validateNormalNumberDuplicated(normalNumbers);
            lottoInputValidator.validateBonusNumberDuplicated(normalNumbers, bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        lottoDraw = new LottoDraw(new WinningLotto(normalNumbers, bonusNumber));
        lottoDraw.checkNumbers(human);
        return false;
    }

    public Map<WinningType, Integer> getWinningResult() {
        return human.getWinningResult();
    }

    public double getReturnRate() {
        return human.getReturnRate();
    }
}
