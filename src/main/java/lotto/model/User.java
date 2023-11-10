package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Util.Size;
import lotto.Util.LottoValue;
import lotto.controller.Validation;
import lotto.controller.Setting;

public class User {
    private final int payment;
    private final int numberOfPurchase;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> rankCount;

    public User(int payment) {
        validate(payment);
        this.payment = payment;
        this.numberOfPurchase = payment / Size.PAYMENT_UNIT.getSize();
        this.purchasedLottoNumbers = Setting.generateLottoNumbers(numberOfPurchase);
        this.rankCount = Setting.initRankCount();
    }

    private void validate(int payment) {
        Validation.validatePaymentDivisibility(payment);
    }

    public void increaseRankCount(int rank) {
        for (LottoValue lottoValue : LottoValue.values()) {
            if (rank == lottoValue.getRank()) {
                int currentCount = this.rankCount.get(lottoValue.getRank());
                this.rankCount.set(lottoValue.getRank(), currentCount + 1);
                return;
            }
        }
    }

    public double payment() {
        return this.payment;
    }

    public int numberOfPurchase() {
        return this.numberOfPurchase;
    }

    public List<List<Integer>> purchasedLottoNumbers() {
        return this.purchasedLottoNumbers;
    }

    public List<Integer> rankCount() {
        return this.rankCount;
    }
}
