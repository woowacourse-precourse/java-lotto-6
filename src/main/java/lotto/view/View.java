package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.dto.ResultResponse;
import lotto.utils.GameUtilConstants;
import lotto.utils.Rank;
import lotto.validation.NumberException;
import lotto.validation.NumberValidator;
import lotto.validation.WinningNumberException;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Amount getAmount() {
        try {
            outputView.printPurchaseGuideMessage();
            String amountValue = inputView.inputAmount();
            return new Amount(convertToInt(amountValue));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getAmount();
        }
    }

    public WinningLotto getWinningLotto() {
        Lotto winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto getWinningNumbers() {
        try {
            outputView.printWinningNumbersGuideMessage();
            String winningNumbers = inputView.inputWinningNumbers();
            List<Integer> list = convertToIntegerList(winningNumbers);
            return new Lotto(list);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private List<Integer> convertToIntegerList(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(GameUtilConstants.LEST_DELIMITER.getValue(), -1))
            .peek(NumberValidator::validateNumber)
            .map(this::convertToInt)
            .peek(NumberValidator::validateInRangeNumber)
            .toList();
    }

    private int getBonusNumber(Lotto winningNumbers) {
        try {
            outputView.printBonusNumberGuideMessage();
            String bonusNumberValue = inputView.inputBonusNumber();
            int bonusNumber = convertToInt(bonusNumberValue);
            NumberValidator.validateInRangeNumber(bonusNumber);
            isDuplicateBonusNumber(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw NumberException.LIMIT_NUMBER_EXCEPTION.getException();
        }
    }

    private void isDuplicateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.isContainNumber(bonusNumber)) {
            throw WinningNumberException.DUPLICATE_EXCEPTION.getException();
        }
    }

    public void printCreatedLottos(Amount amount, Lottos lottos) {
        outputView.printLottoCount(amount.getLottoCount());
        outputView.printLottos(lottos);
    }

    public void printResult(Result result, Amount amount) {
        Map<Rank, Integer> noneRankRemovedResult = result.getResult();

        List<ResultResponse> resultResponses = noneRankRemovedResult.entrySet().stream()
            .map(entry -> new ResultResponse(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());

        outputView.printResultGuideMessage();
        outputView.printLottoResult(resultResponses);
        outputView.printBenefitRate(result.calculateBenefitRate(amount));
    }
}
