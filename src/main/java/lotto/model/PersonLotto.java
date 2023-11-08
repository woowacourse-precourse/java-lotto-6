package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.NumbersGenerator;
import lotto.util.SpecialSign;

public class PersonLotto {

    private static final int MIN_LOTTO_SIZE = 0;

    private List<Lotto> purchaseLotto;

    public PersonLotto(NumbersGenerator numbersGenerator, PurchaseMoney purchaseMoney) {
        this.purchaseLotto = createLotto(numbersGenerator, purchaseMoney);
    }

    public List<Lotto> getPurchaseLotto() {
        return purchaseLotto.stream().toList();
    }

    private List<Lotto> createLotto(NumbersGenerator numbersGenerator, PurchaseMoney purchaseMoney) {
        return IntStream.range(MIN_LOTTO_SIZE, purchaseMoney.getPurchaseAmount())
                .mapToObj(amount -> new Lotto(numbersGenerator.generate()))
                .toList();
    }
}
