package lotto.domain;

import static lotto.condition.LottoCondition.LOTTO_COUNT;
import static lotto.condition.LottoCondition.MAXIMUM_LOTTO_NUMBER;
import static lotto.condition.LottoCondition.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottoResponse;
import lotto.dto.LottoResponses;

public class UserLotto {
    private final List<Lotto> allLotto;

    private UserLotto(final int input) {
        this.allLotto = createUserLotto(input);
    }

    public static UserLotto create(final int input) {
        return new UserLotto(input);
    }

    private List<Lotto> createUserLotto(final int input) {
        return IntStream.range(0, input)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER.getValue(),
                        MAXIMUM_LOTTO_NUMBER.getValue(), LOTTO_COUNT.getValue())))
                .toList();
    }

    public LottoResponses buildLottoResponses() {
        List<LottoResponse> lottoResponses = allLotto.stream()
                .map(Lotto::generateLottoResponse)
                .toList();
        return new LottoResponses(lottoResponses);
    }
}
