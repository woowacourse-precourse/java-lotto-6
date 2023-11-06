package lotto;

import static lotto.LottoConfig.MAX_NUMBER;
import static lotto.LottoConfig.MIN_NUMBER;
import static lotto.LottoConfig.NUMBER_OF_NUMBERS;
import static lotto.LottoConfig.PRICE;
import static lotto.SystemMessage.OUTPUT_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final List<Lotto> lottos;
    private final int lottoAmount;

    public LottoGenerator(int purchaseAmount) {
        this.lottoAmount = getLottoAmount(purchaseAmount);
        this.lottos = makeLottos();
    }

    private int getLottoAmount(int purchaseAmount) {
        return purchaseAmount / PRICE.getNumber();
    }

    private List<Lotto> makeLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(makeRandomLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> makeRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(),
                MAX_NUMBER.getNumber(),
                NUMBER_OF_NUMBERS.getNumber());
    }

    public void printLottos() {
        System.out.printf(OUTPUT_PURCHASE_AMOUNT.getMessage(), lottoAmount);

        for (Lotto lotto : lottos) {
            lotto.printNaturalOrder();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
