package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoAutoIssuePolicy implements LottoIssuePolicy {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBER_SIZE = 6;

    @Override
    public List<Integer> issue() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
    }
}
