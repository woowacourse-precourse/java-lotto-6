package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private static final LottoHandler lottoHandler = new LottoHandler();

    public static void main(String[] args) {
        int numberOfLotto = lottoCountForPurchasePrice();
        List<Lotto> lottos = lottoHandler.issueLottoNumbers(numberOfLotto);
    }

    private static int lottoCountForPurchasePrice() {
        int lottoTicket = 0;
        boolean validPrice = false;

        while (!validPrice) {
            try {
                OutputHandler.printMessage("구입금액을 입력해 주세요.");
                lottoTicket = lottoHandler.calculateLottoTicketCount(Console.readLine());
                validPrice = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        return lottoTicket;
    }
}
