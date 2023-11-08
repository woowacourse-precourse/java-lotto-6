package lotto.domain;

import lotto.dto.MatchCountDto;
import lotto.util.Validator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MatchCounter {
    private final List<Integer> answerNumbers;
    private int bonusNumber;
    private final int EXIST = 1;
    private final int NOT_EXIST = 0;

    private MatchCounter(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static MatchCounter from(List<Integer> answerNumbers) {
        Collections.sort(answerNumbers);
        return new MatchCounter(answerNumbers);
    }

    public void setBonusNumber(int bonusNumber) throws IllegalArgumentException {
        Validator.checkDuplicated(answerNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<MatchCountDto> getMatchCounts(List<Lotto> lottos) {
        List<MatchCountDto> counting = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = countNumberMatch(lotto.getNumbers());
            int bonusCount = countBonusMatch(lotto.getNumbers());
            counting.add(new MatchCountDto(matchCount, bonusCount));
        }
        return counting;
    }

    private int countNumberMatch(List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (answerNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int countBonusMatch(List<Integer> list) {
        if (list.contains(bonusNumber)) {
            return EXIST;
        }
        return NOT_EXIST;
    }
}