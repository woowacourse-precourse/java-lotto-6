package lotto.service;

import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.utils.ParseUtils;
import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    ParseUtils parseUtils = new ParseUtils();
    RandomUtils randomUtils = new RandomUtils();

    ValidationService validationService = new ValidationService();

    List<Lotto> userLottos = new ArrayList<>();

    Lotto winningLotto;

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public int getUserLottoCount() {
        return userLottos.size();
    }

    public void createUserLottos(int lottoCount) {
        this.userLottos = IntStream.range(0, lottoCount / Value.LOTTO_TICKET_PRICE)
                .mapToObj(i -> createSingleLotto())
                .collect(Collectors.toList());
    }

    private Lotto createSingleLotto() {
        return new Lotto(randomUtils.sixUniqueRandomNumber());
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }
}
