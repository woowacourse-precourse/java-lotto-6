package lotto.controller;

import static lotto.utils.parser.NumberParser.parseListStringToListInteger;
import static lotto.utils.parser.NumberParser.parseStringToIntNumber;
import static lotto.utils.parser.NumberParser.parseStringToIntPrice;
import static lotto.view.message.OutputMessage.ASK_FOR_BONUS_NUMBER;
import static lotto.view.message.OutputMessage.ASK_FOR_LOTTO_WINNING_NUMBERS;
import static lotto.view.message.OutputMessage.ASK_FOR_PURCHASE_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.result.CalculateResult;
import lotto.domain.result.MatchResult;
import lotto.domain.result.PurchaseResult;
import lotto.dto.ResultDto;
import lotto.domain.result.WinningResult;
import lotto.domain.Purchase;
import lotto.exception.LottoException;
import lotto.model.Model;
import lotto.view.LottoView;

public class Controller {
    private final Model model;
    private final LottoView view;

    public Controller(Model model, LottoView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        PurchaseResult purchaseResult = generatePurchaseResult();
        view.displayPurchaseResult(purchaseResult);

        WinningResult winningResult = generateWinningResult();
        MatchResult matchResult = matchResult(purchaseResult, winningResult);
        CalculateResult calculateResult = calculateResult(matchResult, purchaseResult);

        ResultDto resultDto = ResultDto.of(matchResult, calculateResult);
        view.displayResult(resultDto);
    }

    private PurchaseResult generatePurchaseResult() {
        Purchase purchase = promptPurchase();
        List<Lotto> lottos = generateLottos(purchase);

        return new PurchaseResult(lottos, purchase);
    }

    private List<Lotto> generateLottos(Purchase purchase) {
        return model.generateLottos(purchase);
    }

    private WinningResult generateWinningResult() {
        List<Integer> winningNumbers = promptWinningNumbers();
        int bonusNumber = promptBonusNumber();

        return new WinningResult(winningNumbers, bonusNumber);
    }

    private Purchase promptPurchase() {
        int purchasePrice = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            view.displayMessage(ASK_FOR_PURCHASE_PRICE);
            String input = view.readInput();
            try {
                purchasePrice = parseStringToIntPrice(input);
                isValidInput = true;
            } catch (LottoException e) {
                view.displayErrorMessage(e);
            }
        }
        return new Purchase(purchasePrice);
    }

    private List<Integer> promptWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        boolean isValidInput = false;

        while (!isValidInput) {
            view.displayMessage(ASK_FOR_LOTTO_WINNING_NUMBERS);
            String input = view.readInput();
            try {
                winningNumbers = parseListStringToListInteger(input);
                isValidInput = true;
            } catch (LottoException e) {
                view.displayErrorMessage(e);
            }
        }

        return winningNumbers;
    }

    private int promptBonusNumber() {
        int bonusNumber = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            view.displayMessage(ASK_FOR_BONUS_NUMBER);
            String input = view.readInput();
            try {
                bonusNumber = parseStringToIntNumber(input);
                isValidInput = true;
            } catch (LottoException e) {
                view.displayErrorMessage(e);
            }
        }
        return bonusNumber;
    }

    private MatchResult matchResult(PurchaseResult purchaseResult, WinningResult winningResult) {
        return model.matchResult(purchaseResult, winningResult);
    }

    private CalculateResult calculateResult (MatchResult matchResult, PurchaseResult purchaseResult) {
        return model.calculateResult(matchResult, purchaseResult);
    }
}
