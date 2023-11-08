package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.enums.LottoConstraint;

public class LottoMachine {
    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstraint.START_RANGE_NUMBER.getValue(), LottoConstraint.END_RANGE_NUMBER.getValue(), LottoConstraint.VALID_LOTTO_SIZE.getValue());
    }

    public static List<Lotto> generateLottos(int lottoTicketCount) {
        return IntStream.range(0, lottoTicketCount)
                .mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
    }
}