package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final List<Integer> prizeMoneys
            = new ArrayList<>(Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000));

    public static void main(String[] args) {
        int buyAmount = inputBuyAmount();

        List<Lotto> lottos = generateRandomLottoTickets(buyAmount);
        printLottoTickets(lottos);

//        LottoResult result = playLottoGame(lottos);
//        LottoResult result = new LottoResult();

        Lotto winningLotto = inputWinningNumbers();
        String bonusLottoNumber = inputBonusNumber(winningLotto);

        Map<Integer, Integer> matchCounts = new HashMap<>();
        for (int i = 3; i < 8; i++) {
            matchCounts.put(i, 0);
        }

        for (Lotto lotto : lottos) {
            int count = winningCheck(winningLotto.getNumbers(), lotto.getNumbers());
            List<Integer> bonusNumbers = new ArrayList<>();
            bonusNumbers.add(Integer.valueOf(bonusLottoNumber));
            if (count == 5 && winningCheck(bonusNumbers, winningLotto.getNumbers()) == 1) {
                count = 6;
            }
            matchCounts.put(count, matchCounts.getOrDefault(count, 0) + 1);
        }

        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (int i = 3; i < 8; i++) {
            if (i < 6) {
                System.out.println(i + "개 일치 (" + df.format(prizeMoneys.get(i)) + "원) - " + matchCounts.get(i) + "개");
            }
            if (i == 6) {
                System.out.println((i - 1) + "개 일치, 보너스 볼 일치 (" + df.format(prizeMoneys.get(i)) + "원) - " + matchCounts.get(i) + "개");
            }
            if (i == 7) {
                System.out.println((i - 1) + "개 일치 (" + df.format(prizeMoneys.get(i)) + "원) - " + matchCounts.get(i) + "개");
            }
        }

        double result = 0;
        // 수익률 확인
        for (int i = 3; i < 7; i++) {
            result += matchCounts.get(i) * prizeMoneys.get(i);
        }
        double profitPercentage = (result / buyAmount * 100.0);
        System.out.println("총 수익률은 " + String.format("%.1f%%", profitPercentage)+"입니다.");

//        printGameResults(result);
    }

    private static Lotto inputWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                List<Integer> winningNumbers = parseWinningNumbers(input);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        LottoGameValidator.validateWinningLottoNumber(input);

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void printGameResults(LottoResult result) {
    }

    private static int winningCheck(List<Integer> winningLottoNumber, List<Integer> randomLottoNumber) {
        int count = 0;
        for (Integer winningLotto : winningLottoNumber) {
            if (randomLottoNumber.contains(winningLotto)) {
                count++;
            }
        }
        return count;
    }

    public static LottoResult playLottoGame(List<Lotto> lottos) {
        LottoResult result = new LottoResult();
        Lotto winningLotto = inputWinningNumbers();
        String bonusLottoNumber = inputBonusNumber(winningLotto);

        return null;
    }

    private static String inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String inputWinningLottoNumber = Console.readLine();
                LottoGameValidator.validateBonusLottoNumber(inputWinningLottoNumber, winningLotto);
                return inputWinningLottoNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printLottoTickets(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Lotto> generateRandomLottoTickets(int buyAmount) {
        int buyLottoNumber = buyAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyLottoNumber; i++) {
            lottos.add(generateRandomLottoTicket());
        }
        return lottos;
    }

    public static Lotto generateRandomLottoTicket() {
        List<Integer> numbers = new ArrayList<>();
        int randomNumber;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            do {
                randomNumber = Randoms.pickNumberInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
            } while (numbers.contains(randomNumber));
            numbers.add(randomNumber);
        }
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    public static int inputBuyAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String inputBuyAmount = Console.readLine();
                LottoGameValidator.validateInputAmount(inputBuyAmount);
                return Integer.parseInt(inputBuyAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
