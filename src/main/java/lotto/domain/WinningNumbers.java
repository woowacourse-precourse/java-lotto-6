package lotto.domain;

import lotto.util.Util;
import lotto.validation.InputValidator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private List<Integer> winning = new ArrayList<>();

    public List<Integer> createWinningNumber() {
        String winningNumber = InputView.WinningNumber();
        String[] parseNumbers = Util.parse(winningNumber);
        InputValidator.isNumeric(parseNumbers);
        List<Integer> winningNumbers = Util.stringToInt(parseNumbers);
        if (InputValidator.isInRange(winningNumbers)) {
            winning.addAll(winningNumbers);
        }
        return winning;
    }

    public List<Integer> createBonusNumber() {
        String bonusNumber = InputView.BonusNumber();
        InputValidator.isNumeric(bonusNumber);
        List<Integer> bonusNumbers = new ArrayList<>();
        bonusNumbers.add(Integer.parseInt(bonusNumber));
        if (InputValidator.isInRange(bonusNumbers)) {
            winning.addAll(bonusNumbers);
        }
        return winning;
    }
}
