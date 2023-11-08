package lotto.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.Number.*;
import static lotto.constant.message.ErrorMessage.*;
import static lotto.constant.message.InputMessage.*;

public class InputWinningNumberView {

    private List<Integer> lotto;

    public List<Integer> inputWinningNumber() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBER_MESSAGE);
                lotto = Stream.of(readLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                illegalArgument();
                break;
            } catch (NumberFormatException e) {
                System.out.println(IS_NOT_INPUT_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private void illegalArgument() {
        if (lotto.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(IS_NOT_LENGTH_SIX);
        }
        Set<Integer> tempLotto = new HashSet<>(lotto);
        if (lotto.size() != tempLotto.size()) {
            throw new IllegalArgumentException(IS_NOT_DISTINCT);
        }
        for (Integer i : lotto) {
            if (i < MIN_NUMBER || i > MAX_NUMBER) {
                throw new IllegalArgumentException(IS_NOT_IN_RANGE);
            }
        }
    }
}
