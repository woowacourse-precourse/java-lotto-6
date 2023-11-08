package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.view.OutputView;
import lotto.view.Prompt;
import lotto.view.Status;
import lotto.view.input.AmountInputView;
import lotto.view.input.BonusInputView;
import lotto.view.input.InputView;
import lotto.view.input.LottoInputView;

public class LottoController {
    private static final long ZERO = 0;
    private static final double FOR_PERCENTAGE = 10.0;
    private final Lottos lottos = new Lottos();
    private Lotto answerNumber;
    private long totalEarn = 0;
    private Status status = Status.GOT_NOTHING;

    private void createLotto() {
        try {
            InputView lottoInputView = new LottoInputView();
            List<Integer> answerNumbers = new LottoInputView().getLottoNumbers();
            answerNumber = new Lotto(answerNumbers);
            status = Status.GOT_MESSAGE;
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            status = Status.GOT_ERROR;
        }
    }

    private void purchase(long amount) {
        lottos.purchaseLotto(amount);
        OutputView.printMessage(String.format(Prompt.PURCHASE_MESSAGE.getMessage(), amount));
    }

    private void getAnswerNumbers() {
        while (status.getStatus()) {
            createLotto();
        }
    }

    private void checkWinTheLottery(int bonusNumber) {
        final HashMap<Rank, Long> rank = lottos.checkWin(answerNumber, bonusNumber);

        OutputView.printMessage(Prompt.GATHERING_MESSAGE.getMessage());
        printEachSummarize(rank);

    }

    private void printEachSummarize(HashMap<Rank, Long> rank) {
        for (Rank value : Rank.values()) {
            if (value == Rank.NONE) {
                continue;
            }
            long wonTimes = rank.getOrDefault(value, ZERO);
            String message = String.format(Prompt.STATISTIC_MESSAGE.getMessage(), value.getScore(),
                    value.getEarn(), wonTimes);
            
            OutputView.printMessage(message);
            getTotalEarn(value.getPrice(), wonTimes);
        }
    }

    private void getTotalEarn(long earn, long wonTimes) {
        totalEarn += earn * wonTimes;
    }

    public void play() {
        long amount = new AmountInputView().getNumberOfLotto();
        purchase(amount);
        getAnswerNumbers();

        int bonusNumber = new BonusInputView().getBonusNumber();
        checkWinTheLottery(bonusNumber);

        double summary = totalEarn / (amount * FOR_PERCENTAGE);
        OutputView.printMessage(String.format(Prompt.INCOME_MESSAGE.getMessage(), summary));
    }
}