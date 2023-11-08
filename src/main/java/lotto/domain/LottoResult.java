package lotto.domain;
import java.util.List;
import java.util.Map;
import lotto.util.ResultGenerator;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        ResultGenerator resultGenerator = new ResultGenerator();
        this.result = resultGenerator.createLottoResult(lottos, winningLotto);
    }
}
