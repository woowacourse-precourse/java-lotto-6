package lotto.domain.generator;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.repository.UserLottoRepository;

public class LottoGenerator {
    private final UserLottoRepository userLottoRepository;
    public LottoGenerator() {
        userLottoRepository = new UserLottoRepository();
    }

    public List<Lotto> createLottoList(LottoMoney lottoMoney){
        int lottoCount = lottoMoney.getLottoCount();
        List<Lotto> userLotto = IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .toList();
        return userLottoRepository.save(userLotto);
    }

    private Lotto createLotto() {
        return new Lotto(RandomLottoNumbers.getValue());
    }

}
