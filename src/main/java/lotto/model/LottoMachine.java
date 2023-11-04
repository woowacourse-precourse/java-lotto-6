package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import static lotto.util.LottoInformation.*;

public class LottoMachine {
    private final int numberOfTickets;
    private final Lottos lottos;

    public LottoMachine(int payment) {
        this.numberOfTickets = calculateNumberOfTickets(payment);
        this.lottos = createLottos(numberOfTickets);
    }

    private int calculateNumberOfTickets(int payment) {
        return payment / LOTTO_PRICE;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    private Lotto createLotto() {
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() < NUMBER_OF_NUMBERS) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!lotto.contains(number)) {
                lotto.add(number);
            }
        }
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
