package lotto;

import lotto.lottoMaker.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public void start() {
        List<Lotto> lottoTicket = new ArrayList<>();
        List<Integer> winningNumber = new ArrayList<>();
        Input input = new Input(lottoTicket, winningNumber);
        int bonusNumber = input.startInput();

        Output output = new Output(lottoTicket, winningNumber);
        output.printOutput(bonusNumber);
    }
}
