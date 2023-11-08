package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.InputValidator;

public class WinningLotto {
    private final List<Integer> winningLottoNumbers;

    public WinningLotto(String inputWinningLotto) {
        List<Integer> winningLottoNumbers = splitWinningLottoNumber(inputWinningLotto);
        validateWinningLottoNumbers(winningLottoNumbers);
        this.winningLottoNumbers = winningLottoNumbers;
    }

    private void validateWinningLottoNumbers(List<Integer> winningLotto) {
        InputValidator.validateAmountOfWinningLottoNumber(winningLotto);
        InputValidator.validateDuplicatedWinningLottoNumber(winningLotto);
    }

    private List<Integer> splitWinningLottoNumber(String inputWinningLottoNumbers) {
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String inputWinningLottoNumber : inputWinningLottoNumbers.split(",")) {
            validateWinningLottoNumber(inputWinningLottoNumber);
            winningLottoNumbers.add(Integer.parseInt(inputWinningLottoNumber));
        }
        return winningLottoNumbers;
    }

    private void validateWinningLottoNumber(String winningLottoNumber) {
        InputValidator.validateInputIsNumber(winningLottoNumber);
        InputValidator.validateLottoNumberIsNotInRightRange(winningLottoNumber);
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
