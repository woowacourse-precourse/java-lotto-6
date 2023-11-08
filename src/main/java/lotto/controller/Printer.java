package lotto.controller;

import lotto.view.Statement;

public class Printer {
    public static void printPurchaseAmount() {
        System.out.println(Statement.ASK_PURCHASE_AMOUNT);
    }

    public static void printTotalTickets() {
        System.out.println(Statement.NOTIFY_TOTAL_LOTTO_TICKETS);
    }

    public static void printUserNumbers() {
        System.out.println(Statement.ASK_JACKPOT_NUMBERS);
    }

    public static void printAskBonus() {
        System.out.println(Statement.ASK_BONUS_NUMBER);
    }

    public static void printProfitRate() {
        System.out.println(Statement.SHOW_PROFIT_RATE);
    }

    public static void printResult() { System.out.println(Statement.GAME_RESULT);
    }

}