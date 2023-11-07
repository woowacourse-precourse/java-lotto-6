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

    private static List<Lotto> lottoList;
    private static LottoTarget lottoTarget;

    public LottoController() {
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        lottoTarget = makeLottoTarget();
        lottoResult(ticketCount * LottoUtil.LOTTO_PRICE);
    }

    private int inputPlayerAmount() {
        PlayerLottoAmount playerLottoAmount;
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
        List<Integer> lottoWinningNumList = makeLottoWinningNumList();
        int bonusNumber = makeBonusNumber();
        return new LottoTarget(new Lotto(lottoWinningNumList), bonusNumber);
    }

    private static List<Integer> makeLottoWinningNumList() {
        return InputView.inputLottoWinningNum();
    }

    private static int makeBonusNumber() {
        try {
            return InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            return makeBonusNumber();
        }
    }

    private static void lottoResult(int amount) {
        List<ResultStatus> resultStatuses = LottoUtil.gradingLottoListWithLottoTarget(lottoTarget, lottoList);
        LottoUtil.printResult(resultStatuses, amount);
    }
}
