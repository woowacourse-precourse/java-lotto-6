package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.*;
import lotto.view.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private String amount;
    private int numberOfLottoPurchased;
    private List<Lotto> userLottoNumbers;
    private List<Integer> winnerLottoNumbers;
    private Lotto winnerLottoNumber;
    private int bonusNumber;
    private int prize = 0;

    public void play() {
        try {
            getAmount();
            printNumberOfLottoPurcased();
            generateLottos();
            getWinnerNumber();
            getBonusNumber();
            getPrize();
            printPrize();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void getAmount() {
        amount = InputView.AMOUNT.getInput();
        Validator.validateAmount(amount);
        AmountCalculator amountCalculator = new AmountCalculator(Integer.parseInt(amount));
        numberOfLottoPurchased = amountCalculator.getNumberOfLottoPurchased();
    }

    private void printNumberOfLottoPurcased() {
        OutputView.printNumberOfLottoPurchased(numberOfLottoPurchased);
    }

    private void generateLottos() {
        userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfLottoPurchased; i++) {
            LottoMachine lottoMachine = new LottoMachine();
            userLottoNumbers.add(new Lotto(lottoMachine.getRandomNumbers()));
        }
        OutputView.printLottos(userLottoNumbers);
        System.out.println();
    }

    private void getWinnerNumber() {
        String winnerNumber = InputView.LOTTO_NUMBER.getInput();
        String[] winnerNumberItems = winnerNumber.split(",");
        winnerLottoNumbers = Arrays.stream(winnerNumberItems).map(Integer::parseInt).collect(Collectors.toList());
        winnerLottoNumber = new Lotto(winnerLottoNumbers);
        System.out.println();
    }

    private void getBonusNumber() {
        String bonusNumberItem = InputView.BONUMS_NUMBER.getInput();
        bonusNumber = Integer.parseInt(bonusNumberItem);
        System.out.println();
    }

    private void getPrize() {
        for (Lotto usernumber : userLottoNumbers) {
            prize += LottoCalculator.calculatePrize(usernumber.getNumbers(), winnerLottoNumber.getNumbers(), bonusNumber);
        }
    }

    private void printPrize() {
        OutputView.printStatics(LottoCalculator.getFinalMatchNumbers(), RateOfReturnCalculator.calculateRateOfReturn(Integer.parseInt(amount), prize));
    }
}