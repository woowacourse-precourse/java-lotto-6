package lotto.domain;


import java.util.List;
import java.util.stream.IntStream;
import lotto.generator.LottoNumberGenerator;

public class LottoMachine {
    private final int LOTTO_PRICE = 1_000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> buyLottos(LottoAmount lottoAmount) {
        int amount = lottoAmount.amount();
        int quantity = calculateLottoQuantity(amount);

        return IntStream.range(0, quantity)
                .mapToObj(i -> buyLotto())
                .toList();
    }
    private int calculateLottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }

    private Lotto buyLotto() {
        return new Lotto(lottoNumberGenerator.generateLottoNumbers());
    }
}
