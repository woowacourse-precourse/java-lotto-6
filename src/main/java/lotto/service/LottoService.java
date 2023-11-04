package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.dto.LottoReceiptDto;
import lotto.dto.LottoResultDto;
import lotto.random.RandomNumberGenerator;
import java.util.List;

public class LottoService {
    private final RandomNumberGenerator randomNumberGenerator;

    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public LottoReceiptDto getLottoReceipt(int payment) {
        return new LottoReceiptDto();
    }

    public void generateWinningLottoWithoutBonusNumber(List<Integer> winningLottoNumbers) {
    }

    public void generateWinningLotto(int bonusNumber) {
    }

    public LottoResultDto getLottoResult() {
        return new LottoResultDto();
    }
}