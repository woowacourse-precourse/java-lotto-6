package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.domain.WinLottoResult;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GameService gameService = new GameService();
    WinLottoResult winLottoResult;

    //전체 게임 여기서 컨트롤
    public void gameStart() {
        //1) 구매 금액 입력받기
        int price = inputView.readLottoPrice();
        int lotto_count = price / 1000;

        //2) 구매 가능한 로또 개수만큼 로또 자동 발급 기능
        List<Lotto> lotto_list = gameService.generateLottoList(lotto_count);

        //3) 발급한 로또 번호 출력 기능
        outputView.printLottoCount(lotto_count);
        for (int i = 0; i < lotto_count; i++) {
            outputView.printCurrentLottoList(lotto_list.get(i));
        }

        WinLotto winLotto = new WinLotto();
        //4) 당첨 번호 입력 기능
        List<Integer> win_list = inputView.readWinningNumber();
        winLotto.setNumbers(win_list);

        //5) 보너스 번호 입력 기능
        int bonus_num = inputView.readBonusNumber();
        winLotto.setBonus_num(bonus_num);

        //6) 당첨에 대한 통계 기능
        gameService.judgePrizeLotto(winLotto, lotto_list, winLottoResult);
        outputView.printResultLottoPrize(winLottoResult);

        //7) 수익률 계산 기능 - (+/- ) 구분해서 구해야 함
        int result = getLottoPrizePrice(winLottoResult);
        //수익금 / 구매금액 * 100
        double out = getPercentPrize(price, result);
        System.out.print("총 수익률은 ");
        System.out.format("%.1f%%%n", out);
        System.out.print("입니디.");
    }

    static int getLottoPrizePrice(WinLottoResult winLottoResult) {
        int lottoPrizePrice = 0;
        for (WinLottoResult cur : winLottoResult.values()) {
            if (cur.getName().equals("three")) {
                lottoPrizePrice += (5000) * cur.getCount();
            }
            if (cur.getName().equals("four")) {
                lottoPrizePrice += (50000) * cur.getCount();
            }
            if (cur.getName().equals("five")) {
                lottoPrizePrice += (1500000) * cur.getCount();
            }
            if (cur.getName().equals("five_bonus")) {
                lottoPrizePrice += (30000000) * cur.getCount();
            }
            if (cur.getName().equals("six")) {
                lottoPrizePrice += (2000000000) * cur.getCount();
            }
        }
        return lottoPrizePrice;
    }

    static double getPercentPrize(int inPrice, int outPrice) {
        double inVal = inPrice + 0.0;
        double outVal = outPrice + 0.0;

        double result = outVal / inVal * 100;
        result = Math.round(result * 100) / 100.0; //소수점 둘째 자리에서 반올림하고,
        return result;
    }

}
