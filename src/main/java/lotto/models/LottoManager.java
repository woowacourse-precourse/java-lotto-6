package lotto.models;

import lotto.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private final int lottoAmount;
    private final List<Lotto> lottos = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public LottoManager(int lottoAmount) {
        this.lottoAmount = lottoAmount;

        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(randomNumberGenerator.generateRandomLottoNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult calcLottoResult(WinNumber winNumber) {
        LottoResult lottoResult = new LottoResult(lottoAmount);
        for (Lotto lotto : lottos) {
            LottoGrade lottoGrade = lotto.calcRank(winNumber);
            lottoResult.addLottoResult(lottoGrade);
        }
        return lottoResult;
    }

}
