package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.utils.LottoConstants.LOTTO_SIZE;
import static lotto.utils.LottoConstants.NUMBER_MAX_SIZE;
import static lotto.utils.LottoConstants.NUMBER_MIN_SIZE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Payment;

public class LottoMachine {
    private final int lottoTicketNumber;
    private final Payment payment;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoMachine(Payment payment) {
        this.payment = payment;
        this.lottoTicketNumber = payment.payment() / payment.getLottoPrice();
    }

    public void generateLotto() {
        for (int i = 0; i < lottoTicketNumber; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottos.add(lotto);
        }
    }

    public static List<Integer> generateRandomNumbers() {
        return pickUniqueNumbersInRange(NUMBER_MIN_SIZE.getValue(), NUMBER_MAX_SIZE.getValue(), LOTTO_SIZE.getValue());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Payment getPayment() {
        return payment;
    }
}
