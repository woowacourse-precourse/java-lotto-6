package lotto.domain;

import lotto.validation.ErrorMessage;
import lotto.view.OutputView;

import java.util.ArrayList;

public class WinningNum {
    private final Integer LENGTH = 6;
    private final ArrayList<Integer> winningNum;

    public WinningNum(ArrayList<Integer> winningNum) {
        lengthValidate(winningNum);
        duplicatedValidate(winningNum);

        this.winningNum = winningNum;
    }

    private void lengthValidate(ArrayList<Integer> winningNum) {
        if (winningNum.size() != LENGTH) {
            OutputView.errorMessage(ErrorMessage.LENGTH_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private void duplicatedValidate(ArrayList<Integer> winningNum) {
        long count = winningNum.stream()
                .distinct()
                .count();

        if (count != LENGTH) {
            OutputView.errorMessage(ErrorMessage.DUPLICATED_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }
}
