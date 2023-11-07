package lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private List<Lotto> lottoTicket;
    private List<Integer> winningNumber;

    public Input(List<Lotto> lottoTicket, List<Integer> winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
    }
}
