package lotto.controller;

import lotto.util.InputVaildate;
import lotto.view.OutputView;
import lotto.view.inputView;
import lotto.service.MoneyToTicket;
import lotto.service.LottoNumberGenerate;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LottoController {
    InputVaildate inputVaildate = new InputVaildate();
    MoneyToTicket moneyToTicket = new MoneyToTicket();
    LottoNumberGenerate lottoNumberGenerate = new LottoNumberGenerate();
    LottoBuyer lottoBuyer = new LottoBuyer();
    LottoTicket lottoTicket = new LottoTicket();
    LottoWinning lottoWinning = new LottoWinning();
    List<int[]> tickets = new ArrayList<>();
    public void run() {
        //로또 구매
        buyLotto(inputView.getRequestMoney());

        //로또 추첨
        drawLotto(inputView.getRequestWinningNumber());
            // 당첨번호 입력
            //보너스 번호 입력
        //추첨 결과
            //추첨 결과 안내
            //수익률 안내
    }
    public void buyLotto(String money) {
        //구매 금액 입력
        lottoBuyer.setPurchaseAmount(Integer.parseInt(money));
        //수량으로 변환
        lottoBuyer.setTicketQuantity(moneyToTicket.getTicket(lottoBuyer.getPurchaseAmount()));
//        int lottoTicket = moneyToTicket.getTicket(moneyForBuyLotto);
        //수량만큼 로또 발행
        tickets = lottoNumberGenerate.getTickets(lottoBuyer.getTicketQuantity());

        OutputView.displayPurchaseHistory(lottoBuyer.getTicketQuantity(),tickets);
    }

    public void drawLotto(String number) {
        // 형변한 및 유효성 검사
        String[] strArrNumbers = number.split(",");
        int[] intArrNumbers = Arrays.stream(strArrNumbers)
                            .mapToInt(Integer::parseInt)
                            .toArray();
        // 유효성 검사


        lottoWinning.setNumbers(intArrNumbers);

        // 당첨 번호 출력
//        System.out.println(Arrays.toString(winnnigNumbers));

        // 보너스 번호 입력
//        int bonusNumbers = Integer.parseInt(inputView.getRequestBonusNumber());
        // 유효성 검사

        // 당첨 번호 출력
//        System.out.println(bonusNumbers);
    }
}
