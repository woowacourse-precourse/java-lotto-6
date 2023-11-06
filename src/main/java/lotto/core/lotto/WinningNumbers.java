package lotto.core.lotto;

import java.util.ArrayList;
import java.util.List;

public record WinningNumbers(LottoTicket lottoTicket) {

    public List<Integer> getNumbers() {
        List<Integer> numbers = lottoTicket.getNumbers();
        return new ArrayList<>(numbers);
    }
}
