package lotto.gameUtil;

import lotto.Lotto;
import lotto.domain.Enum.Rank;
import lotto.exception.InputException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class GamePlay {
    private InputView inputView;
    private GameLogic gameLogic;
    public GamePlay(){
        inputView = new InputView();
        gameLogic = new GameLogic();
    }
    public void gamePlay(){
        int amount = inputView.inputAmount(); // 구매금액 입력
        List<Lotto> lottoList = gameLogic.lottoNumber(amount); // 구매한 만큼 로또번호 생성
        String[] winningNumberString = inputView.winningNumber(); // 당첨번호 입력
        Lotto winningLotto = gameLogic.winningNumber(winningNumberString); // 번호에 대한 Lotto객체 생성
        int bonusNumber = inputView.bonusNumber(winningLotto); // 보너스 번호 입력


        for(int i=0;i<lottoList.size();i++){  // 구매한 만큼 로또 당첨 확인
            int count = gameLogic.matchCount(lottoList.get(i), winningLotto, bonusNumber);
            boolean isSecond = gameLogic.matchBonus(lottoList.get(i), bonusNumber);
            gameLogic.matchLotto(count, isSecond);
        }
        // 당첨 금액 계산
        Map<Rank, Integer> ranks = gameLogic.getRanks();
        gameLogic.lottoResult(ranks, amount);
    }
}
