package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoDatas {
    private List<Lotto> lottoNumbers;
    private BonusNumber bonusNumbers;
    private PurChase purchase;

    public LottoDatas(final String userInputNumber) {

    }

    public LottoDatas(final List<Integer> generatedLottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        Lotto lotto = Lotto.createLotto(generatedLottoNumbers);
        lottoNumbers.add(lotto);
    }

    public LottoDatas() {

    }
}
