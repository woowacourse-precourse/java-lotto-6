package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Validator.*;
import static lotto.constants.Numbers.*;
import static lotto.constants.Strings.*;
import static lotto.view.InputView.*;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers() {
        Lotto winningLotto = winningLottoFromInput();
        this.winningLotto = winningLotto;
        int bonusNumber = bonusNumberFromInput(this.winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private Lotto winningLottoFromInput() {
        while (true) {
            String input = WINNING_NUMBERS.scan();
            try {
                validateNumberCommaString(input);
                return new Lotto(inputToNumbers(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int bonusNumberFromInput(Lotto winningLotto) {
        while (true) {
            String input = BONUS_NUMBER.scan();
            try {
                validateNumberString(input);
                int bonusNumber = Integer.parseInt(input);
                validateRange(bonusNumber, MIN_NUMBER, MAX_NUMBER);
                validateDuplicates(winningLotto, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String splitInput : input.split(COMMA)) {
            numbers.add(Integer.parseInt(splitInput));
        }
        Collections.sort(numbers);
        return numbers;
    }
}
