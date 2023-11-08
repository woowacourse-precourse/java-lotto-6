package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.description.annotation.AnnotationValue;

import java.util.*;

public class Controller {

    public static void gameStart() {

        //gameStart 시작
        Input input = new Input();
        int inputValue = input.inputValue();

        //로또 만들기
        BuyLotto buyLotto = new BuyLotto(inputValue);
        buyLotto.consoleBuyLotto();

        //당첨번호
        WinLotto winLotto = new WinLotto();

        List<Result> results = new ArrayList<>();

        for (int i = 0; i < inputValue; i++) {
            Prize prize = new Prize(buyLotto.getBuyLotto().get(i).getNumbers(), winLotto.getWinLotto().getNumbers(), winLotto.getBonusNumber());

            results.add(prize.getResult());

        }

        OutputResult outputResult = new OutputResult(results);
        System.out.println();   //개행
        //System.out.println(outputResult.toString());
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Result.five.getMatchingCount() + "개 일치 (5,000원) - " + results.stream().filter(r -> r == Result.five).count() + "개");
        System.out.println(Result.four.getMatchingCount() + "개 일치 (50,000원) - " + results.stream().filter(r -> r == Result.four).count() + "개");
        System.out.println(Result.three.getMatchingCount() + "개 일치 (1,500,000원) - " + results.stream().filter(r -> r == Result.three).count() + "개");
        System.out.println(Result.two.getMatchingCount() + "개 일치, 보너스 볼 일치 (30,000,000원) - " + results.stream().filter(r -> r == Result.two).count() + "개");
        System.out.println(Result.one.getMatchingCount() + "개 일치 (2,000,000,000원) - " + results.stream().filter(r -> r == Result.one).count() + "개");

        double purchaseAmount = inputValue * input.lottoValue;
        double totalPrize = results.stream().mapToDouble(Result::getPrice).sum();
        double profitRate = (totalPrize / purchaseAmount) * 100;
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}



