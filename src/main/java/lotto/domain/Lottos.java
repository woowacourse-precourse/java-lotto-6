package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.Constants.*;

public class Lottos {
    private static final String OUTPUT_PURCHASE_COUNT = "\n%d개를 구매했습니다.\n";

    private final int purchasePrice;
    private final List<Lotto> lottos;

    public Lottos(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.lottos = createLottos();
    }

    public List<Lotto> createLottos() {
        int issuesCount = purchasePrice / STANDARD_LOTTO_AMOUNT_UNIT;
        List<Lotto> makeLottos = new ArrayList<>();
        while (issuesCount-- > 0) {
            Lotto lotto = new Lotto(generateLotto());
            makeLottos.add(lotto);
        }
        return makeLottos;
    }

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE).
                stream().sorted().collect(Collectors.toList());
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return String.format(OUTPUT_PURCHASE_COUNT, purchasePrice / STANDARD_LOTTO_AMOUNT_UNIT) +
                lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
