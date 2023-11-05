package View;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoController;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class View {

    public void start() {
        // 사용자에게 로또 구입 금액을 입력하라고 요청
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = Console.readLine();

        LottoController lottoController = new LottoController();

        int lottoTicketCount = lottoController.start(inputValue);
        System.out.println(lottoTicketCount+"개를 구매했습니다.");
        List<List<Integer>> totalLottoTickets = lottoController.lottoTicketCount(lottoTicketCount);

        for (List<Integer> totalLottoTicket : totalLottoTickets) {
            System.out.println(totalLottoTicket);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = lottoController.winningNumber(totalLottoTickets);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = lottoController.bonusNumber(winningNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        Map<String, Integer> resultsCount = lottoController.checkWinners(totalLottoTickets,winningNumber,bonusNumber);

        for (Map.Entry<String, Integer> entry : resultsCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + "개");
        }

        float totalPrize = lottoController.totalPrizeMoney(resultsCount,lottoTicketCount*1000);

        System.out.println("총 수익률은 " + String.format("%.1f", totalPrize) + "%입니다.");

    }
}
