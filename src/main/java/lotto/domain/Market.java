package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public Market() {}

    public List<Lotto> issueLotto(int payment) {
        int numberOfLotto = calculateNumberOfLotto(payment);
        showResultHowManyBought(numberOfLotto);

        List<Lotto> lottos = makeAutoLotto(numberOfLotto);
        showLottoNumbers(lottos);
        return lottos;
    }

    private int calculateNumberOfLotto(int payment) {
        validate(payment);
        return payment / Lotto.PRICE;
    }

    private void validate(int payment) {
        validateAmountOfPayment(payment);
        validateUnitOfPayment(payment);
    }

    private void validateAmountOfPayment(int payment) {
        if (payment < Lotto.PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private void validateUnitOfPayment(int payment) {
        if (payment % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }

    private List<Lotto> makeAutoLotto(int numberOfLotto) {
        List<Lotto> totalLotto = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            totalLotto.add(new Lotto(randomNumbers));
        }
        return totalLotto;
    }

    private void showResultHowManyBought(int numberOfLotto) {
        System.out.println();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    private void showLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}