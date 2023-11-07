package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int price = Price.readPrice();
        int amount = Price.calculateAmount(price);
        System.out.println(amount + "개를 구매했습니다.");

        Lotto[] lottos = Create.createLottos(amount);
        Lotto.printLottos(lottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> inputNumbers = Lotto.readNumbers("", null);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        Lotto.compareTo(lottos, inputNumbers, bonusNumber);
        Ranks.printResult(price);
    }
}
