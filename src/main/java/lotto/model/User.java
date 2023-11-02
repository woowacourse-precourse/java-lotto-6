package lotto.model;

import java.util.List;
import lotto.utils.LottoNumberGenerator;

public class User {
    private List<Lotto> lottoTickets;
    private final int count;

    public User(int count) {
        this.count = count;
        generateTickets();
    }

    private void generateTickets() {
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new Lotto(LottoNumberGenerator.generate()));
        }
    }
}
