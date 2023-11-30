package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.grobal.LottoConstants.*;
import static lotto.grobal.LottoConstants.MAX_LOTTO_NUMBER;

public class LottoController {

    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController(LottoView lottoView, LottoService lottoService) {
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    public void play() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = lottoService.buyLotto(purchaseAmount);
        lottoView.printLottos(lottos);

        Lotto winningLotto = new Lotto(inputWinningNumber());
        int bonusNumber = inputBonusNumber();

        Map<Rank, Long> results = lottoService.calculateResults(winningLotto, lottos, bonusNumber);
        double profit = lottoService.calculateProfit(lottos, results);

        lottoView.printResult(results, profit);
    }

    public int inputPurchaseAmount() {
        while (true) {
            try {
                return validatePurchaseAmount();
            } catch (IllegalArgumentException exception) {
                lottoView.printError(exception.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumber() {
        while (true) {
            try {
                return parseAndValidateNumbers(lottoView.inputWinningNumber());
            } catch (IllegalArgumentException exception) {
                lottoView.printError(exception.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                return validateBonusNumber();
            } catch (IllegalArgumentException exception) {
                lottoView.printError(exception.getMessage());
            }
        }
    }

    public int validatePurchaseAmount() {
        String input = lottoView.inputPurchaseAmount();
        validateIsNumber(input);

        int purchaseAmount = Integer.parseInt(input);
        validateUnit(purchaseAmount);
        validateIsPositiveNumber(purchaseAmount);

        return purchaseAmount;
    }

    private List<Integer> parseAndValidateNumbers(String input) {
        List<Integer> numbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

    private int validateBonusNumber() {
        String input = lottoView.inputBonusNumber();
        validateIsNumber(input);

        return Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private void validateIsPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력해주세요.");
        }
    }

    private void validateSingleNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
