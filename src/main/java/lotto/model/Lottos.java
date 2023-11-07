package lotto.model;

import lotto.utils.GetRandomNumber;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(int lottoAmount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            lottoList.add(new Lotto(createLotto()));
        }

        this.lottoList = lottoList;
    }

    private List<Integer> createLotto() {
        List<Integer> Lotto = new ArrayList<>();

        while(Lotto.size() != 6) {
            int randomNumber = GetRandomNumber.getRandomNumber();

            if (!Lotto.contains(randomNumber)){
                Lotto.add(randomNumber);
            }
        }

        return Lotto;
    }

    public List<Lotto> getLottoList () {
        return lottoList;
    }
}
