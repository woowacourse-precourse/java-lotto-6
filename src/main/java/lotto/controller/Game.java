package lotto.controller;

import lotto.domain.Ticket;
import lotto.view.View;

public class Game {

    public static void start() {
        int money = View.requestMoney();

        Ticket ticket = new Ticket(money);
        System.out.println(ticket.amount+"개 샀음");

    }
}
