package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyingLotto {

    static private int money; // 구입금액
    static private int lottoNumber; // 로또 몇 장인지

    static private List<Lotto> totalLotto = new ArrayList<Lotto>(); // 구입한 모든 로또
    static private String input;
    static void gettingInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        input = Console.readLine();
        money = Integer.parseInt(input);
        validateInput();
    }

    static void validateInput() {
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            } else if (money < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gettingInput();
        }
    }

    static void givingLotto() {
        lottoNumber = money / 1000;
        for (int i = 0; i < lottoNumber; i++) {
            List<Integer> numbers = randomLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            totalLotto.add(lotto);
        }
    }

    static List<Integer> randomLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    static void printingLotto() {
        System.out.println(String.format("%d개를 구매했습니다.", lottoNumber));
        for (Lotto lotto: totalLotto) {
            System.out.println(lotto.getNumbers());
        }
    }


    static public int getMoney() {
        return money;
    }

    static public void setMoney(int money) {
        money = money;
    }
}
