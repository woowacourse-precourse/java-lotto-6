package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.AmountCalculator;
import lotto.service.LottoCalculator;
import lotto.service.LottoMachine;
import lotto.service.RateOfReturnCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private String amount;
    private List<Lotto> lottos;
    private int numberOfLottoPurchased;
    private List<Integer> winnerNumbers;
    private Lotto winnerLottoNumber;
    private int bonusNumber;
    private int prize = 0;
    private List<Integer> finalMatchNumbers;

    public void play() {
        getAmount();
        printNumberOfLottoPurcased();
        generateLottos(numberOfLottoPurchased);
        getWinnerNumber();
        getBonusNumber();
        getPrize();
        printPrize();

    }

    private void getAmount() {
        amount = InputView.AMOUNT.getInput();
        AmountCalculator amountCalculator = new AmountCalculator(Integer.parseInt(amount));
        numberOfLottoPurchased = amountCalculator.getNumberOfLottoPurchased();
    }

    private void printNumberOfLottoPurcased() {
        OutputView.printNumberOfLottoPurchased(numberOfLottoPurchased);
    }

    private void generateLottos(int numberOfLottoPurchased) {
        lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottoPurchased; i++) {
            LottoMachine lottoMachine = new LottoMachine();
            lottos.add(new Lotto(lottoMachine.getRandomNumbers()));
        }

        OutputView.printLottos(lottos);
        System.out.println();
    }

    private void getWinnerNumber() {
        String winnerNumber = InputView.LOTTO_NUMBER.getInput();
        String[] winnerNumberItems = winnerNumber.split(",");
        winnerNumbers = Arrays.stream(winnerNumberItems).map(Integer::parseInt).collect(Collectors.toList());
        winnerLottoNumber = new Lotto(winnerNumbers);
        System.out.println();
    }

    private void getBonusNumber() {
        String bonusNumberItem = InputView.BONUMS_NUMBER.getInput();
        bonusNumber = Integer.parseInt(bonusNumberItem);
        System.out.println();
    }

    private void getPrize() {
        for (Lotto usernumber : lottos) {
            prize += LottoCalculator.calculatePrize(usernumber.getNumbers(), winnerNumbers, bonusNumber);
        }
        finalMatchNumbers = LottoCalculator.getFinalMatchNumbers();
        System.out.println(finalMatchNumbers);
        System.out.println(prize);
    }

    private void printPrize() {
        OutputView.printStatics(finalMatchNumbers, RateOfReturnCalculator.calculateRateOfReturn(Integer.parseInt(amount), prize));
    }
}