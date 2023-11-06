package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTarget;
import lotto.model.LottoUtil;
import lotto.model.PlayerLottoAmount;
import lotto.model.ResultStatus;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {
    }

    private static List<Lotto> lottoList;
    private static LottoTarget lottoTarget;
    private static PlayerLottoAmount playerLottoAmount;

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        lottoTarget = makeLottoTarget();
        lottoResult(ticketCount * 1000);
    }

    private int inputPlayerAmount() {
        try {
            playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        } catch (IllegalArgumentException e) {
            return inputPlayerAmount(); // 재귀
        }

        return playerLottoAmount.calculateLottoCount();
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        return LottoUtil.createLottoList(ticketCount);
    }

    private static LottoTarget makeLottoTarget() {
        List<Integer> integerList = InputView.inputLottoWinningNum();
        int bonusNumber = InputView.inputBonusNumber();

        Lotto lotto = new Lotto(integerList);
        return new LottoTarget(lotto, bonusNumber);
    }

    public static void lottoResult(int amount) {
        List<ResultStatus> resultStatuses = LottoUtil.gradingLottoListWithLottoTarget(lottoTarget, lottoList);
        LottoUtil.printResult(resultStatuses, amount);
    }
}
