package lotto.module.lotto;

import java.util.ArrayList;
import java.util.List;

public record UserLottoTickets(List<Lotto> tickets) {

    public static UserLottoTickets newInstance(List<Lotto> tickets) {
        return new UserLottoTickets(tickets);
    }

    @Override
    public List<Lotto> tickets() {
        return new ArrayList<>(tickets);
    }

}
