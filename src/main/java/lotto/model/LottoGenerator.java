package lotto.model;

import java.util.List;

public interface LottoGenerator {
    // 로또 1개를 만들어서 반환
    Lotto generate();

    // quantity 개수만큼 로또를 만들어 반환
    List<Lotto> generateLottoTickets(int quantity);
}
