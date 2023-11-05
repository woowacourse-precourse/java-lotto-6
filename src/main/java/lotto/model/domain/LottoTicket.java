package lotto.model.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.domain.exception.LottoGameConstants;

public class LottoTicket {
    private final List<Lotto> lottos;
    private final int pricePerLotto = LottoGameConstants.PRICE_PER_LOTTO.getValue();

    public LottoTicket(int price) {
        this.lottos = buyLottoTicket(price);
    }

    private List<Lotto> buyLottoTicket(int price) {
        validate(price);
        final int count = price / pricePerLotto;
        return createLottoTicket(count);
    }

    private List<Lotto> createLottoTicket(int count) {
        return IntStream.range(0, count)
                .mapToObj(lotto -> new Lotto(generateLottoNumbers()))
                .toList();
    }

    private List<Integer> generateLottoNumbers() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generateLottoNumbers();
    }

    private void validate(int price) {
        if (price % pricePerLotto != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000단위여야 합니다.");
        }
    }

    public List<Lotto> getLottoTicket() {
        return this.lottos;
    }

}
