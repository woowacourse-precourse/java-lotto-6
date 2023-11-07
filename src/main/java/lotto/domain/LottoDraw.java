package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;

public class LottoDraw {

    private final int lottoTicketsNumber;

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoDraw(int lottoTicketsNumber) {
        this.lottoTicketsNumber = lottoTicketsNumber;
    }

    public void configureLottoNumbers() {
        IntStream.range(0, lottoTicketsNumber)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .forEach(lottos::add);
    }
}
