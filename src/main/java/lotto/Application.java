package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = getLottoPurchasePrice();
        System.out.println("\n" + money / 1000 + "개를 구매했습니다.");

        ArrayList<Lotto> lottos = makeLottery(money);
        printLottoNumbers(lottos);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        //int[] winningNumbers = receiveWinningNumbers(Console.readLine());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        //int bonusNumber = Integer.parseInt(Console.readLine());

        //HashMap<LottoRank, Integer> matchCountByRank = getMatchCountByRank(lottos, winningNumbers, bonusNumber);
    }

    public static int getLottoPurchasePrice() {
        int money;
        while (true) {
            try {
                String str = Console.readLine();
                if (!str.matches("^[0-9]*$")) throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
                money = Integer.parseInt(str);
                if (money % 1000 != 0)  throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 구매할 수 있습니다.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public static ArrayList<Lotto> makeLottery(int money) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static int[] receiveWinningNumbers(String str) {
        int[] winningNumbers = Arrays.stream(str.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        return winningNumbers;
    }

    public static void printLottoNumbers(ArrayList<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = Arrays.asList(lotto.getNumbers().toArray(new Integer[0]));
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
}
