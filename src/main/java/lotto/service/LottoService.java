package lotto.service;

import lotto.constants.Value;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.Lotto;
import lotto.utils.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    RandomUtils randomUtils = new RandomUtils();

    List<Lotto> userLottos = new ArrayList<>();

    public int getUserLottoCount() {
        return userLottos.size();
    }

    public void createUserLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount/Value.LOTTO_TICKET_PRICE; i++) {
            lottos.add(createSingleLotto());
        }

        this.userLottos =  lottos;
    }

    private Lotto createSingleLotto() {
        List<Integer> numbers = new ArrayList<>(randomUtils.sixUniqueRandomNumber());
        return new Lotto(numbers);
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

}
