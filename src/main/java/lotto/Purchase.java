package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Purchase {
    private Input ipt = new Input();
    private int cost;
    private int amount;
    private ArrayList<List<Integer>> tickets = new ArrayList<>();

    private void checkCost(String raw) {
        try {
            this.cost = Integer.parseInt(raw);
            if (cost <= 0) {
                throw new IllegalArgumentException(Message.INPUT_NUMBER_NEGATIVE.getMessage());
            }
            if (cost % 1000 != 0) {
                throw new IllegalArgumentException(Message.INPUT_NUMBER_THOUSAND.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Message.INPUT_NUMBER.getMessage());
        }
    }

    private void totalCost() {
        while (true) {
            try {
                String input = ipt.costInput();
                checkCost(input);
                return;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calcAmount() {
        this.amount = this.cost / 1000;
    }

    private void randomNubmers() {
        for (int i = 0; i < this.amount; i++) {
            this.tickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    private void printTickets() {
        for (List ticket : this.tickets) {
            System.out.println(ticket.toString());
        }
    }

    public void getTickets() {
        totalCost();
        calcAmount();
        System.out.printf("\n%d%s\n", this.amount, Message.MSG_TICKET.getMessage());

        randomNubmers();
        printTickets();
    }

    public ArrayList<List<Integer>> getTicketArray() {
        return this.tickets;
    }
}
