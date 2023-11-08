package lotto.manager;

import static lotto.utils.constant.LottoConstant.LOTTO_MONEY_UNIT;

import lotto.io.IOManager;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.WinningLotto;
import lotto.model.money.LottoCount;
import lotto.model.money.PrizeMoney;
import lotto.model.money.UserBudget;

public class GameController {

    private final IOManager ioManager;
    private LottoManager lottoManager;
    private MoneyManager moneyManager;
    private Judge judge;

    public GameController(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void run() {
        setUpJudgeAndManagers();
        drawLotto();
        printLottoResult();
    }

    private void setUpJudgeAndManagers() {
        UserBudget userBudget = ioManager.getUserBudget();
        LottoCount lottoCount = calculateLottoCount(userBudget);
        setUpLottoManager(generatLottos(lottoCount), lottoCount);
        printGeneratedLottos(userBudget);
        Lotto winningNumbers = ioManager.getWinningNumbers();
        BonusNumber bonusNumber = ioManager.getBonusNumber(winningNumbers);
        setUpJudge(winningNumbers, bonusNumber);
        setUpMoneyManager(userBudget);
    }

    private void setUpLottoManager(Lottos lottos, LottoCount lottoCount) {
        lottoManager = LottoManager.of(lottos, lottoCount);
    }

    private void setUpJudge(Lotto winning, BonusNumber bonusNumber) {
        judge = Judge.of(new WinningLotto(winning, bonusNumber));
    }

    private void setUpMoneyManager(UserBudget userBudget) {
        moneyManager = new MoneyManager(userBudget, new PrizeMoney());
    }

    private void drawLotto() {
        lottoManager.getLottos()
                .forEach(lotto -> judge.judge(lotto));
    }

    private void printLottoResult() {
        ioManager.printResult();
        ioManager.printStatistics(judge.getStatistics());
        ioManager.printProfitRate(moneyManager.getProfitRate(judge.getStatistics()));
    }

    private void printGeneratedLottos(UserBudget userBudget) {
        ioManager.printLottosInfo(calculateLottoCount(userBudget), lottoManager.getLottosInfo());
    }

    private LottoCount calculateLottoCount(UserBudget userBudget) {
        return new LottoCount(userBudget.getBudget().getMoney() / LOTTO_MONEY_UNIT.getValue());
    }

    private Lottos generatLottos(LottoCount lottoCount) {
        return Lottos.of(lottoCount);
    }
}
