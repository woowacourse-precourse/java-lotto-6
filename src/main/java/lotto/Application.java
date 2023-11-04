package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        LottoHandler lottoHandler = new LottoHandler();
        OutputHandler.printMessage("구입금액을 입력해 주세요.");
        lottoHandler.calculateLottoTicketCount(Console.readLine());
    }
}
