package lotto.controller;

import lotto.util.InputVaildate;
import lotto.view.inputView;
import lotto.service.MoneyToTicket;
import lotto.service.LottoNumberGenerate;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    InputVaildate inputVaildate = new InputVaildate();
    MoneyToTicket moneyToTicket = new MoneyToTicket();
    LottoNumberGenerate lottoNumberGenerate = new LottoNumberGenerate();
    LottoBuyer lottoBuyer = new LottoBuyer();
    List<int[]> tickets = new ArrayList<>();
    public void run() {
        //로또 구매
        buyLotto();

        //로또 추첨
//        drawLotto();
            // 당첨번호 입력
            //보너스 번호 입력
        //추첨 결과
            //추첨 결과 안내
            //수익률 안내
    }
    public void buyLotto() {
        //구매 금액 입력
        lottoBuyer.setPurchaseAmount(Integer.parseInt(inputView.getRequestMoney()));
        //수량으로 변환
        lottoBuyer.setTicketQuantity(moneyToTicket.getTicket(lottoBuyer.getPurchaseAmount()));
//        int lottoTicket = moneyToTicket.getTicket(moneyForBuyLotto);
        //수량만큼 로또 발행
        tickets = lottoNumberGenerate.getTickets(lottoBuyer.getTicketQuantity());

        System.out.println(lottoBuyer.getPurchaseAmount());
        System.out.println(lottoBuyer.getTicketQuantity());
        System.out.println(tickets.size());
        for (int[] ticket : tickets) {
            System.out.println(Arrays.toString(ticket));
        }
    }
    public void drawLotto() {
        // 당첨 번호 입력
        String[] inputWinnnigNumbers = (inputView.getRequestWinningNumber().split(","));
        // 유효성 검사
        int[] winnnigNumbers = new int[inputWinnnigNumbers.length];
        for (int i = 0; i < inputWinnnigNumbers.length; i++) {
            winnnigNumbers[i] = Integer.parseInt(inputWinnnigNumbers[i]);
        }
        // 당첨 번호 출력
        System.out.println(Arrays.toString(winnnigNumbers));

        // 보너스 번호 입력
        int bonusNumbers = Integer.parseInt(inputView.getRequestBonusNumber());
        // 유효성 검사

        // 당첨 번호 출력
        System.out.println(bonusNumbers);
    }
}
