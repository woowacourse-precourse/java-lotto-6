package lotto.module.api;

import java.util.List;
import java.util.Map;
import lotto.global.constant.CommonCode;
import lotto.module.application.LottoService;
import lotto.module.domain.Lotto;
import lotto.module.view.InputView;
import lotto.module.view.OutputView;

public class LottoController {
    private static final LottoController instance = new LottoController();
    private static final LottoService lottoService = LottoService.getInstance();

    private LottoController() {
    }

    public static LottoController getInstance() {
        return instance;
    }

    public void run() {
        Integer buyAmount = this.getBuyAmount();
        List<Lotto> userLottoList = this.generateUserLottoList(buyAmount);

        Lotto winLotto = this.getWinLotto();
        int bonusNumber = this.getBonusNumber(winLotto);

        this.calcStatics(userLottoList, winLotto, bonusNumber, buyAmount);
    }

    public Integer getBuyAmount() {
        do {
            try {
                OutputView.printEnterBuyAmount();
                return InputView.readBuyAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public List<Lotto> generateUserLottoList(Integer buyAmount) {
        int gameCount = buyAmount / CommonCode.BUY_MIN_UNIT;
        OutputView.printGameCount(gameCount);

        List<Lotto> userLottoList = lottoService.generateLottoList(gameCount);
        userLottoList.forEach(Lotto::print);
        return userLottoList;
    }

    public Lotto getWinLotto() {
        do {
            try {
                OutputView.printEnterWinNumbers();
                return InputView.readWinLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public Integer getBonusNumber(Lotto winLotto) {
        do {
            try {
                OutputView.printEnterBonusNumber();
                return InputView.readBonusNumber(winLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void calcStatics(List<Lotto> userLottoList, Lotto winLotto, Integer bonusNumber, Integer buyAmount) {
        Map<Long, Integer> statics = lottoService.getStaticsMap(userLottoList, winLotto, bonusNumber);
        long totalWinAmount = lottoService.calcTotalWinAmount(statics);

        String calcRate = lottoService.calcRate(totalWinAmount, buyAmount);
        OutputView.printReport(statics, calcRate);
    }
}
