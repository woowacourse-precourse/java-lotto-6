package lotto;


import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private final int LOTTO_PRICE = 1_000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    private int calculateLottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }

    public Lotto buyLotto() {
        return new Lotto(lottoNumberGenerator.generateLottoNumbers());
    }

    public List<Lotto> buyLottos(int amount) {
        int quantity = calculateLottoQuantity(amount);

        return IntStream.range(0, quantity)
                .mapToObj(i -> buyLotto())
                .toList();
    }
}
