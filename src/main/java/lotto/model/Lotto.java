package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int NOT_CONTAINS_BONUS_NUMBER = 0;

    private static final String FIRST = "FIRST";
    private static final String SECOND = "SECOND";
    private static final String THIRD = "THIRD";
    private static final String FOURTH = "FOURTH";
    private static final String FIFTH = "FIFTH";
    private static final String NO_RANK = "NO";
    private static final int FIFTH_EQUAL_NUMBER = 3;
    private static final int FOURTH_EQUAL_NUMBER = 4;
    private static final int THIRD_EQUAL_NUMBER = 5;
    private static final int NUMBERS_ALL_EQUAL = 6;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        if (numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public LottoRank getMyRank(WinningLotto winningLotto){
        int numbersEqualCount = numbersEqualCount(winningLotto);

        LottoRank rank = LottoRank.valueOf(rankFind(winningLotto, numbersEqualCount));

        return rank;

    }

    private String rankFind(WinningLotto winningLotto, int numbersEqualCount) {
        if(numbersEqualCount == FIFTH_EQUAL_NUMBER){
            return FIFTH;
        }
        if(numbersEqualCount == FOURTH_EQUAL_NUMBER){
            return FOURTH;
        }
        if(numbersEqualCount == THIRD_EQUAL_NUMBER){
            return THIRD;
        }
        if(numbersEqualCount == NUMBERS_ALL_EQUAL){
            if(isBonusWin(winningLotto)){
                return SECOND;
            }
            return FIRST;
        }
        return NO_RANK;
    }

    private int numbersEqualCount(WinningLotto winningLotto) {
        return (int) numbers.stream()
               .filter(winningLotto::contains)
               .count();
    }

    private boolean isBonusWin(WinningLotto winningLotto){
        return !(numbers.stream()
                .filter(winningLotto::isBonusNumber)
                .findFirst()
                .orElse(NOT_CONTAINS_BONUS_NUMBER) == NOT_CONTAINS_BONUS_NUMBER);
    }
}
