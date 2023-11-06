package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private static final Player player = new Player();
    private static final Map<Lotto, Float> lottos = new HashMap<Lotto, Float>();
    private static Float lottoReturns;

    public static void play() {
        inputLottoPurchaseAmount();
        issueLottos();
        printLottos();
        inputLottoWinningNumbers();
        inputLottoBonusNumber();
        confirmLottoWin();
        calculateLottoReturns();
    }

    private static void inputLottoPurchaseAmount() {
        while (true) {
            System.out.println("구매금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                player.setPurchaseAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구매 금액은 1,000원 단위의 숫자여야 합니다.");
            }
        }
    }

    private static void issueLottos() {
        int lottoCount = player.getPurchaseLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            lottos.put(new Lotto(getRandomNumbers()), 0.0f);
        }
    }

    private static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.NUMBERS_SIZE);
    }

    private static void printLottos() {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos.keySet()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void inputLottoWinningNumbers() {
        System.out.println();
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                player.setWinningNumbers(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
            }
        }
    }

    private static void inputLottoBonusNumber() {
        System.out.println();
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                player.setBonusNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 보너스 번호는 1부터 45 사이의 숫자이며, 당첨 번호에 포함되지 않아야 합니다.");
            }
        }
    }

    private static void confirmLottoWin() {
        for (Lotto lotto : lottos.keySet()) {
            compareWinningNumbers(lotto);
            compareBonusNumber(lotto);
            calculateLottoRankingCount(lotto);
        }
    }

    private static void calculateLottoRankingCount(Lotto lotto) {
        float lottoScore = lottos.get(lotto);
        if (lottoScore >= 3.0f) {
            LottoRanking.valueOfScore(lottos.get(lotto)).plusCount();
        }
    }

    private static void compareWinningNumbers(Lotto lotto) {
        for (int winningNumber : player.getWinningNumbers()) {
            if (lotto.containNumber(winningNumber)) {
                lottos.replace(lotto, lottos.get(lotto) + 1.0f);
            }
        }
    }

    private static void compareBonusNumber(Lotto lotto) {
        if (lotto.containNumber(player.getBonusNumber())) {
            lottos.replace(lotto, lottos.get(lotto) + 0.5f);
        }
    }

    private static void calculateLottoReturns() {
        int totalPrizeMoney = calculateTotalPrizeMoney();
        lottoReturns = totalPrizeMoney / player.getPurchaseAmount() * 100.0f;
    }

    private static Integer calculateTotalPrizeMoney() {
        int totalPrizeMoney = 0;

        for (LottoRanking lottoRanking : LottoRanking.values()) {
            totalPrizeMoney += lottoRanking.getPrizeMoney() * lottoRanking.getCount();
        }

        return totalPrizeMoney;
    }
}
