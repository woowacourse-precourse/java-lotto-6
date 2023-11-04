package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottosDTO toLottosDTO() {
        return new LottosDTO(lottos.stream()
                .map(Lotto::getLotto)
                .collect(Collectors.toList()));
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
