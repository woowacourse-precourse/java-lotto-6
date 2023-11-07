package lotto.controller;

import static lotto.model.parser.Parser.parseInputToBonusNumber;
import static lotto.model.parser.Parser.parseInputToPurchasePrice;
import static lotto.model.parser.Parser.parseInputToWinningNumbers;
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

        WinningResult winningResult = generateWinningNumbers();

        MatchResult matchResult = calculateMatch(purchaseResult, winningResult);
        CalculateResult calculateResult = calculateProfit(matchResult, purchaseResult);

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

    private WinningResult generateWinningNumbers() {
        List<Integer> winningNumbers = promptWinningNumbers();
        int bonusNumber = promptBonusNumber(winningNumbers);

        return new WinningResult(winningNumbers, bonusNumber);
    }

    private Purchase promptPurchase() {
        int purchasePrice = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            view.displayMessage(ASK_FOR_PURCHASE_PRICE);
            String input = view.readInput();
            try {
                purchasePrice = parseInputToPurchasePrice(input);
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
                winningNumbers = parseInputToWinningNumbers(input);
                isValidInput = true;
            } catch (LottoException e) {
                view.displayErrorMessage(e);
            }
        }
        return winningNumbers;
    }

    private int promptBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            view.displayMessage(ASK_FOR_BONUS_NUMBER);
            String input = view.readInput();
            try {
                bonusNumber = parseInputToBonusNumber(winningNumbers, input);
                isValidInput = true;
            } catch (LottoException e) {
                view.displayErrorMessage(e);
            }
        }
        return bonusNumber;
    }

    private MatchResult calculateMatch(PurchaseResult purchaseResult, WinningResult winningResult) {
        return model.calculateMatch(purchaseResult, winningResult);
    }

    private CalculateResult calculateProfit(MatchResult matchResult, PurchaseResult purchaseResult) {
        return model.calculateProfit(matchResult, purchaseResult);
    }
}
