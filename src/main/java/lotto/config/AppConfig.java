package lotto.config;

import lotto.service.Judgement;
import lotto.service.Payment;
import lotto.service.Publish;
import lotto.service.impl.AutoRandomNumberPublishImpl;
import lotto.service.impl.JudgementImpl;
import lotto.service.impl.PaymentImpl;

public class AppConfig {
    public Judgement judgement() {
        return new JudgementImpl();
    }

    public Payment payment() {
        return new PaymentImpl();
    }

    public Publish publish() {
        return new AutoRandomNumberPublishImpl();
    }
}
