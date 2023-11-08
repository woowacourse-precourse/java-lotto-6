package lotto.model;

import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static lotto.constant.LottoConstant.*;

public class LottoWinning {
    private List<Integer> winningNumber;
    private int bonusNumber;

    public LottoWinning(String _winningNumber) {
        winningNumber = new ArrayList<Integer>();
        for (String number : _winningNumber.split(",")) {
            validationWinningNumber(number);
            winningNumber.add(parseInt(number));
        }
        validateDuplicateValue(winningNumber);
    }

    private void validationWinningNumber(String _winningNumber) {
        validateIsNotNumber(_winningNumber);
        validateRangeNumber(parseInt(_winningNumber), RANGE_START.getNumber(), RANGE_END.getNumber());
    }

    public static void validateDuplicateValue(List<Integer> _lotto) {
        _lotto = _lotto.stream().distinct().collect(Collectors.toList());
        if (_lotto.size() != LOTTO_SIZE.getNumber()) {
            OutputView.printError(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateDuplicateNumber(List<Integer> _wining, int _bonus) {
        if (_wining.contains(_bonus)) {
            OutputView.printError(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateRangeNumber(int target, int start, int end) {
        if (!(target >= start && target <= end)) {
            OutputView.printError(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateIsNotNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException error) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    public void setBonusNumber(String number) {
        validateBonusNumber(number);
        bonusNumber = parseInt(number);
    }

    private void validateBonusNumber(String number) {
        validateIsNotNumber(number);
        validateRangeNumber(parseInt(number), RANGE_START.getNumber(), RANGE_END.getNumber());
        validateDuplicateNumber(this.winningNumber, parseInt(number));
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
