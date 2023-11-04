package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.domain.WinLottoResult;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private GameService gameService;
    private WinLottoResult winLottoResult;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

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

        //7) 수익률 계산 기능
        int result = gameService.getLottoPrizePrice(winLottoResult);
        double out = gameService.getPercentPrize(price, result);

        outputView.printPrizePercentResult(out);

    }


}