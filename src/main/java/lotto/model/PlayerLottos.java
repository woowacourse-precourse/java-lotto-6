package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerLottos {

    private final List<Lotto> playerLottos;

    public PlayerLottos(int numberOfLottoTickets) {
        this.playerLottos = generatePlayerLottos(numberOfLottoTickets);
    }

    public List<Lotto> getPlayerLottos() {
        return playerLottos;
    }

    private List<Lotto> generatePlayerLottos(int numberOfLottoTickets) {
        List<Lotto> playerLottos = new ArrayList<>();

        for (int count = 0; count < numberOfLottoTickets; count++) {
            playerLottos.add(LottoFactory.generateLotto());
        }
        return playerLottos;
    }
}
