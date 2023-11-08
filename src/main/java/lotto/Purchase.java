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
            if (cost < 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 음수일 수 없습니다.");
            }
            if (cost % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 천 단위의 수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자를 입력하세요.");
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
        for (List ticket: this.tickets) {
            System.out.println(ticket.toString());
        }
    }

    public void getTickets() {
        totalCost();
        calcAmount();
        System.out.printf("\n%d개를 구매했습니다.\n", this.amount);

        randomNubmers();
        printTickets();
    }

    public ArrayList<List<Integer>> getTicketArray() {
        return this.tickets;
    }
}
