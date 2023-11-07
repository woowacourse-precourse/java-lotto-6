package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.message.LottoResult;
import lotto.utils.LottoUtil;

public class LottoNumbersInfo {

    public final int bonusNumber;

    private final List<Integer> winningNumbers;
    private final List<Lotto> lottos;

    public LottoNumbersInfo(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {


        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
    }




}
