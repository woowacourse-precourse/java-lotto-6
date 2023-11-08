package lotto.domain;

import java.util.List;

public interface LottoGame {

    PurchasedLottoTickets purchaseLottoTickets(String cost);

    Lotto createWinningLotto(List<Integer> numbers);

    PurchasedLottoStatistics createStatistics(
            PurchasedLottoTickets purchasedLottoTickets,
            Lotto winningLotto,
            int bonusNumber
    );
}
