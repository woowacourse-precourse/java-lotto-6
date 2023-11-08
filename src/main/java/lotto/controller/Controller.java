package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import lotto.domain.Buyer;
import lotto.domain.Judgement;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningRule;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private Buyer buyer;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private boolean getPurchasePriceFlag = false;
    private boolean getPurchaseLotteriesInformationFlag = false;
    private boolean getWinningNumbersFlag = false;
    private boolean getBonusNumberFlag = false;


    public void run() {
        do {
            try {
                runToGetPurchasePrice();
                runToGetPurchaseLotteriesInformationFlag();
                runToGetWinningNumbers();
                runToGetBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        getWinningStatistics();
    }

    private void runToGetPurchasePrice() {
        if (!getPurchasePriceFlag) {
            getPurchasePrice();
            getPurchasePriceFlag = true;
            OutputView.printNewLine();
        }
    }

    private void runToGetPurchaseLotteriesInformationFlag() {
        if (!getPurchaseLotteriesInformationFlag) {
            getPurchaseLotteriesInformation(buyer.getLottoQuantity());
            getPurchaseLotteriesInformationFlag = true;
            OutputView.printNewLine();
        }
    }

    private void runToGetWinningNumbers() {
        if (!getWinningNumbersFlag) {
            getWinningNumbers();
            getWinningNumbersFlag = true;
            OutputView.printNewLine();
        }
    }

    private void runToGetBonusNumber() {
        if (!getBonusNumberFlag) {
            getBonusNumber();
            getBonusNumberFlag = true;
            OutputView.printNewLine();
        }
    }

    private void getPurchasePrice() {
        String inputPurchasePrice = askPurchasePrice();
        inputPurchasePrice = removeComma(inputPurchasePrice);
        checkInputPurchasePriceValidation(inputPurchasePrice);
        buyer = new Buyer(Integer.parseInt(inputPurchasePrice));
    }

    private String askPurchasePrice() {
        InputView.showAskPurchasePrice();
        return Console.readLine().trim();
    }

    private String removeComma(String inputPurchasePrice) {
        if (inputPurchasePrice.contains(",")) {
            inputPurchasePrice = inputPurchasePrice.replace(",", "");
        }
        return inputPurchasePrice;
    }

    private void checkInputPurchasePriceValidation(String inputPurchasePrice) {
        InputValidator.isNullOrIsEmpty(inputPurchasePrice);
        InputValidator.isNotDigit(inputPurchasePrice);
        InputValidator.isNotPositiveNumber(inputPurchasePrice);
    }

    private void getPurchaseLotteriesInformation(int lottoQuantity) {
        for (int i = 0; i < lottoQuantity; i++) {
            buyer.addPurchaseLotto(new Lotto(generateLottoNumbers()));
        }
        showLottoQuantity();
        showPurchaseLotteries(buyer.getPurchaseLotteries());
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void showLottoQuantity() {
        OutputView.showLottoQuantity(buyer.getLottoQuantity());
    }

    private void showPurchaseLotteries(List<Lotto> purchaseLotteries) {
        for (Lotto purchaseLotto : purchaseLotteries) {
            OutputView.showPurchaseLotto(purchaseLotto.getNumbers()
                                                        .stream()
                                                        .sorted()
                                                        .toList());
        }
    }

    private void getWinningNumbers() {
        String inputWinningNumbers = askWinningNumbers();
        List<String> isSplitWinningNumbers = splitWinningNumbers(inputWinningNumbers);
        checkInputWinningNumbersValidation(inputWinningNumbers, isSplitWinningNumbers);
        winningNumbers = new WinningNumbers(convertedWinningNumbers(isSplitWinningNumbers));
    }

    private String askWinningNumbers() {
        InputView.showAskWinningNumbers();
        return Console.readLine().trim();
    }

    private List<String> splitWinningNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(","))
                .map(String::trim)                                  // 분할 후 각 문자 공백 제거
                .collect(Collectors.toList());
    }

    private void checkInputWinningNumbersValidation(String inputWinningNumbers, List<String> isSplitWinningNumbers) {
        InputValidator.isNullOrIsEmpty(inputWinningNumbers);
        InputValidator.includeSymbolExceptComma(inputWinningNumbers);
        InputValidator.isNotDigits(isSplitWinningNumbers);
    }

    private List<Integer> convertedWinningNumbers(List<String> isSplitWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : isSplitWinningNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    private void getBonusNumber() {
        String inputBonusNumber = askBonusNumber();
        checkInputBonusNumberValidation(inputBonusNumber);
        bonusNumber = new BonusNumber(Integer.parseInt(inputBonusNumber), winningNumbers.getWinningNumbers());
    }

    private String askBonusNumber() {
        InputView.showAskBonusNumber();
        return Console.readLine().trim();
    }

    private void checkInputBonusNumberValidation(String inputBonusNumber) {
        InputValidator.isNullOrIsEmpty(inputBonusNumber);
        InputValidator.isNotOneNumber(inputBonusNumber);
        InputValidator.isNotDigit(inputBonusNumber);
    }

    private void getWinningStatistics() {
        OutputView.showWinningStatisticsMessage();
        Judgement judgement = new Judgement();
        HashMap<WinningRule, Integer> results = judgement.getResults(buyer, winningNumbers, bonusNumber);
        List<WinningRule> ranks = Stream.of(WinningRule.values())
                .filter(rank -> rank != WinningRule.NOTHING)
                .collect(Collectors.toList());
        for (WinningRule rank : ranks) {
            OutputView.showWinningResult(results, rank);
        }
        OutputView.showReturnRate(judgement.getReturnRate(buyer.getPurchasePrice()));
    }
}
