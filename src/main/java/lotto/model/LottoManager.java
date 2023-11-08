package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    private List<Lotto> lottos;
    private LottoGenerator generator;
    private int ticketNumber;

    public LottoManager(LottoGenerator generator, int ticketNumber) {
        lottos = new ArrayList<>();
        this.generator = generator;
        this.ticketNumber = ticketNumber;
    }

    public void generateLottos() {
        for (int i = 0; i < ticketNumber; i++) {
            Lotto newLotto = generator.createSingleLotto();
            lottos.add(newLotto);
        }
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
