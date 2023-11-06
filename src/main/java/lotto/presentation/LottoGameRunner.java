package lotto.presentation;

import lotto.application.LottoGame;
import lotto.application.LottoGameInfo;
import lotto.domain.exception.LottoException;
import lotto.presentation.mapper.GameResult;
import lotto.presentation.mapper.GameResultMapper;
import lotto.presentation.message.Notice;
import lotto.global.exception.GlobalException;
import lotto.global.util.channel.print.Printer;
import lotto.global.util.channel.read.ReaderForBonus;
import lotto.global.util.channel.read.ReaderForPurchase;
import lotto.global.util.channel.read.ReaderForWinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoGameRunner {

    private static LottoGameRunner RUNNER;

    private final ReaderForPurchase purchaseReader = new ReaderForPurchase();
    private final ReaderForWinningLotto winningLottoReader = new ReaderForWinningLotto();
    private final ReaderForBonus bonusReader = new ReaderForBonus();

    private LottoGame lottoGame;

    private LottoGameRunner() {
    }

    public static LottoGameRunner getRunner() {
        if (Objects.isNull(RUNNER)) {
            RUNNER = new LottoGameRunner();
        }
        return RUNNER;
    }

    public void run() {
            purchase();

            generateWinningLotto();

            viewResult();
    }


    private void purchase() {
        // 입력한 구입금액에 따라 로또를 발행한다.
        lottoGame = LottoGame.createLottoGame(receivePaymentAmount());
        LottoGameInfo.PurchaseStatus purchaseStatus = lottoGame.checkPurchaseStatus();

        // 발행된 로또 결과를 출력한다.
        GameResult.IssuedLottos issuedLottos = GameResultMapper.ofLottos(purchaseStatus);
        Printer.print(issuedLottos.toResult());
    }

    private void generateWinningLotto() {
        boolean isRegistered = false;
        while (!isRegistered) {
            try {
                List<Integer> winningNumbers = receiveWinningNumbers();
                lottoGame.registerWinningNumbers(winningNumbers);
                int winningBonus = receiveWinningBonus();
                lottoGame.registerWinningBonus(winningBonus);
                isRegistered = true;
            } catch (GlobalException | LottoException exception) {
                Printer.print(exception.getMessage());
            }
        }
    }

    private void viewResult() {
        Printer.print(Notice.WINNING_STATISTICS);

        GameResult.WinningStatistic winningStatistic = GameResultMapper.ofGame(lottoGame.checkMatchResult());
        Printer.print(winningStatistic.toResult());

        GameResult.RevenueRate revenueRate = GameResultMapper.ofGameResult(lottoGame.checkRevenue());
        Printer.print(revenueRate.toResult());
    }


    private long receivePaymentAmount() {
        String inputAmount = purchaseReader.read();
        return Long.parseLong(inputAmount);
    }

    private List<Integer> receiveWinningNumbers() {
        String inputNumbers = winningLottoReader.read();
        return Arrays.stream(inputNumbers.split(",")).
                map(inputNumber -> Integer.parseInt(inputNumber.trim()))
                .toList();
    }

    private int receiveWinningBonus() {
        String inputNumber = bonusReader.read();
        return Integer.parseInt(inputNumber);
    }

}
