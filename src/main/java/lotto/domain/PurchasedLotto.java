package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private static final String DUPLICATE_LOTTO_MESSAGE = "[ERROR] 똑같은 로또가 존재합니다";
    private final List<Lotto> purchasedLotto;

    public PurchasedLotto(int numberOfPurchase) {
        this.purchasedLotto = generateLottoNumbers(numberOfPurchase);
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLotto;
    }

    private List<Lotto> generateLottoNumbers(int number) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            lottos.add(generateValidatedLotto());
        }
        validDuplicate(lottos,number);
        return lottos;
    }

    private void validDuplicate(List<Lotto> lottos,int number) {
        Boolean distinct = lottos.stream().distinct().count() != lottos.size();
        if (distinct) {
            generateLottoNumbers(number);
        }
    }

    private Lotto generateValidatedLotto() {
        return new Lotto(new LottoMachine().getNumbers());
    }
}
