package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;

public class MemoryTicketRepository implements TicketRepository {

    private static List<Ticket> tickets = new ArrayList<>();
    private static WinningTicket winningTicket;
    private static BonusNumber bonusNumber;

    @Override
    public Ticket purchase(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(tickets);
    }

    @Override
    public WinningTicket announcement(WinningTicket winningTicket) {
        this.winningTicket = winningTicket;
        return winningTicket;
    }

    @Override
    public WinningTicket findNumbers() {
        return winningTicket;
    }

    @Override
    public BonusNumber announcementBonus(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
        return bonusNumber;
    }

    @Override
    public BonusNumber findBonusNumber() {
        return bonusNumber;
    }

}
