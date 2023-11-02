package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int money) {
        this.lottos = buyLottos(money);
    }

    private List<Lotto> buyLottos(int money) {
        int count = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            RandomLottoNumberGenerator lottoGenerator = new RandomLottoNumberGenerator();
            Set<Integer> numbers = lottoGenerator.generateNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<String> makeMyLottosForPrint() {
        List<String> myLottosForPrint = new ArrayList<>();
        for (Lotto lotto : lottos) {
            myLottosForPrint.add(lotto.getLottoNumbers());
        }
        return myLottosForPrint;
    }

    public List<Integer> matchNumbersEachLotto(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> matchedNumbersEachLotto = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchedNumbersEachLotto.add(lotto.checkResult(winningNumbers, bonusNumber));
        }
        return matchedNumbersEachLotto;
    }
}
