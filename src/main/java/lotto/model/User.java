package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumbersGenerator;

public class User {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final int count;

    public User(int count) {
        this.count = count;
        generateTickets();
    }

    private void generateTickets() {
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new Lotto(LottoNumbersGenerator.generate()));
        }
    }

    public List<Integer> getTicket(int index) {
        Lotto lotto = lottoTickets.get(index);
        return lotto.getNumbers();
    }
}
