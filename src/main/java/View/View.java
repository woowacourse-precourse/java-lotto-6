package View;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoController;
import lotto.Lotto;

import java.util.List;

public class View {

    public void start() {
        // 사용자에게 로또 구입 금액을 입력하라고 요청
        System.out.println("로또 구입 금액을 입력해주세요:");
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
        System.out.println(winningNumber);

        System.out.println("보너스 번호를 입력해 주세요.");
        List<Integer> winningNumberBonus = lottoController.bonusNumber(winningNumber);
    }
}
