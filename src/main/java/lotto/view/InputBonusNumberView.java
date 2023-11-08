package lotto.view;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.Number.*;
import static lotto.constant.message.ErrorMessage.*;
import static lotto.constant.message.InputMessage.*;

public class InputBonusNumberView {

    private int bonusNumber;

    public int inputBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                System.out.println(WINNING_BONUS_NUMBER_MESSAGE);
                bonusNumber = Integer.parseInt(readLine());
                illegalArgument(winningNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println(IS_NOT_BONUS_INPUT_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private void illegalArgument(Lotto winningNumber) {
        List<Integer> tempWinningNumber = winningNumber.getLottoNumber();
        Set<Integer> tempLotto = new HashSet<>(tempWinningNumber);
        tempLotto.add(bonusNumber);
        if (tempWinningNumber.size() == tempLotto.size()) {
            throw new IllegalArgumentException(IS_NOT_DISTINCT);
        }
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(IS_NOT_IN_RANGE);
        }
    }
}
