package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Accountant;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String money = Console.readLine(); // 금액 입력
        Accountant accountant = new Accountant();
        accountant.countMoney(money);
        // 로또 발행
        String winningNumber = Console.readLine();// 당첨번호 6개 입력
        String bonusNumber = Console.readLine();// 보너스번호 입력
        // 당첨내역 출력
        // 수익률 출력
        // 게임 종료
    }
}
