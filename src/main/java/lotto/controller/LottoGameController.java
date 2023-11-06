package lotto.controller;

import static java.lang.String.format;
import static lotto.constant.LottoOutputMessage.*;
import static lotto.domain.LottoRank.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRank;
import lotto.domain.LottoStore;
import lotto.domain.PurchaseCount;
import lotto.domain.WinningNumber;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoGameService lottoGameService;

    public LottoGameController() {
        outputView = new OutputView();
        inputView = new InputView();
        lottoGameService = new LottoGameService();
    }

    public void run() {
        LottoGame lottoGame = initLottoGame();
        Map<LottoRank, Integer> lottoResult = lottoGameService.play(lottoGame);
        printLottoResult(lottoResult);
    }

    private void printLottoResult(Map<LottoRank, Integer> lottoResult) {
        outputView.output(WINNING_RESULT.getMessage());
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getCount() > 0)
                .forEach(rank -> {
                    String message = getResultMessage(lottoResult, rank);
                    outputView.output(message);
                });
    }

    private static String getResultMessage(Map<LottoRank, Integer> lottoResult, LottoRank rank) {
        int count = rank.getCount();
        String message = format(RANK_RESULT.getMessage(), count);
        if (rank == FIVE_BONUS) {
            message += format(BONUS_RESULT.getMessage());
        }
        String winningAmount = rank.getWinningAmount();
        int numberOfMatches = lottoResult.getOrDefault(rank, 0);
        message += format(COUNT_RESULT.getMessage(), winningAmount, numberOfMatches);
        return message;
    }

    private LottoGame initLottoGame() {
        PurchaseCount purchaseCount = initPurchaseAmount();
        LottoStore lottoStore = initLottoStore(purchaseCount);
        WinningNumber winningNumber = initWinningNumber();
        BonusNumber bonusNumber = initBonusNumber(winningNumber);
        return new LottoGame(lottoStore, winningNumber, bonusNumber);
    }

    private BonusNumber initBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                String bonusNumberInput = requestBonusNumber();
                return new BonusNumber(winningNumber, bonusNumberInput);
            } catch (IllegalArgumentException exception) {
                outputView.output(exception.getMessage());
            }
        }
    }

    private String requestBonusNumber() {
        outputView.output(BONUS_NUMBER.getMessage());
        return inputView.requestBonusNumber();
    }

    private WinningNumber initWinningNumber() {
        while (true) {
            try {
                List<String> winningNumberInput = requestWinningNumber();
                return new WinningNumber(winningNumberInput);
            } catch (IllegalArgumentException exception) {
                outputView.output(exception.getMessage());
            }
        }
    }

    private List<String> requestWinningNumber() {
        outputView.output(WINNING_NUMBER.getMessage());
        return inputView.requestWinningNumber();
    }

    private PurchaseCount initPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmountInput = requestPurchaseAmount();
                return new PurchaseCount(purchaseAmountInput);
            } catch (IllegalArgumentException exception) {
                outputView.output(exception.getMessage());
            }
        }
    }

    private String requestPurchaseAmount() {
        outputView.output(PURCHASE_AMOUNT.getMessage());
        return inputView.requestPurchaseAmount();
    }

    private LottoStore initLottoStore(PurchaseCount purchaseCount) {
        List<Lotto> lottos = lottoGameService.purchase(purchaseCount);
        outputView.output(
                format(PURCHASE_COUNT.getMessage(), lottos.size())
        );
        lottos.forEach(lotto -> outputView.output(lotto.toString()));
        return new LottoStore(lottos);
    }
}
