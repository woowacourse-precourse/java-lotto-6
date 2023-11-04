package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class Payment {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> lottoNumbers;

    public Payment(int payment) {
        validatePayment(payment);
        this.payment = payment;
        this.purchaseNumber = payment / 1000;
        this.lottoNumbers = generateLottoNumbers(purchaseNumber);

    }

    private void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages
                    .NOT_DIVISIBLE_BY_THOUSAND
                    .getMessage());
        }
    }

    private List<List<Integer>> generateLottoNumbers(int purchaseNumber) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i=0;i<purchaseNumber;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }
}
