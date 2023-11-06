package lotto;

import java.util.List;

public class LottoTicket extends Lotto{
    public LottoTicket() {
        super(LottoNumberGenerator.createNumbers());
    }
}
