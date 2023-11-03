package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.LottosRepository;
import lotto.domain.money.LottoMoney;
import lotto.dto.BuyingResults;

public class LottoMachine {

    private final LottosRepository lottosRepository;

    public LottoMachine(final LottosRepository lottosRepository) {
        this.lottosRepository = lottosRepository;
    }

    public void buyLottos(final Supplier<List<Integer>> randomLottoSupplier, final int price) {
        LottoMoney lottoMoney = LottoMoney.from(price);
        List<Lotto> lottos = Stream.generate(randomLottoSupplier)
                .limit(lottoMoney.createBuyingCount())
                .map(Lotto::from)
                .toList();
        Lottos userLotto = new Lottos(lottos);
        lottosRepository.saveUserLottos(userLotto);
    }

    public BuyingResults createBuyingResults() {
        Lottos userLottos = lottosRepository.findUserLottos()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 로또 번호가 존재하지 않습니다."));
        return BuyingResults.createFrom(userLottos);
    }

    public void addLottoNumbers(final List<Integer> numbers) {
        Lotto winningNumber = Lotto.from(numbers);
        lottosRepository.saveWinningNumber(winningNumber);
    }
}
