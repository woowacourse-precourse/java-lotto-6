package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GameService gameService = new GameService();

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
        //4) 당첨 번호 입력 기능
        List<Integer> win_list = inputView.readWinningNumber();

        //5) 보너스 번호 입력 기능
        int bonus_num = inputView.readBonusNumber();

        //6) 당첨에 대한 통계 기능

        //7) 수익률 계산 기능

    }


}
