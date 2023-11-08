package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottosDTO toLottosDTO() {
        List<List<Integer>> lottosDTO = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottosDTO.add(lotto.toDTO());
        }

        return new LottosDTO(lottosDTO);
    }

    public List<LottoResults> calculateAllOfLottoResult(WinningNumbers winningNumbers) {
        List<LottoResults> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoResults lottoResult = winningNumbers.calculateLottoResult(lotto);
            lottoResults.add(lottoResult);
        }
        return lottoResults;
    }
}
