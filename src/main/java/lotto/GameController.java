package lotto;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private static final int ERROR = -1;
    GameService gameService = new GameService();

    public void start() {
        int ticketCount = payCash();
        buyTicket(ticketCount);
    }

    public int payCash() {
        int ticketCount;

        while (true) {
            String rawInput = inputCash();
            ticketCount = gameService.validInput(rawInput);
            if (ticketCount != ERROR) {
                break;
            }
        }
        return ticketCount;
    }

    public String inputCash() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void buyTicket(int ticketCount) {
        // todo gameService.generTicketNumber(ticketCount);
        System.out.println(ticketCount + "개를 구매했습니다.");
    }
}
