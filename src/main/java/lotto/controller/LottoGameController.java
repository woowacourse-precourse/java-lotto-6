package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.exception.InputExceptionConstant;
import lotto.service.LottoGameService;
import lotto.util.InputValidator;
import lotto.util.LottoGameUtil;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoGameService service;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initGame();
    }

    private void initGame() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        Lotties lotties = setLotties(purchaseAmount.getLottoCount());

        String lottiesStatus = lotties.getLottiesStatus();
        int lottoCount = purchaseAmount.getLottoCount();

        outputView.printLotties(lottiesStatus, lottoCount);

        WinningNumbers winningNumbers = setWinningNumbers();
        BonusNumber bonusNumber = setBonusNumber();

        this.service = new LottoGameService(purchaseAmount, winningNumbers, bonusNumber, lotties);
    }

    private Lotties setLotties(int count) {
        List<Lotto> lottoSaver = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers();
            Collections.sort(randomNumbers);
            lottoSaver.add(new Lotto(randomNumbers));
        }

        return new Lotties(lottoSaver);
    }

    private BonusNumber setBonusNumber() {
        while (true) {
            try {
                String input = inputView.inputBonusNumber();
                InputValidator.validatePurchaseNumber(input);

                int number = LottoGameUtil.StringToInt(input);

                return new BonusNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING);
            }
        }
    }

    private WinningNumbers setWinningNumbers() {
        while (true) {
            try {
                String[] inputArray = inputView.inputWinningNumbers();
                InputValidator.isNaturalNumbers(inputArray);

                List<Integer> numbers = LottoGameUtil.StringArrayToList(inputArray);

                return new WinningNumbers(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING_ARRAY.getText());
            }
        }
    }

    private PurchaseAmount setPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.inputPurchaseAmount();
                InputValidator.validatePurchaseNumber(input);

                int number = LottoGameUtil.StringToInt(input);

                return new PurchaseAmount(number);
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING.getText());
            }
        }
    }
}
