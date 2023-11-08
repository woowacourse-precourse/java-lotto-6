package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.PaymentValidator;

public class Lottos {
    private List<Lotto> lottos;
    private int payment;

    public Lottos(int payment) {
        PaymentValidator.validateNaturalNumber(payment);
        PaymentValidator.validateUnit(payment);
        this.payment = payment;
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
