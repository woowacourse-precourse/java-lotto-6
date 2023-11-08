package lotto.domain.lotto;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.order.PurchaseOrder;
import lotto.utils.generator.NumberGenerator;
import lotto.utils.generator.RandomNumberGenerator;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine() {
        this(new RandomNumberGenerator());
    }

    public LottoMachine(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> purchase(final PurchaseOrder purchaseOrder) {
        return IntStream.range(0, purchaseOrder.getQuantity())
                .mapToObj(i -> createLotto())
                .toList();
    }

    private Lotto createLotto() {
        return new Lotto(numberGenerator.generate());
    }
}
