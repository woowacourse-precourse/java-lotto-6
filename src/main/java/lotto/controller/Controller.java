package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.Winning;

import java.util.*;

import static lotto.domain.Numbers.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;
import static lotto.domain.User.*;
import static lotto.domain.Lotto.*;

public class Controller { //게임 흐름을 컨트럴
    ;
    private static Winning winning;

    public void Run(){ //실행 코드
        try {
            Integer paper = PaperNumber(InputMoney());
            List<Lotto> lottos = makeLottoTicket(paper);
            winning = validateBonus();
            lottoResult(lottos, winning, paper);
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public Winning validateBonus() { //당첨번호 입력
        Lotto lotto = new Lotto(makeLottos(InputNums()));
        List<Integer> winningNumber = lotto.getNumbers();

        int bonus = InputBonus();
        BonusValidate(bonus, winningNumber);

        winning = new Winning(new Lotto(winningNumber), bonus);

        return winning;
    }

    private void lottoResult(List<Lotto> lottos, Winning winning, int amount) {
        Map<Ranking, Integer> maching = setResult();

        for (Lotto lotto : lottos) {
            Ranking ranking = winning.match(lotto);
            maching.put(ranking, maching.get(ranking) + 1);
        }
        PrintStart();
        printEnd(maching);
        printRate(maching, amount);
    }
    private Map<Ranking, Integer> setResult() { //초기화
        Map<Ranking, Integer> maching = new LinkedHashMap<>();
        for (Ranking ranking : Ranking.values()) {
            maching.put(ranking, 0);
        }
        return maching;
    }
}
