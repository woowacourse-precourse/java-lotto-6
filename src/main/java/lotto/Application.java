package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Money money = new Money(Console.readLine());// 금액 입력
        int theNumberOfTickets = money.getTickets();// 로또 개수
        // 로또 발행
        //String winningNumber = Console.readLine();// 당첨번호 6개 입력
        //String bonusNumber = Console.readLine();// 보너스번호 입력
        // 당첨내역 출력
        // 수익률 출력
        // 게임 종료
    }
}
