package lotto.domain;

import lotto.constant.Value;
import lotto.constant.WinStrategy;
import lotto.dto.MatchCountDto;
import lotto.dto.WinCountDto;
import lotto.util.Validator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LottoResult {
    private final List<Integer> answerNumbers;
    private int bonusNumber;
    private final int EXIST = 1;
    private final int NOT_EXIST = 0;

    private LottoResult(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static LottoResult from(List<Integer> answerNumbers) {
        Collections.sort(answerNumbers);
        return new LottoResult(answerNumbers);
    }

    public void setBonusNumber(int bonusNumber) throws IllegalArgumentException {
        Validator.checkDuplicated(answerNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerNumbers() {
        return Collections.unmodifiableList(answerNumbers);
    }

    public String getWinStatistics(List<Lotto> lottos) {
        WinCountDto winCounts = new WinCountDto();
        for (MatchCountDto counting : getMatchCounts(lottos)) {
            try {
                String winType = WinStrategy.getWinType(counting.getMatch(), counting.getBonus());
                int count = winCounts.getCount(winType) + Value.ONE.get();
                winCounts.put(winType, count);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        return winCounts.toString();
    }

    private List<MatchCountDto> getMatchCounts(List<Lotto> lottos) {
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