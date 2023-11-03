package lotto;
import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 이력해 주세요.");
        Price price = new Price(Integer.parseInt(Console.readLine()));
        int size = price.countLotto(price);
        System.out.println(size + "개를 구매했습니다.");

        Lotto[] lottos = Lotto.makeLottoNumbers(size);
        Lotto.printLottos(lottos);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        Lotto lotto = makeLotto(input);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        Lotto.compareTo(lottos, lotto, bonusNumber);

        printResult();
    }

    public static Lotto makeLotto(String input) {
        List<Integer> numbers = new ArrayList<>();
        for(String n : input.split(",")) {
            numbers.add(Integer.parseInt(n));
        }
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public static void printResult() {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + Ranks.FIFTH.amount + "개");
        System.out.println("4개 일치 (50,000원) - " + Ranks.FOURTH.amount + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Ranks.THIRD.amount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Ranks.SECOND.amount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Ranks.FIRST.amount + "개");
    }


}
