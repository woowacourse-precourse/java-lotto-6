package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private final LottoInput lottoInput;

    public LottoNumberGenerator(LottoInput lottoInput) {
        this.lottoInput = lottoInput;
    }

    public List<Lotto> generateLottoTickets() {
        int amount = lottoInput.inputAmount();
        int ticketCount = lottoInput.checkPurchaseAmount(amount);
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(generateValidLottoTicket());
        }

        return lottoTickets;
    }

    private Lotto generateValidLottoTicket() {
        while (true) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            try {
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
}
