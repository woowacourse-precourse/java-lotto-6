package lotto.domain;

import java.util.List;
import lotto.data.Lotto;

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
