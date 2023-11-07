package lotto.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;

public class MemoryTicketRepository implements TicketRepository {

    private static List<Ticket> memory = new ArrayList<>();
    private static WinningTicket winningTicket;
    private static BonusNumber bonusNumber;

    @Override
    public Ticket purchase(Ticket ticket) {
        memory.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(memory);
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

}
