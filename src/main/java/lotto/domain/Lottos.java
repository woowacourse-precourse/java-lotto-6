package lotto.domain;

import static lotto.constants.ErrorMessages.LOTTO_MINIMUM_COUNT;
import static lotto.domain.Lotto.generateLottoNumbers;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateLottos(long lottoCount) {

        if (lottoCount <= 0) { throw new IllegalArgumentException(LOTTO_MINIMUM_COUNT.getErrorMessage()); };

        List<Lotto> generatedLottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lottoNumbers = generateLottoNumbers();
            generatedLottos.add(lottoNumbers);
        }
        return new Lottos(generatedLottos);
    }

    public int count() {
        return lottos.size();
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    public List<Lotto> getLottos() {
        return lottos;
    }
}
