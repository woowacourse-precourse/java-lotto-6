package lotto.LottoController;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class GeneratorLotto {

    private static final int PRICE = 1000;

    public List<Lotto> generatorLotto(int purchaseAmount) {
        int lottoNumbers = purchaseAmount / PRICE;

        List<Lotto> generateLottos = new ArrayList<>();

        for (int i = 0; i < lottoNumbers; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            generateLottos.add(new Lotto(numbers));
        }
        return generateLottos;
    }
}
