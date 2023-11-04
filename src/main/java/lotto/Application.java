package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean validPrice = false;
        int lottoTicket = 0;
        LottoHandler lottoHandler = new LottoHandler();

        while (!validPrice) {
            try {
                OutputHandler.printMessage("구입금액을 입력해 주세요.");
                lottoTicket = lottoHandler.calculateLottoTicketCount(Console.readLine());
                validPrice = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        List<List<Integer>> lottoNumbers = lottoHandler.issueLottoNumbers(lottoTicket);
    }
}
