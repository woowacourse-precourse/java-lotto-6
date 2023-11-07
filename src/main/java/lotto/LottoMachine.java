package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
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
        Random random = new Random();
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < NUMBER_OF_LOTTO_NUMBERS) {
            int randomNumber = random.nextInt(MAX_LOTTO_NUMBER) + 1;
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }

        return new Lotto(lottoNumbers);
    }
}
