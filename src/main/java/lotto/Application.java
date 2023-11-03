package lotto;

import lotto.domain.Enum.Rank;
import lotto.gameUtil.GameLogic;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameLogic gameLogic = new GameLogic();

        Double prize = 0D;
        outputView.amountMessage(); // 구매금액 입력
        int amount = inputView.inputAmount();

        List<Lotto> lottoList = gameLogic.lottoNumber(amount); // 구매한 만큼 로또번호 생성

        outputView.winningNumberMessage(); // 당첨번호 입력
        String winningNumberString = inputView.winningNumber();
        Lotto winningLotto = gameLogic.winningNumber(winningNumberString);
        outputView.bonusNumberMessage(); // 보너스 번호 입력
        int bonusNumber = inputView.bonusNumber();

        for(int i=0;i<lottoList.size();i++){  // 당첨 확인
            int count = gameLogic.matchCount(lottoList.get(i), winningLotto, bonusNumber);
            boolean isSecond = gameLogic.matchBonus(lottoList.get(i), bonusNumber);
            gameLogic.matchLotto(count, isSecond);
        }
        Map<Rank, Integer> ranks = gameLogic.getRanks();
        prize += ranks.get(Rank.FIRST) * Rank.FIRST.getAmount();
        prize += ranks.get(Rank.SECOND) * Rank.SECOND.getAmount();
        prize += ranks.get(Rank.THIRD) * Rank.THIRD.getAmount();
        prize += ranks.get(Rank.FORTH) * Rank.FORTH.getAmount();
        prize += ranks.get(Rank.FIFTH) * Rank.FIFTH.getAmount();

        outputView.matchingMessage(ranks);
        System.out.println(prize);
        System.out.println("총 수익률은 " + (prize * 100) / amount + "%입니다.");
    }
}
