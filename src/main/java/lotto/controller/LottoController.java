package lotto.controller;

import static lotto.domain.constants.LottoConstants.NUMBER_SPLIT_FORMAT;
import static lotto.view.message.OutputMessage.ASK_FOR_BONUS_NUMBER;
import static lotto.view.message.OutputMessage.ASK_FOR_LOTTO_WINNING_NUMBERS;
import static lotto.view.message.OutputMessage.ASK_FOR_PURCHASE_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.result.LottoCalculateResult;
import lotto.domain.result.LottoMatchResult;
import lotto.domain.result.LottoPurchaseResult;
import lotto.dto.LottoResultDto;
import lotto.domain.result.LottoWinningResult;
import lotto.domain.Purchase;
import lotto.model.LottoModel;
import lotto.view.LottoView;

public class LottoController {
    private final LottoModel model;
    private final LottoView view;

    public LottoController(LottoModel model, LottoView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        LottoPurchaseResult purchaseResult = generatePurchaseResult();
        view.displayPurchaseResult(purchaseResult);

        LottoWinningResult winningResult = generateWinningResult();
        LottoMatchResult matchResult = matchResult(purchaseResult, winningResult);
        LottoCalculateResult calculateResult = calculateResult(matchResult, purchaseResult);

        LottoResultDto resultDto = LottoResultDto.fromMatchAndCalculateResults(matchResult, calculateResult);
        view.displayResult(resultDto);
    }

    private LottoPurchaseResult generatePurchaseResult() {
        Purchase purchase = promptPurchase();
        List<Lotto> lottos = generateLottos(purchase);

        return new LottoPurchaseResult(lottos, purchase);
    }

    private List<Lotto> generateLottos(Purchase purchase) {
        return model.generateLottos(purchase);
    }

    private LottoWinningResult generateWinningResult() {
        List<Integer> winningNumbers = promptWinningNumbers();
        int bonusNumber = promptBonusNumber();

        return new LottoWinningResult(winningNumbers, bonusNumber);
    }

    private Purchase promptPurchase() {
        view.displayMessage(ASK_FOR_PURCHASE_PRICE);
        int purchasePrice = Integer.parseInt(view.readInput());
        return new Purchase(purchasePrice);
    }

    private List<Integer> promptWinningNumbers() {
        view.displayMessage(ASK_FOR_LOTTO_WINNING_NUMBERS);
        String input = view.readInput();
        List<String> inputNumbers = new ArrayList<>(Arrays.asList(input.split(NUMBER_SPLIT_FORMAT)));
        return inputNumbers.stream().map(Integer::parseInt).toList();
    }

    private int promptBonusNumber() {
        view.displayMessage(ASK_FOR_BONUS_NUMBER);
        return Integer.parseInt(view.readInput());
    }

    private LottoMatchResult matchResult(LottoPurchaseResult lottoPurchaseResult, LottoWinningResult lottoWinningResult) {
        return model.matchResult(lottoPurchaseResult, lottoWinningResult);
    }

    private LottoCalculateResult calculateResult (LottoMatchResult lottoMatchResult, LottoPurchaseResult purchaseResult) {
        return model.calculateResult(lottoMatchResult, purchaseResult);
    }
}
