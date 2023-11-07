package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public void start() {
        List<Lotto> lottoTicket = new ArrayList<>();
        List<Integer> winningNumber = new ArrayList<>();
        Input input = new Input(lottoTicket, winningNumber);
        Output output = new Output(lottoTicket, winningNumber);
    }
}
