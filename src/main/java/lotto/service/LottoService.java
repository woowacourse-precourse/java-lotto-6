package lotto.service;

import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.utils.RandomUtils;

import java.util.*;

public class LottoService {

    RandomUtils randomUtils = new RandomUtils();

    List<Lotto> userLottos = new ArrayList<>();

    public int getUserLottoSize() {
        return userLottos.size();
    }

    public void createUserLottos(int amount) {
        int lottoSize = amount / Value.LOTTO_TICKET_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoSize; i++) {
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
