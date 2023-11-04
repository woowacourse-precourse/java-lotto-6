package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.utill.RandomLottoNumbers;

public class LottoGenerator {

    public static List<Lotto> createLottoList(LottoTicket lottoTicket){
        int lottoCount = lottoTicket.getLottoCount();
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .toList();
    }

    private static Lotto createLotto() {
        return new Lotto(RandomLottoNumbers.getValue());
    }

}
