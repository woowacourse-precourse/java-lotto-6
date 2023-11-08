package lotto.controller;

import lotto.domain.*;
import lotto.service.InputValidatorService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameController {
    private static final String COMMA = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidatorService inputValidatorService;
    private final List<Lotto> issueLottos = new ArrayList<>();
    private WinningLotto winningLotto;
    private int purchaseLottoAmount;

    public LottoGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        inputValidatorService = new InputValidatorService();
    }

    public void play() {
        setIssueLotto();
        setWinningLottoNumbers();
        setLottoStatistic();
    }

    private void setIssueLotto() {
        purchaseLottoAmount = inputLottoPurchaseAmount();
        int purchaseLottoCount = calculatePurchaseLottoCount(purchaseLottoAmount);
        outputView.printCountPurchaseLotto(purchaseLottoCount);
        for (int issueLottoCount = 0; issueLottoCount < purchaseLottoCount; issueLottoCount++) {
            issueLottos.add(new Lotto(LottoNumbersGenerator.generate()));
        }
        issueLottos.forEach(lotto -> outputView.printIssuedLottoNumbers(lotto.getNumbers()));
    }

    private int inputLottoPurchaseAmount() {
        String lottoPurchaseAmount;
        outputView.printLottoPurchaseAmountInputMessage();
        while (true) {
            try {
                lottoPurchaseAmount = inputView.inputLottoPurchaseAmount();
                inputValidatorService.validateInputPurchaseAmount(lottoPurchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(lottoPurchaseAmount);
    }

    private int calculatePurchaseLottoCount(int purchaseLottoMoney) {
        return LottoPurchaseCount.calculate(purchaseLottoMoney);
    }

    private void setWinningLottoNumbers() {
        List<Integer> lottoWinningNumbers = inputLottoWinningNumbers();
        outputView.printBonusNumberInputMessage();
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                inputValidatorService.validateInputBonusNumber(bonusNumber);
                int lottoBonusNumber = Integer.parseInt(bonusNumber);
                winningLotto = new WinningLotto(lottoWinningNumbers, lottoBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputLottoWinningNumbers() {
        outputView.printWinningNumbersInputMessage();
        String winningNumbers;
        while (true) {
            try {
                winningNumbers = inputView.inputWinningNumbers();
                inputValidatorService.validateInputWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return splitLottoWinningNumbers(winningNumbers);
    }

    private List<Integer> splitLottoWinningNumbers(String lottoWinningNumbers) {
        return Arrays.stream(lottoWinningNumbers.split(COMMA))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void setLottoStatistic() {
        LottoStatistic lottoStatistic = new LottoStatistic(issueLottos, winningLotto);
        outputView.printWinningStatisticsMessage();
        outputView.printLottoStatistic(lottoStatistic.getResult());
        outputView.printAllReturnRate(lottoStatistic.getAllReturnRate(purchaseLottoAmount));
    }
}
