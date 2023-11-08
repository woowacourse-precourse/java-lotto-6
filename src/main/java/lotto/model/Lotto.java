package lotto.model;

import static lotto.util.Message.ErrorMessage.DUPLICATION_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.util.Constant;
import lotto.util.Message.LottoMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> nonDuplicationLotto = Set.copyOf(numbers);
        if (nonDuplicationLotto.size() != Constant.LOTTO_LENGTH) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }

    public String winningStatus(ArrayList<Integer> winningNumber, int bonusNumber) {
        int count = 0;
        boolean bonus = false;
        for (int number : numbers) {
            if (winningNumber.contains(number)) {
                count++;
                continue;
            }
            if (number == bonusNumber) {
                bonus = true;
            }
        }
        return getRank(count, bonus);
    }

    private String getRank(int count, boolean bonus) { //TODO: refactor
        if (count == LottoMessage.FIRST.getCount()) {
            return LottoMessage.FIRST.getRank();
        }
        if (count == LottoMessage.SECOND.getCount()) {
            return checkSecondThirdByBonusNumber(bonus);
        }
        if (count == LottoMessage.FOURTH.getCount()) {
            return LottoMessage.FOURTH.getRank();
        }
        if (count == LottoMessage.FIFTH.getCount()) {
            return LottoMessage.FOURTH.getRank();
        }
        return "";
    }

    public String getLottoValue() {
        return numbers.toString();
    }

    public String checkSecondThirdByBonusNumber(boolean bonus) {
        if (bonus) {
            return LottoMessage.SECOND.getRank();
        }
        return LottoMessage.THIRD.getRank();
    }

}
