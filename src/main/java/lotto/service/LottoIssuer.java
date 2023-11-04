package lotto.service;

import lotto.model.Lotto;
import lotto.model.PurchaseAmount;

import java.util.List;
import java.util.stream.IntStream;

//TODO: Generate와 차이점이 무엇일지 고민해보기
//TODO: Lotto 이 일급 컬렉션을 제대로 활용하지 못하고 있다. 적극 활용
public class LottoIssuer {

    private final Integer lottoTicket;
    private final NumberGenerator<List<Integer>> generator;

    private LottoIssuer(Integer lottoTicket, NumberGenerator<List<Integer>> generator) {
        this.lottoTicket = lottoTicket;
        this.generator = generator;
    }

    public static LottoIssuer of(PurchaseAmount purchaseAmount) {
        return new LottoIssuer(purchaseAmount.exchangeLottoTicket(), new LottoGenerator());
    }

    public List<Lotto> issueLotto() {
        return IntStream.range(0, lottoTicket)
                .mapToObj(i -> new Lotto(generator.generate()))
                .toList();
    }
}
