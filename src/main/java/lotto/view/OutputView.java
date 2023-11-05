package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPurchaseManager;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void outputLottoTickets(LottoPurchaseManager lottoPurchaseManager) {
        List<Lotto> lottoTickets = lottoPurchaseManager.getLottoTickets();

        System.out.println(lottoPurchaseManager.calculateLottoTicketCount() + "개를 구매했습니다.");

        for (Lotto ticket : lottoTickets) {

            List<Integer> numberValues = ticket.getNumbers().stream()
                    .map(LottoNumber::getWinningNumber)
                    .collect(Collectors.toList());

            System.out.println(numberValues);
        }
    }
}
