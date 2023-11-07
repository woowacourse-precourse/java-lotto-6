package lotto.model;
import lotto.dto.LottoMatchNumberDTO;
public class LottoResult {
    private final LottoMatchNumberDTO lottoMatchNumberDTO;
    public LottoResult(LottoMatchNumberDTO lottoMatchNumberDTO) {
        this.lottoMatchNumberDTO = lottoMatchNumberDTO;
    }
    public LottoMatchNumberDTO testDTO(){
        return this.lottoMatchNumberDTO;
    }
}
