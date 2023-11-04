package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket() {
        lottos = new ArrayList<>();
    }

    public void addLotto(List<Integer> numbers) {
        lottos.add(new Lotto(numbers));
    }

}
