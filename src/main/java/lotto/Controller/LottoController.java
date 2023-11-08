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

    public boolean raffleLottoNormalNumbers(String normalNumbersStr) {
        List<Integer> normalNumbers;
        try {
            normalNumbers = lottoInputValidator.validateNormalNumbersIsInteger(normalNumbersStr);
            lottoInputValidator.validateNormalNumbersInRange(normalNumbers);
            lottoInputValidator.validateNormalNumberCount(normalNumbers);
            lottoInputValidator.validateNormalNumberDuplicated(normalNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        lottoDraw = new LottoDraw(new WinningLotto(normalNumbers, 0));
        return false;
    }

    public boolean raffleLottoBonusNumbers(String bonusNumberStr) {
        List<Integer> normalNumbers = lottoDraw.getWinningLotto().getNormalNumbers();
        int bonusNumber;
        try {
            bonusNumber = lottoInputValidator.validateBonusNumberIsInteger(bonusNumberStr);
            lottoInputValidator.validateBonusNumberDuplicated(normalNumbers, bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        lottoDraw.getWinningLotto().setBonusNumber(bonusNumber);
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
