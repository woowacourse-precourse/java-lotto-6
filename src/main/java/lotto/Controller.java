package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.Winning;

import java.util.*;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;
import static lotto.domain.User.*;
import static lotto.domain.Lotto.*;

public class Controller { //게임 흐름을 컨트럴
    private static Integer paper = 0;
    private static List<Lotto> lottos = new ArrayList<>();;
    private static Winning winning;

    public void Run(){ //실행 코드
        try {
            paper = PaperNumber(InputMoney());
            lottos = makeLottoTicket(paper);
            winning = validateBonus();
            lottoResult(lottos, winning, paper);
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> setRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<Lotto> makeLottoTicket(Integer PaperNumber) { //로또 번호 만들기
        for (int i = 0; i < PaperNumber; i++) {
            List<Integer> lottoNumbers = setRandomNumbers();
            System.out.println(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
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
        Map<Ranking, Integer> result = setResult();

        for (Lotto lotto : lottos) {
            Ranking rank = winning.match(lotto);
            result.put(rank, result.get(rank) + 1);
        }
        PrintStart();
        printEnd(result);
        printRate(result, amount);
    }
    private Map<Ranking, Integer> setResult() { //초기화
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }









}
