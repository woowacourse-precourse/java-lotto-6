package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.code.ErrorMessage;
import lotto.code.PrizeCode;
import lotto.utils.PrintUtils;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.code.PrizeCode.*;

public class Lotto {
    private final List<Integer> numbers;
    private int prize;
    private int prizeMoney;

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validate(this.numbers);
        this.numbers.sort(Comparator.naturalOrder());
        print();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_ONLY_SIX.getMessage());
        }

        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION.getMessage());
        }

        long count = numbers.stream().filter(n -> n < 1 || n > 45).count();
        if (count > 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public void print() {
        PrintUtils.print(numbers.toString());
    }

    public void checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        int count = (int) this.numbers.stream().filter(winningNumbers::contains).count();
        switch (count) {
            case 6:
                setPrize(FIRST);
                break;
            case 5:
                if (numbers.contains(bonusNumber)) {
                    setPrize(SECOND);
                } else {
                    setPrize(THIRD);
                }
                break;
            case 4:
                setPrize(FOURTH);
                break;
            case 3:
                setPrize(FIFTH);
                break;
            default:
        }
    }

    private void setPrize(PrizeCode prizeCode) {
        this.prize = prizeCode.getPrize();
        this.prizeMoney = prizeCode.getPrizeMoney();
    }

    public int getPrize() {
        return prize;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
