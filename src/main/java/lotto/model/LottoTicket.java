package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final int tickets;
    private final List<List<Integer>> ticketNumbers;

    public LottoTicket(int tickets, List<List<Integer>>ticketNumbers) {
        this.tickets = tickets;
        this.ticketNumbers = ticketNumbers;
    }

    public List<List<Integer>> getTicketNumbers() {
        return ticketNumbers;
    }

    public int getTickets() {
        return tickets;
    }
}