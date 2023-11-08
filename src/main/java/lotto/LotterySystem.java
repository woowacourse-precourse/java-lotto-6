package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Draw;

import java.util.List;
import java.util.ArrayList;

public class LotterySystem {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NEED_NUMBER = 6;
    private static int ticketCnt = 0;
    private int bonus = 0;
    private List<Integer> lotto = new ArrayList<>();
    private List<Draw> tickets = new ArrayList<>();
    private InputSystem InputSystem = new InputSystem();
    private Perform Perform = new Perform();

    public void input() {
        ticketCnt = InputSystem.purchase();
    }
    public List<Integer> pick () {
        return Randoms
                .pickUniqueNumbersInRange(
                        MIN_NUMBER, MAX_NUMBER, NEED_NUMBER
                );
    }
    public void draw() {
        for (int i = 0; i < ticketCnt; i++) {
            List<Integer> ticket = pick();
            tickets.add(new Draw(ticket));
        }
        printTickets();
    }
    private void printTickets() {
        for (Draw d : tickets) System.out.println(d.toString());
    }
    public void getNumbers() {
        lotto = InputSystem.getNumbers();
    }
    public void bonus() {
        bonus = InputSystem.getBonus(lotto);
    }
    public void perform() {
        Perform.checknumbers(tickets, lotto, bonus);
    }
    public void result() {
        Perform.result(ticketCnt);
    }

}
