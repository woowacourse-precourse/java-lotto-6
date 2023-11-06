package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.LottoBonusNumberCreateRequest;
import lotto.dto.LottoPurchaseRequest;
import lotto.dto.LottoWinningNumberCreateRequest;
import lotto.dto.LottoWinningStatistics;

public class LottoGameConsoleView implements LottoGameView {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    @Override
    public LottoPurchaseRequest inputPurchaseRequest() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return new LottoPurchaseRequest(purchaseAmount);
    }

    @Override
    public void printPurchasedTickets(List<Lotto> purchasedLottoTickets) {
        long numLottoTickets = purchasedLottoTickets.size();

        System.out.println();
        System.out.println(numLottoTickets + "개를 구매했습니다.");

        for (Lotto lottoTicket : purchasedLottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    @Override
    public LottoWinningNumberCreateRequest inputLottoWinningNumberCreateRequest() {
        return null;
    }

    @Override
    public LottoBonusNumberCreateRequest inputLottoBonusNumberCreateRequest() {
        return null;
    }

    @Override
    public void printWinningStatistics(LottoWinningStatistics lottoWinningStatistics) {

    }

    @Override
    public void printException(Exception exception) {
        String message = ERROR_MESSAGE_PREFIX + exception.getMessage();
        System.out.println(message);
        System.out.println();
    }
}
