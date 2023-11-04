package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        int lottoPrice = 1000;
        int parseMoney = 0;
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();

        System.out.println();

        if (money.isBlank()) {
            throw new IllegalStateException("[ERROR] 아무 것도 입력되지 않았습니다.");
        }

        try {
            parseMoney = Integer.parseInt(money);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR] 숫자 형식이 아닙니다.");
        }

        if (money.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 숫자입니다.");
        }

        if (parseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }

        int buyLottoCount = parseMoney / lottoPrice;

        System.out.println(buyLottoCount + "개를 구매했습니다.");

        ArrayList<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < buyLottoCount; i++) {
            Lotto lotto = new Lotto(makeLotto());
            lotties.add(lotto);
            System.out.println(lotto.getLotto().toString());
        }

        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumber = Console.readLine();

        System.out.println();

        if (winNumber.isBlank()) {
            throw new IllegalStateException("[ERROR] 아무 것도 입력되지 않았습니다.");
        }

        if (winNumber.charAt(0) == ',' || winNumber.charAt(winNumber.length() - 1) == ',') {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 숫자입니다.");
        }

        int[] winNumbers = Stream.of(winNumber.split(",")).mapToInt(Integer::parseInt).toArray();

        List<Integer> parseWinNumbers = Arrays.stream(winNumbers).boxed().collect(Collectors.toList());

        if (winNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumber = Console.readLine();
        int parseBounusNumber = Integer.parseInt(bonusNumber);

        System.out.println();

        if (bonusNumber.isBlank()) {
            throw new IllegalStateException("[ERROR] 아무 것도 입력되지 않았습니다.");
        }

        if (parseBounusNumber < 1 || parseBounusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
        }

        if (parseWinNumbers.contains(parseBounusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 다른 번호를 입력해주세요.");
        }

        int threeCorrect = 0;
        int fourCorrect = 0;
        int fiveCorrect = 0;
        int fiveBonusCorrect = 0;
        int sixCorrect = 0;
        int earnMoney = 0;
        boolean hasBonusNumber = false;
        for (int i = 0; i < lotties.size(); i++) {
            int correctCount = 0;
            Lotto lotto = lotties.get(i);
            for (int j = 0; j < lotto.getLotto().size(); j++) {
                if (lotto.getLotto().indexOf(parseWinNumbers.get(j)) != -1) {
                    correctCount++;
                }

                if (lotto.getLotto().contains(parseBounusNumber)) {
                    hasBonusNumber = true;
                }
            }

            if (correctCount == 3) {
                threeCorrect++;
                earnMoney += 5000;
            }

            if (correctCount == 4) {
                fourCorrect++;
                earnMoney += 50000;
            }

            if (correctCount == 5) {
                fiveCorrect++;
                earnMoney += 1500000;
            }

            if (correctCount == 5 && hasBonusNumber) {
                fiveBonusCorrect++;
                earnMoney += 30000000;
            }

            if (correctCount == 6) {
                sixCorrect++;
                earnMoney += 2000000000;
            }
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeCorrect + "개");
        System.out.println("4개 일치 (50,000원) - " + fourCorrect + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveCorrect + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusCorrect + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixCorrect + "개");

        double parseEarnMoney = (double) earnMoney;
        double rateOfReturn = parseEarnMoney / parseMoney * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }

    public static List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
