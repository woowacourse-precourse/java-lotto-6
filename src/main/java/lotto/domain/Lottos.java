package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.Constants.*;

public class Lottos {

    private int ticketCount;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int ticketCount) {
        this.ticketCount = ticketCount;
        addLotto();
    }

    public List<Lotto> addLotto() {
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(generateRandomLottoNumber());
        }

        return lottos;
    }

    private Lotto generateRandomLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LUCKY_NUMBER_COUNT);
        Collections.sort(lottoNumber);

        return new Lotto(lottoNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
