package lotto.core.lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final LottoTicket lottoTicket;

    public WinningNumbers(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = lottoTicket.getNumbers();
        return new ArrayList<>(numbers);
    }
}
