package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean validPrice = false;
        LottoHandler lottoHandler = new LottoHandler();

        while (!validPrice) {
            try {
                OutputHandler.printMessage("구입금액을 입력해 주세요.");
                lottoHandler.calculateLottoTicketCount(Console.readLine());
                validPrice = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
    }
}
