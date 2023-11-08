package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구매금액을 입력해 주세요.");
        int buyMoney = Integer.parseInt(Console.readLine());
        int count = buyMoney / 1000;
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            System.out.println(lotto);
        }
        //당첨번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] selectNumbers = Console.readLine().split(",");
        Set<Integer> winningNumberSet = new TreeSet<>();
        for (String selectNumber : selectNumbers) {
            winningNumberSet.add(Integer.parseInt(selectNumber.trim()));
        }
        //보너스 번호
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        winStatistic(lottos, winningNumberSet, bonusNumber, buyMoney);
        Console.close();
    }
}
