package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto() {
        // TODO: 랜덤 유니크 생성하기  / 로또 개별 번호에 대한 생각
        winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        bonusNumber = 1;
    }
}
