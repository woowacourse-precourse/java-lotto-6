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

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();

        WinningResult result = calculateWinningResult(lottos, winningLotto, bonusNumber);
        printResult(result, lottos.size());
        printEarningsRate(result, lottos.size());
    }

    private static List<Lotto> buyLottos() {
        int lottoCount = getLottoCount();
        return generateLottos(lottoCount);
    }

    private static int getLottoCount() {
        int amount = getInputAmount();
        validateAmount(amount);
        return amount / 1000;
    }

    private static int getInputAmount() {
        System.out.print("구입금액을 입력해 주세요: ");
        String input = Console.readLine();
        while (isNotNumeric(input)) {
            System.out.println("[ERROR] 잘못된 입력입니다. 숫자를 입력해주세요.");
            System.out.print("구입금액을 입력해 주세요: ");
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
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

    private static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static Lotto getWinningLotto() {
        System.out.print("당첨 번호를 입력해 주세요: ");
        try {
            String input = Console.readLine();
            List<Integer> winningNumbers = parseNumbers(input);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private static int getBonusNumber() {
        while (true) {
            try {
                System.out.print("보너스 번호를 입력해 주세요: ");
                int bonusNumber = Integer.parseInt(Console.readLine());
                Lotto.validateBonusNumber(bonusNumber);  // 유효성 검사를 수행
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private static WinningResult calculateWinningResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchNumbers(winningLotto);
            boolean matchBonus = lotto.contains(bonusNumber);
            result.addWinningTicket(matchCount, matchBonus);
        }
        return result;
    }

    private static void printResult(WinningResult result, int lottoCount) {
        result.printResult();
    }

    private static void printEarningsRate(WinningResult result, int lottoCount) {
        double earningsRate = calculateEarningsRate(result, lottoCount);
        System.out.println("총 수익률은 " + (earningsRate * 100) + "%입니다.");
    }

    private static double calculateEarningsRate(WinningResult result, int lottoCount) {
        long totalPrize = calculateTotalPrize(result);
        long investMoney = calculateInvestMoney(lottoCount);
        return (double) totalPrize / investMoney;
    }

    private static long calculateTotalPrize(WinningResult result) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            totalPrize += rank.getWinningMoney() * result.getCount(rank);
        }
        return totalPrize;
    }

    private static long calculateInvestMoney(int lottoCount) {
        return 1000 * lottoCount;
    }
}