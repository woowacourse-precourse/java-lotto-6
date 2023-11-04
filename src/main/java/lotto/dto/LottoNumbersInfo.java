package lotto.dto;

import java.util.List;
import lotto.Lotto;
import lotto.utils.LottoUtil;

public class LottoNumbersInfo {

    public final int bonusNumber;

    private List<Lotto> lottos;

    public LottoNumbersInfo(List<Lotto> lottos, int bonusNumber) {
        LottoUtil.validateLottoNum(bonusNumber);

        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }
}
