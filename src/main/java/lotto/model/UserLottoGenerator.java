package lotto.model;

import lotto.NumberGenerator;

import java.util.List;

public class UserLottoGenerator {
    private final int trial;
    private final List<Lotto> lottoList;
    private final NumberGenerator numberGenerator;

    public UserLottoGenerator(NumberGenerator numberGenerator, int trial, List<Lotto> lottoList) {
        this.numberGenerator = numberGenerator;
        this.trial = trial;
        this.lottoList = lottoList;
    }

    public List<Lotto> makeLottoList() {

        for (int i = 0; i < trial; i++) {
            lottoList.add(new Lotto(numberGenerator.createNumber()));
        }

        return lottoList;
    }
}
