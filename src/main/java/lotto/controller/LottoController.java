package lotto.controller;

import java.util.Arrays;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoStatistic;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.service.LottoService;
import lotto.service.PaymentService;
import lotto.service.StatisticService;
import lotto.service.WinningService;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Lottos lottos;
    private WinningNumber winningNumber;
    private LottoStatistic lottoStatistic;
    private final PaymentService paymentService;
    private final LottoService lottoService;
    private final WinningService winningService;
    private final StatisticService statisticService;
    private final InputView inputView;
    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator;

    public LottoController() {
        this.paymentService = new PaymentService();
        this.lottoService = new LottoService();
        this.winningService = new WinningService();
        this.statisticService = new StatisticService();
        this.inputView = new InputView();
        this.inputValidator = new InputValidator();
    }

    public void lottoStart() {
        int price = askForValidPrice(inputView, inputValidator);
        int lottoCount = paymentService.getLottoCount(price);
        this.lottos = lottoService.generateLottos(lottoCount);

        showLottos(lottos);
        Set<Integer> winningNumbers = askForValidWinningNumbers(inputView, inputValidator);
        int bonusNumber = askForValidBonusNumbers(inputView, inputValidator, winningNumbers);
        winningNumber = new WinningNumber(winningNumbers, bonusNumber);

        statisticLotto(winningService.checkWinning(lottos, winningNumber), 1000);
        showStatistic(lottoStatistic);
    }

    private int askForValidPrice(InputView inputView, InputValidator inputValidator) {
        while(true) {
            try {
                String input = inputView.askForPrice();
                inputValidator.validatePrice(input);
                return Integer.parseInt(input);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Set<Integer> askForValidWinningNumbers(InputView inputView, InputValidator inputValidator) {
        while(true) {
            try {
                String winningNumberInput = inputView.askForWinningNumber();
                inputValidator.validateWinningNumber(winningNumberInput);
                return parseWinningNumber(winningNumberInput);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int askForValidBonusNumbers(InputView inputView, InputValidator inputValidator, Set<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = inputView.askForBonusNumber();
                inputValidator.validateBonusNumber(bonusNumberInput);
                int bonusNumber = Integer.parseInt(bonusNumberInput);
                inputValidator.validateBonusNumberNotDuplicate(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Set<Integer> parseWinningNumber(String winningNumberInput) {
        return Arrays.stream(winningNumberInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    private void statisticLotto(Map<Lotto, LottoPrize> results, int lottoPrice) {
        this.lottoStatistic = statisticService.calculateLottoStatistics(results);
        this.lottoStatistic.setYield(statisticService.calculateYield(results, lottoPrice));
    }

    private void showLottos(Lottos lottos) {
        outputView.showLottos(lottos);
    }

    private void showStatistic(LottoStatistic lottoStatistic) {
        outputView.showStatistic(lottoStatistic);
    }
}
