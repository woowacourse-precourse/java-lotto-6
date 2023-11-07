package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.AmountCalculator;
import lotto.service.LottoMachine;
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

    public void play() {
        getAmount();
        printNumberOfLottoPurcased();
        generateLottos(numberOfLottoPurchased);
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
    }

    private void getWinnerNumber() {
        String winnerNumber = InputView.LOTTO_NUMBER.getInput();
        String[] winnerNumberItems = winnerNumber.split(",");
        winnerNumbers = Arrays.stream(winnerNumberItems).map(Integer::parseInt).collect(Collectors.toList());
        winnerLottoNumber = new Lotto(winnerNumbers);
    }


}