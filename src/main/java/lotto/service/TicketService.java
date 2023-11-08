package lotto.service;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.Ticket;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class TicketService {

    public static Ticket createTicket(int price) {
        int purchaseNum = price / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchaseNum; i++) {
            lottos.add(LottoService.createLotto());
        }
        return new Ticket(lottos, purchaseNum);
    }

    public static EnumMap<Prize, Integer> getResult(Ticket ticket, List<Integer> winningNumber, int bonusNumber) {
        EnumMap<Prize, Integer> result = new EnumMap<Prize, Integer>(Prize.class);
        for(Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
        for(Lotto lotto : ticket.getLottos()) {
            Prize prize = LottoService.getPrize(lotto.getNumbers(), winningNumber, bonusNumber);
            result.put(prize, result.get(prize) + 1);
        }
        return result;
    }
}
