package lotto;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private List<Lotto> lottoTicket;
    private List<Integer> winningNumber;
    public Output(List<Lotto> lottoTicket, List<Integer> winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
    }
}
