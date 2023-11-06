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

    private static final int LOTTO_PRICE = 1000;
    private static List<Lotto> lottoList;
    private static LottoTarget lottoTarget;

    public LottoController() {
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        lottoTarget = makeLottoTarget();
        lottoResult(ticketCount * LOTTO_PRICE);
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
        } catch (Exception e) {
            // InputView.inputBonusNumber 함수에서 에러가 여러개 나올 수 있기 때문에 Exception으로 catch
            return makeBonusNumber();
        }
    }

    private static void lottoResult(int amount) {
        List<ResultStatus> resultStatuses = LottoUtil.gradingLottoListWithLottoTarget(lottoTarget, lottoList);
        LottoUtil.printResult(resultStatuses, amount);
    }
}
