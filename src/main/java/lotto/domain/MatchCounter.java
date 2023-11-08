package lotto.domain;

import lotto.dto.MatchCountDto;
import lotto.util.Validator;
import java.util.List;
import java.util.ArrayList;

public class MatchCounter {
    private final List<Integer> answerNumbers;
    private int bonusNumber;
    private final int EXIST = 1;
    private final int NOT_EXIST = 0;

    private MatchCounter(List<Integer> answerNumbers) {
        this.answerNumbers = new ArrayList<>(answerNumbers);
    }

    public static MatchCounter from(List<Integer> answerNumbers) {
        return new MatchCounter(answerNumbers);
    }

    public void setBonusNumber(int bonusNumber) throws IllegalArgumentException {
        Validator.checkDuplicated(answerNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<MatchCountDto> getMatchCounts(LottoPaper lottos) {
        List<MatchCountDto> counting = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = countNumberMatch(lotto.getNumbers());
            int bonusCount = countBonusMatch(lotto.getNumbers());
            counting.add(new MatchCountDto(matchCount, bonusCount));
        }
        return counting;
    }

    int countNumberMatch(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(answerNumbers::contains)
                .count();
    }

    int countBonusMatch(List<Integer> list) {
        if (list.contains(bonusNumber)) {
            return EXIST;
        }
        return NOT_EXIST;
    }
}