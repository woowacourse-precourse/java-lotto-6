package View;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoController;

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

        System.out.println("당첨 번호를 입력해 주세요.");
        lottoController.winner(totalLottoTickets);


    }
}
