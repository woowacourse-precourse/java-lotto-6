package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구매금액을 입력해 주세요.");
        int buyMoney = Integer.parseInt(Console.readLine());
        int count = buyMoney/1000;
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            System.out.println(lotto);
        }
    }
}
