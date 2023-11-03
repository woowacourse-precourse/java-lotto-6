package controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Lotto;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_PER_TICKET = 6;

    public int calculatelottoMount(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public List<Lotto> generateLottos(int lottoMount) {

        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < lottoMount; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_PER_TICKET);
            Collections.sort(numbers);
            generatedLottos.add(new Lotto(numbers));
        }
        return generatedLottos;
    }
}
