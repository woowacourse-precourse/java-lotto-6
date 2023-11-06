package lotto.repository;

import java.util.Objects;
import lotto.domain.AnswerLotto;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.PurchasedLottoBundle;

public class LottoRepository {
    private LottoStore lottoStore;
    private PurchasedLottoBundle purchasedLottoBundle;
    private Money payment;
    private AnswerLotto answerLotto;

    public void save(LottoStore lottoStore) {
        Objects.requireNonNull(lottoStore);
        this.lottoStore = lottoStore;
    }

    public void save(Money payment) {
        Objects.requireNonNull(payment);
        this.payment = payment;
    }

    public void save(PurchasedLottoBundle purchasedLottoBundle) {
        Objects.requireNonNull(purchasedLottoBundle);
        this.purchasedLottoBundle = purchasedLottoBundle;
    }

    public void save(final AnswerLotto answerLotto) {
        Objects.requireNonNull(answerLotto);
        this.answerLotto = answerLotto;
    }

    public LottoStore findLottoStore() {
        return this.lottoStore;
    }

    public PurchasedLottoBundle findPurchasedLottoBundle() {
        return this.purchasedLottoBundle;
    }

    public Money findPayment() {
        return this.payment;
    }

    public AnswerLotto findAnswerLotto() {
        return this.answerLotto;
    }
}
