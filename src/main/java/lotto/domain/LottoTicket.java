package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.NumbersGenerator;

public class LottoTicket {
    private LottoTicket() {
    }

    public static List<Lotto> generate(int count) {
        List<Lotto> lottoTicket = new ArrayList<>();
        while (count > 0) {
            lottoTicket.add(new Lotto(NumbersGenerator.generate()));
            count--;
        }
        return lottoTicket;
    }
}
