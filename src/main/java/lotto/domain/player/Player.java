package lotto.domain.player;

import lotto.domain.common.Money;
import lotto.domain.lotto.LottoMachine;

import java.util.Objects;

class Player {

    private static final String UNKNOWN_LOTTO_MACHINE_MESSAGE = "알 수 없는 로또 기계로 플레이어를 생성할 수 없습니다.";

    private final PlayerMoney money;
    private final PlayerLotto lotto;

    private Player(PlayerMoney money, PlayerLotto lotto) {
        this.money = money;
        this.lotto = lotto;
    }

    public static Player from(Money initialMoney, LottoMachine lottoMachine) {
        checkLottoMachineNonNull(lottoMachine);

        return new Player(PlayerMoney.from(initialMoney), PlayerLotto.from(lottoMachine.issueWith(initialMoney)));
    }

    private static void checkLottoMachineNonNull(LottoMachine lottoMachine) {
        if (Objects.isNull(lottoMachine)) {
            throw new IllegalArgumentException(UNKNOWN_LOTTO_MACHINE_MESSAGE);
        }
    }
}
