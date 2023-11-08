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

    /**
     * 순서상 문제가 발생하는 경우
     *
     * @param object
     * @param <T>
     */
    private static <T> void requireNonNull(T object) {
        if (Objects.isNull(object)) {
            throw new IllegalStateException("해당 값이 존재하지 않습니다.");
        }
    }

    public void save(LottoStore lottoStore) {
        requireNonNull(lottoStore);
        this.lottoStore = lottoStore;
    }

    public void save(Money payment) {
        requireNonNull(payment);
        this.payment = payment;
    }

    public void save(PurchasedLottoBundle purchasedLottoBundle) {
        requireNonNull(purchasedLottoBundle);
        this.purchasedLottoBundle = purchasedLottoBundle;
    }

    public void save(final AnswerLotto answerLotto) {
        requireNonNull(answerLotto);
        this.answerLotto = answerLotto;
    }

    public LottoStore findLottoStore() {
        requireNonNull(this.lottoStore);
        return this.lottoStore;
    }

    public PurchasedLottoBundle findPurchasedLottoBundle() {
        requireNonNull(this.purchasedLottoBundle);
        return this.purchasedLottoBundle;
    }

    public Money findPayment() {
        requireNonNull(this.payment);
        return this.payment;
    }

    public AnswerLotto findAnswerLotto() {
        requireNonNull(this.answerLotto);
        return this.answerLotto;
    }

}
