package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.util.LottoInformation.*;

public class LottoMachine {
    private final int numberOfLottoTickets;
    private final Lottos lottos;

    public LottoMachine(int payment) {
        this.numberOfLottoTickets = calculateNumberOfLottoTickets(payment);
        this.lottos = createLottos(numberOfLottoTickets);
    }

    private int calculateNumberOfLottoTickets(int payment) {
        return payment / LOTTO_PRICE;
    }

    public int getNumberOfLottoTickets() {
        return numberOfLottoTickets;
    }

    private Lottos createLottos(int numberOfLottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < numberOfLottoTickets) {
            lottos.add(createLotto());
        }
        return new Lottos(lottos);
    }

    private Lotto createLotto() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_OF_NUMBERS));
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
