package lotto.domain;

import static lotto.domain.Lotto.generateLottoNumbers;
import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateLottos(long lottoCount) {
        List<Lotto> generatedLottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            // List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
