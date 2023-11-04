package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 민경수
 * @description lottos
 * @since 2023.11.04
 **********************************************************************************************************************/
public class Lottos {

    private final List<Lotto> lottoTickets;

    public Lottos(List<Lotto> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

}