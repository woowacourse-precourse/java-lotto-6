package lotto.domain;

import lotto.domain.validation.LottoWinningNumberValidation;
import lotto.view.EnterLottoWinningNumberView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static lotto.constants.NumberOfLottoPurchaseConstants.COMMA;

public class EnterLottoWinningNumbersDomain {
    private final EnterLottoWinningNumberView enterLottoWinningNumberView;
    private final LottoWinningNumberValidation lottoWinningNumberValidation;

    public EnterLottoWinningNumbersDomain() {
        this.enterLottoWinningNumberView = new EnterLottoWinningNumberView();
        this.lottoWinningNumberValidation = new LottoWinningNumberValidation();
    }

    public List<Integer> userSetWinningNumberLogic() {
        String winningNumber = inputAndValidateLottoWinningNumbers();
        String additionNumber = inputAndValidateLottoAdditionNumbers();
        List<Integer> lottoWinningNumber = parseWinningNumbers(winningNumber, additionNumber);
        return List.copyOf(lottoWinningNumber);
    }

    private String inputAndValidateLottoWinningNumbers() {
        String winningNumber = enterLottoWinningNumberView.enterLottoWinningNumber();
        lottoWinningNumberValidation.winningNumberValidation(winningNumber);
        return winningNumber;
    }

    private String inputAndValidateLottoAdditionNumbers() {
        String additionNumber = enterLottoWinningNumberView.enterAdditionNumber();
        lottoWinningNumberValidation.additionLottoWinningNumberValidation(additionNumber);
        return additionNumber;
    }

    private List<Integer> parseWinningNumbers(String winningNumber, String additionNumber) {
        List<Integer> numbers = Arrays.stream(winningNumber.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbers.add(parseInt(additionNumber));
        return numbers;
    }
}
