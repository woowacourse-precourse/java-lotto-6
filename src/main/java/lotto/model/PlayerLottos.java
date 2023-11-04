package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.NumberConst;

public class PlayerLottos {
    List<PlayerLotto> playerLottos;

    public PlayerLottos(int money) {
        int issueCount = money / NumberConst.DENOMINATION;
        playerLottos = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            playerLottos.add(new PlayerLotto());
        }
    }

    public List<PlayerLotto> getPlayerLottos() {
        return playerLottos;
    }
}
