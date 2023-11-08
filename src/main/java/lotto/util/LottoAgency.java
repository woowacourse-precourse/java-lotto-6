package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;

public class LottoAgency {

    private static final RandomUtils randomUtils = new GenerateRandomLottoNumbers();

    public static LottoTicket createAutoTicket(int quantity){
        return new LottoTicket(
                IntStream.range(0, quantity)
                        .mapToObj(i -> new LottoNumbers(randomUtils))
                        .collect(Collectors.toList())
        );
    }
}
