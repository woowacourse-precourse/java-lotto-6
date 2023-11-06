package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.player.Player;

import java.util.List;

public class LottoSystem {

    private List<LottoNumber> winningLottoNumbers;
    private Player player;

    public LottoSystem(List<LottoNumber> winningLottoNumbers, Player player) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.player = player;
    }
}
