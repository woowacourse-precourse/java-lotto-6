package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoChecker {

    private final Lotto winner;
    private final Integer winnerBonus;

    public LottoChecker(Lotto winner, Integer winnerBonus) {
        if (winnerBonus < LottoEnum.NUMBER_MIN.getValue() || LottoEnum.NUMBER_MAX.getValue() < winnerBonus) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "
                    + LottoEnum.NUMBER_MIN.getValue()
                    + "부터 "
                    + LottoEnum.NUMBER_MAX.getValue()
                    + " 사이의 숫자여야 합니다.");
        }
        if (winner.getNumbers().contains(winnerBonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
        this.winner = winner;
        this.winnerBonus = winnerBonus;
    }

}
