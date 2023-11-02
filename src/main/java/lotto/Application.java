package lotto;

import lotto.gameUtil.GameLogic;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameLogic gameLogic = new GameLogic();

        outputView.amountMessage(); // 구매금액 입력
        int amount = inputView.inputAmount();

        List<Lotto> lottoList = gameLogic.lottoNumber(amount); // 구매한 만큼 로또번호 생성

        outputView.winningNumberMessage(); // 당첨번호 입력
        String winningNumberString = inputView.winningNumber();
        Lotto winningLotto = gameLogic.winningNumber(winningNumberString);
        outputView.bonusNumberMessage(); // 보너스 번호 입력
        int bonusNumber = inputView.bonusNumber();

        for(int i=0;i<lottoList.size();i++){  // 당첨 확인
            gameLogic.lottoNumberCompare(lottoList.get(i), winningLotto, bonusNumber);
        }


    }
}
