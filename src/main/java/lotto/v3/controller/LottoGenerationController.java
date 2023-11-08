package lotto.v3.controller;

import lotto.v3.model.LottoMachine;
import lotto.v3.model.Lotto;
import lotto.v3.view.LottoGenerateView;
import java.util.List;

public class LottoGenerationController {
    private final LottoGenerateView generateView;
    private final LottoMachine machine;

    public LottoGenerationController(LottoGenerateView generateView, LottoMachine machine) {
        this.generateView = generateView;
        this.machine = machine;
    }

    public List<Lotto> generateLottoTickets(int numberOfTickets) {
        while(true){
            try {
                List<Lotto> tickets = machine.generateTickets(numberOfTickets);
                generateView.displayLottoTickets(tickets);
                return tickets;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
}
