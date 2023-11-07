package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    LottoInput lottoInput = new LottoInput();
    private void generateLottoTickets() {
        int amount = lottoInput.inputAmount();
        int tiketCount = lottoInput.checkPurchaseAmount(amount);
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for (int i=0; i < tiketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoTickets.add(numbers);
        }

        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }
}
