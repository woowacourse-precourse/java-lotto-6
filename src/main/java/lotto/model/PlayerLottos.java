package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerLottos {

    private final List<Lotto> playerLottos;

    public PlayerLottos(int numberOfLottoTickets) {
        this.playerLottos = generatePlayerLottos(numberOfLottoTickets);
    }

    public List<Lotto> getPlayerLottos() {
        return playerLottos;
    }

    private List<Lotto> generatePlayerLottos(int numberOfLottoTickets) {
        return Stream.generate(LottoFactory::generateLotto)
                .limit(numberOfLottoTickets)
                .collect(Collectors.toList());
    }
}
