package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Money money = new Money(askToPay());// 금액 입력
        int howManyLotto = money.getHowManyLotto();// 로또 개수
        //List<List<Integer>> lottos = Lotto.generate(howManyLotto);

        //for (List<Integer> lotto : lottos) {
        //    System.out.println(lotto);
        //}
        List<Integer> winningNumber = askWinningNumber();// 당첨번호 6개 입력
        int bonusNumber = askBonus();// 보너스번호 입력
        WinningNumber numbers = new WinningNumber(winningNumber, bonusNumber);
        // 당첨내역 출력
        // 수익률 출력
        // 게임 종료
    }

    public static int askToPay() {
        System.out.println("구입 금액을 입력해주세요.");
        InputConverter converter = new InputConverter();
        return converter.convertToMoneyOrBonusNumber(Console.readLine());
    }

    public static List<Integer> askWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요. (숫자 6개 입력)");
        InputConverter converter = new InputConverter();
        return converter.convertToWinningNumbers(Console.readLine());
    }

    public static int askBonus() {
        System.out.println("보너스 번호를 입력해주세요.");
        InputConverter converter = new InputConverter();
        return converter.convertToMoneyOrBonusNumber(Console.readLine());
    }
}
