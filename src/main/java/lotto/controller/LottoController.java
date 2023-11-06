package lotto.controller;

import static lotto.utils.LottoNumberParser.parseListStringToListInteger;
import static lotto.utils.LottoNumberParser.parseStringToInt;
import static lotto.view.message.OutputMessage.ASK_FOR_BONUS_NUMBER;
import static lotto.view.message.OutputMessage.ASK_FOR_LOTTO_WINNING_NUMBERS;
import static lotto.view.message.OutputMessage.ASK_FOR_PURCHASE_PRICE;

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
        try {
            LottoPurchaseResult purchaseResult = generatePurchaseResult();
            view.displayPurchaseResult(purchaseResult);

            LottoWinningResult winningResult = generateWinningResult();
            LottoMatchResult matchResult = matchResult(purchaseResult, winningResult);
            LottoCalculateResult calculateResult = calculateResult(matchResult, purchaseResult);

            LottoResultDto resultDto = LottoResultDto.fromMatchAndCalculateResults(matchResult, calculateResult);
            view.displayResult(resultDto);

        } catch (IllegalArgumentException e) {
            view.displayErrorMessage(e);
        }
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
        int purchasePrice = parseStringToInt(view.readInput());
        return new Purchase(purchasePrice);
    }

    private List<Integer> promptWinningNumbers() {
        view.displayMessage(ASK_FOR_LOTTO_WINNING_NUMBERS);
        return parseListStringToListInteger(view.readInput());
    }

    private int promptBonusNumber() {
        view.displayMessage(ASK_FOR_BONUS_NUMBER);
        return parseStringToInt(view.readInput());
    }

    private LottoMatchResult matchResult(LottoPurchaseResult lottoPurchaseResult, LottoWinningResult lottoWinningResult) {
        return model.matchResult(lottoPurchaseResult, lottoWinningResult);
    }

    private LottoCalculateResult calculateResult (LottoMatchResult lottoMatchResult, LottoPurchaseResult purchaseResult) {
        return model.calculateResult(lottoMatchResult, purchaseResult);
    }
}
