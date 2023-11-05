package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int TICKET_PRICE = 1000;

    public List<Lotto> createLottoList(int price) {
        validate(price);
        List<Lotto> lottos = new ArrayList<>();
        return lottos;
    }

    private void validate(int price) {
        if (price % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
