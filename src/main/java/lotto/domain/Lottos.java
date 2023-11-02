package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int lottoQuantity) {
        lottos = generateLottos(lottoQuantity);
    }

    private List<Lotto> generateLottos(int lottoQuantity) {
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> generatedNumbers = randomLottoNumberGenerator.generateRandomNumbers();
            Lotto lotto = new Lotto(generatedNumbers);
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }

    public List<String> getMyLottos() {
        List<String> myLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            myLottos.add(lotto.getNumbers());
        }
        return myLottos;
    }
}