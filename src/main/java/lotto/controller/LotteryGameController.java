package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.LotteryMessageBuilder;
import lotto.domain.lottery.*;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.constants.LottoConstraint.LOTTO_PRICE;

public class LotteryGameController {

    private final static String SPLIT_SYMBOL = ",";

    private final InputView inputView = new InputView();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final LotteryMessageBuilder lotteryMessageBuilder = new LotteryMessageBuilder();
    private final Computer computer = new Computer();

    private int lottoAmount;
    private final Lottos purchasedLotto = new Lottos();
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    public void run() {
        OutputView.requestPurchaseAmountMessage();
        int purchaseAmount = amountOfLottos();

        purchaseLotto(purchaseAmount);
        OutputView.returnLottery(lottoAmount,
                lotteryMessageBuilder.returnLottoList(purchasedLotto.getLottos()));

        requestWinningNumber();
        requestBonusNumber();

        returnLotteryResult();
    }

    private void returnLotteryResult() {
        Map<Integer, Integer> winningStats = new HashMap<>();
        computer.checkWinningLotto(purchasedLotto, winningLotto, bonusNumber, winningStats);
    }

    private void requestBonusNumber() {
        OutputView.requestBonusNumberMessage();
        String input = inputView.returnInput();
        bonusNumber = new BonusNumber(Integer.parseInt(input));
    }

    private void requestWinningNumber() {
        OutputView.requestWinningNumberMessage();

        winningLotto = new WinningLotto(inputWinningNumber());
    }

    private List<Integer> inputWinningNumber() {
        OutputView.requestWinningNumberMessage();
        String input = inputView.returnInput();
        String[] numberStrings = input.split(SPLIT_SYMBOL);

        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }

        return numbers;
    }

    private void purchaseLotto(int purchaseAmount) {
        lottoAmount = purchaseAmount / LOTTO_PRICE.getValue();

        for (int i = 0; i < lottoAmount; i++) {
            purchasedLotto.addLotto(new Lotto(lottoNumberGenerator.generateSortedLottoNumber()));
        }
    }
}
