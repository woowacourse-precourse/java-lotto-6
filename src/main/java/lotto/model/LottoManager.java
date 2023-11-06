package lotto.model;

import static lotto.model.RandomLottoGenerator.pickNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoManager {
    private final Token token;
    private List<Lotto> lottos;

    public LottoManager(int amount) {
        this.token = new Token(amount);
        this.lottos = new ArrayList<>();
    }

    public void ticket() {
        while (token.canTicket()) {
            lottos.add(new Lotto(pickNumbers()));
            token.ticket();
        }
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
    }
}
