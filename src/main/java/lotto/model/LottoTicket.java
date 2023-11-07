package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoTicket {
    private final List<Lotto> lottoPlays = new ArrayList<>();

    public LottoTicket(long playCount) {
        Stream.generate(this::randomize)
                .limit(playCount)
                .map(Lotto::new)
                .forEach(lottoPlays::add);
    }

    public int getPlayCount() {
        return lottoPlays.size();
    }

    private List<Integer> randomize() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}