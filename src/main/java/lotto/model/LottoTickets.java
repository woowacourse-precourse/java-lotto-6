package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    List<Lotto> lottoTickets;

    public LottoTickets(int amount) {
        this.lottoTickets = new ArrayList<>();
        automaticLottoPurchase(amount);
    }

    public void addLotto(Lotto lotto) {
        this.lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    private void automaticLottoPurchase(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            addLotto(new Lotto(numbers));
        }
    }
}
