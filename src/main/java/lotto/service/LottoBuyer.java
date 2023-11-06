package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.RandomNumbers;

public class LottoBuyer {
    private int lottoTicketNumber;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    public LottoBuyer(int lottoTicketNumber) {
        this.lottoTicketNumber = lottoTicketNumber;
    }

    public LottoBuyer(Payment payment) {
        this.lottoTicketNumber = payment.getPayment() / payment.getLottoPrice();
    }

    public void generateLotto() {
        for (int i = 0; i < lottoTicketNumber; i++) {
            Lotto lotto = new Lotto(RandomNumbers.generateRandomNumbers());
            lottos.add(lotto);
        }
    }

    public void setInputs(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
