package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) {
        System.out.println("구매금액을 입력해 주세요.");
        int buyMoney = Integer.parseInt(Console.readLine());
        int count = buyMoney/1000;
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            System.out.println(lotto);
        }
        //당첨번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] selectNumbers = Console.readLine().split(",");
        Set<Integer> numberList = new TreeSet<>();
        for (String selectNumber : selectNumbers){
            numberList.add(Integer.parseInt(selectNumber.trim()));
        }
        //보너스 번호
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());





    }
    static void winStatistic(List<Lotto> lottos, Set<Integer> numberList){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5000원)\n" +
                "4개 일치 (50000원)\n" +
                "5개 일치 (1,5000,000원)\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원)\n" +
                "6개 일치 (2,000,000,000원)\n" +
                "총 수익률은 62.5%입니다");

    }
}
