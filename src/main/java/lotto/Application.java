package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        /* 추가할 것 : 입력한 구입금액이 1000원으로 나누어 떨어지지 않을 경우 예외처리한다. */

        System.out.print("발행한 로또 수량 : ");
        int lottoTickets = purchaseAmount / 1000;
        System.out.println(lottoTickets);
    }
}
