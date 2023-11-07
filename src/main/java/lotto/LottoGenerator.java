package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final List<Lotto> lottos;

    public LottoGenerator(long buyingPrice) {
        long buyingCount = calculateBuyingCount(buyingPrice, LOTTO_PRICE);
        this.lottos = generateLottos(buyingCount);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private long calculateBuyingCount(long buyingPrice, long unitPrice) {
        validate(buyingPrice, unitPrice);
        return buyingPrice / unitPrice;
    }

    private void validate(long buyingPrice, long unitPrice) {
        validatePositive(unitPrice);
        validatePositive(buyingPrice);
        validateUnit(buyingPrice, unitPrice);
    }

    private List<Lotto> generateLottos(long buyingCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() != buyingCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_SIZE));
    }
}
