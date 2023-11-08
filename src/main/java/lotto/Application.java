package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int lottoAmount = askAmount();
            List<Lotto> lottos = issueLotto(lottoAmount / 1000);
            printLottos(lottos);
            Lotto winningLotto = askWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = -1;
        try {
            amount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        return amount;
    }

    public static List<Lotto> issueLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static Lotto askWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] splited = Console.readLine().split(",");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : splited) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
        return new Lotto(numbers);
    }

}
