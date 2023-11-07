package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    public static Lotto makeNewLotto() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    public static LottoTicket makeNewLottoTicket(Integer count) {

        List<Lotto> lottoData = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoData.add(makeNewLotto());
        }

        return new LottoTicket(lottoData);
    }
}
