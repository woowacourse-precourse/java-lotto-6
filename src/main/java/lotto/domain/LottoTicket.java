package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoTicket {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int ZERO = 0;
    private final List<Lotto> lottoTicket;

    public LottoTicket(long numberOfPurchase) {
        List<Lotto> lottoTicket = IntStream.range(ZERO, (int) numberOfPurchase)
                .mapToObj(i -> new Lotto(pickLottoNumber()))
                .toList();

        this.lottoTicket = List.copyOf(lottoTicket);
    }

    private List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE)
                .stream()
                .sorted()
                .collect(toList());
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }
}