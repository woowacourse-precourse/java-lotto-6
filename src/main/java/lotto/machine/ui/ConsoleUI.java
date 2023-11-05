package lotto.machine.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ConsoleUI implements UI {
    @Override
    public void requirePurchaseView() {
        System.out.println("구입금액을 입력해주세요.");
    }

    @Override
    public int inputPurchaseAmount() {
        String result = Console.readLine();
        System.out.println("result = " + result);
        int resultInt = Integer.parseInt(result);
        System.out.println("resultInt = " + resultInt);
        return resultInt;
    }

    @Override
    public void outputPurchaseLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println('[' + lotto.toString() + ']');
        });
    }

    @Override
    public void requireWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        String[] result = Console.readLine().split(",");
        if(result.length != 6) throw new IllegalArgumentException();
        List<Integer> resultInt = new LinkedList<>();
        Arrays.stream(result).forEach(str -> {
            resultInt.add(Integer.parseInt(str));
        });
        System.out.println("resultInt = " + resultInt);
        return resultInt;
    }

    @Override
    public void requireBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public int inputWBonusNumber() {
        String result = Console.readLine();
        System.out.println("result = " + result);
        int resultInt = Integer.parseInt(result);
        System.out.println("resultInt = " + resultInt);
        return resultInt;
    }

    @Override
    public void outputGameResult(
            int matchThree, int matchFour, int matchFiveIncludeBonus, int matchFiveExceptBonus, int matchSix, double rateOfReturn
    ) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchThree + '개');
        System.out.println("4개 일치 (50,000원) - " + matchFour + '개');
        System.out.println("5개 일치 (1,500,000원) - " + matchFiveIncludeBonus + '개');
        System.out.println("5개 일치, 보너스 불 일치 (30,000,000원) - " + matchFiveIncludeBonus + '개');
        System.out.println("6개 일치 (2,000,000,000원) - " + matchSix + '개');
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
