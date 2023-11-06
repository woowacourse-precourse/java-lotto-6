package lotto.service;

import static lotto.constant.Prize.FIFTH;
import static lotto.constant.Prize.FIRST;
import static lotto.constant.Prize.FOURTH;
import static lotto.constant.Prize.SECOND;
import static lotto.constant.Prize.THIRD;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import lotto.Lotto;
import lotto.domain.User;
import lotto.domain.dto.WinningResult;
import lotto.domain.lottery.WinningLotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.LottoNumberGeneratorImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    private static final LottoMachine lottoMachine = new LottoMachine(new LottoNumberGeneratorImpl());
    private static WinningLotto winningLotto;

    public static void purchaseLotto() {
        try {
            OutputView.notifyInputMoney();
            int inputMoney = InputView.inputMoney();
            List<Lotto> lottoList = lottoMachine.issueLottoListForInputMoney(inputMoney);

            User.consumeMoney(inputMoney);
            User.acquireLottoList(lottoList);

            OutputView.notifyLottoPurchase(lottoList.stream()
                    .map(Lotto::getNumberList)
                    .toList());
        } catch (IllegalArgumentException ignore) {
            purchaseLotto();
        }
    }

    public static void requestWinningLotto() {
        List<Integer> lottoNumbers = inputWinningLottoNumber();

        int bonusNumber = inputBonusLottoNumber(lottoNumbers);

        winningLotto = WinningLotto.create(lottoNumbers, bonusNumber);
    }

    private static List<Integer> inputWinningLottoNumber() {
        try {
            OutputView.notifyInputWinningLottoNumber();

            List<Integer> result = InputView.inputWinningLottoNumber();
            new Lotto(result);

            return result;
        } catch (IllegalArgumentException ignore) {
            return inputWinningLottoNumber();
        }
    }

    private static int inputBonusLottoNumber(List<Integer> lottoNumbers) {
        try {
            OutputView.notifyInputBonusLottoNumber();

            int result = InputView.inputBonusNumber();
            WinningLotto.create(lottoNumbers, result);

            return result;
        } catch (IllegalArgumentException ignore) {
            return inputBonusLottoNumber(lottoNumbers);
        }
    }

    public static void figureOutLottoGame() {
        WinningResult winningResult = WinningResult.of(FIRST, SECOND, THIRD, FOURTH, FIFTH);

        User.getLottoList().forEach(lotto -> checkWinningLotto(winningResult, lotto));

        OutputView.notifyWinningResult(winningResult);

        int totalReceivedMoney = winningResult.prizes()
                .entrySet()
                .stream()
                .mapToInt(i -> i.getKey().getReward() * i.getValue())
                .sum();

        User.receiveMoney(totalReceivedMoney);
    }

    private static void checkWinningLotto(WinningResult winningResult, Lotto lotto) {
        int winningHit = checkWinningHit(winningLotto.getNumberList(), lotto.getNumberList());
        int bonusHit = checkBonusHit(lotto);

        winningResult.prizes().forEach((prize, i) -> {
            if (prize.getWinningHit() == winningHit && prize.getBonusHit().contains(bonusHit)) {
                winningResult.prizes().replace(prize, i + 1);
            }
        });
    }

    private static int checkWinningHit(List<Integer> winningList, List<Integer> lottoList) {
        HashSet<Integer> winningSet = new HashSet<>(winningList);
        HashSet<Integer> lottoSet = new HashSet<>(lottoList);

        winningSet.retainAll(lottoSet);

        return winningSet.size();
    }

    private static int checkBonusHit(Lotto lotto) {
        if (lotto.getNumberList().contains(winningLotto.getBonusNumber())) {
            return 1;
        }
        return 0;
    }

    public static void calculateTotalRateOfReturn() {
        int consumedMoney = User.getConsumedMoney();
        int receivedMoney = User.getReceivedMoney();

        float totalRateOfReturn = (float) receivedMoney * 100 / (float) consumedMoney;

        OutputView.notifyTotalRateOfReturn(totalRateOfReturn);
    }

    public static void endLottoGame() {
        Console.close();
    }
}
