package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {

    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;
    public static void main(String[] args) {
        List<Lotto> lottos = buyLottos();
        printLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
    }

    private static List<Lotto> buyLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = getLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static int getLottoCount() {
        while (true) {
            int amount = getInputAmount();
            if (amount % 1000 != 0) {
                System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
                continue;
            }
            return amount / 1000;
        }
    }

    private static int getInputAmount() {
        while (true) {
            System.out.println("로또 구입 금액을 입력하세요.");
            String input = Console.readLine();
            if (isNotNumeric(input)) {
                System.out.println("[ERROR] 잘못된 입력입니다. 숫자를 입력해주세요.");
                continue;
            }
            return Integer.parseInt(input);
        }
    }

    private static boolean isNotNumeric(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseNumbers(input);
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> parseNumbers(String input) {
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}