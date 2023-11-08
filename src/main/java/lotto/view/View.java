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
import lotto.utils.Rank;
import lotto.validation.NumberValidator;
import lotto.validation.WinningNumberValidator;

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
            return new Amount(Integer.parseInt(amountValue));
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
        return Arrays.stream(winningNumbers.split(",", -1))
            .map(Integer::parseInt)
            .peek(NumberValidator::validateInRangeNumber)
            .toList();
    }

    private int getBonusNumber(Lotto winningNumbers) {
        try {
            outputView.printBonusNumberGuideMessage();
            String bonusNumberValue = inputView.inputBonusNumber();
            int bonusNumber = convertToInt(bonusNumberValue);
            isDuplicateBonusNumber(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private static int convertToInt(String bonusNumberValue) {
        int convertedBonusNumber = Integer.parseInt(bonusNumberValue);
        NumberValidator.validateInRangeNumber(convertedBonusNumber);
        return convertedBonusNumber;
    }

    private void isDuplicateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.isAlreadyExistNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호에 중복된 수가 존재할 수 없습니다.");
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
