package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.PaymentValidator;

public class Lottos {
    private List<Lotto> lottos;
    private int payment;
    private int lottoCount;

    public Lottos(int payment) {
        PaymentValidator.validateNaturalNumber(payment);
        PaymentValidator.validateUnit(payment);
        this.payment = payment;
        lottos = new ArrayList<>();
        lottoCount = 0;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
        lottoCount++;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPayment() {
        return payment;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
