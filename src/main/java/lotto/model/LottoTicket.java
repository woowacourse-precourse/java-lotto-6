package lotto.model;

import java.util.List;

public class LottoTicket extends Lotto {

    public static final int PRICE = 1000;

    public LottoTicket(List<Integer> numbers) {
        super(numbers);
    }
}