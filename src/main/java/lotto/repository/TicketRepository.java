package lotto.repository;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;

public interface TicketRepository {

    Ticket purchase(Ticket ticket);

    List<Ticket> findAll();

    WinningTicket announcement(WinningTicket winningTicket);

    WinningTicket findNumbers();

    BonusNumber announcementBonus(BonusNumber bonusNumber);

    BonusNumber findBonusNumber();

}
