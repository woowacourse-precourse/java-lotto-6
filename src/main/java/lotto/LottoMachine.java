package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public List<Lotto> purchaseLottos(int money) {
        int numberOfLottos = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(generateRandomLotto());
        }

        return lottos;
    }

    private Lotto generateRandomLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS));
        return new Lotto(lottoNumbers);
    }
}
