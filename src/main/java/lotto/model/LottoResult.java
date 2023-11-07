package lotto.model;
import lotto.dto.LottoMatchNumberDTO;
public class LottoResult {
    private final Lottos lottos;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private final LottoMatchNumberDTO lottoMatchNumberDTO;
    public LottoResult(Lottos lottos, Lotto winningLotto, BonusNumber bonusNumber,LottoMatchNumberDTO lottoMatchNumberDTO) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottoMatchNumberDTO = lottoMatchNumberDTO;
    }
    public LottoMatchNumberDTO testDTO(){
        return this.lottoMatchNumberDTO;
    }
}
