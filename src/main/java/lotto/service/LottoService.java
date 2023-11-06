package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Constants;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    public ArrayList<Lotto> getLottos(Integer price) {
        int lottoCount = price / Constants.PRICE_UNIT;
        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(issueLotto());
        }

        return lottos;
    }

    private Lotto issueLotto() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < Constants.LOTTO_LENGTH) {
            numbers.add(Randoms.pickNumberInRange(Constants.MIN_LOTTO_NUM, Constants.MAX_LOTTO_NUM));
        }

        return new Lotto(List.copyOf(numbers));
    }
}
