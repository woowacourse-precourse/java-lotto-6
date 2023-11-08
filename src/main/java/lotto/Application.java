package lotto;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.startGame();
    }
}

class LottoGame {
    public static final int PRICE_PER_LOTTO = 1000;
    private final List<Lotto> lottos = new ArrayList<>();
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;
    private final List<Integer> prizeMoney = List.of(0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000);

    public void startGame() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = InputValidator.validateAmount(Console.readLine());
            buyLottos(purchaseAmount);
            System.out.println("당첨 번호를 입력해 주세요.");
            enterWinningNumbers(Console.readLine());
            System.out.println("보너스 번호를 입력해 주세요.");
            enterBonusNumber(Console.readLine());
            showResults();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void buyLottos(int amount) {
        int numberOfLottos = amount / PRICE_PER_LOTTO;
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        OutputView.printLottos(lottos);
    }

    private void enterWinningNumbers(String input) {
        winningNumbers.addAll(InputValidator.validateNumbers(input));
    }

    private void enterBonusNumber(String input) {
        bonusNumber = InputValidator.validateBonusNumber(input, winningNumbers);
    }

    private void showResults() {
        int[] matchCounts = new int[prizeMoney.size()];
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                matchCounts[7]++;
            } else {
                matchCounts[matchCount]++;
            }
        }
        OutputView.printResults(matchCounts, prizeMoney, lottos.size() * PRICE_PER_LOTTO);
    }
}

class InputValidator {
    public static int validateAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0 || amount % LottoGame.PRICE_PER_LOTTO != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 숫자가 아닙니다.");
        }
    }

    public static List<Integer> validateNumbers(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(number);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
        return numbers;
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(input.trim());
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자이며, 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }
}

class OutputView {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0");
    private static final DecimalFormat PROFIT_RATE_FORMAT = new DecimalFormat("0.00");

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printResults(int[] matchCounts, List<Integer> prizeMoney, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        int totalPrize = 0;
        for (int i = 3; i < matchCounts.length; i++) {
            String prizeFormat = DECIMAL_FORMAT.format(prizeMoney.get(i));
            String matchCountMessage = String.format("%d개 일치 (%s원) - %d개", i, prizeFormat, matchCounts[i]);
            if (i == 7) {
                matchCountMessage = "5개 일치, 보너스 볼 일치 (" + prizeFormat + "원) - " + matchCounts[i] + "개";
            }
            System.out.println(matchCountMessage);
            totalPrize += prizeMoney.get(i) * matchCounts[i];
        }
        double profitRate = (totalPrize / (double) purchaseAmount) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f",profitRate) + "%입니다.");
    }
}

