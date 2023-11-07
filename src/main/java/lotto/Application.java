package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 구매를 위해 돈을 지불한다.
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal pay = new BigDecimal(readLine().trim());
        validatePayedMoney(pay);

        // 로또를 구매한다.
        BigDecimal count = pay.divide(BigDecimal.valueOf(1000));
        System.out.println(count + "개를 구매했습니다.");
        List<RandomLotto> randomLottos = drawLotto(count.intValue());
        printRandomLotto(randomLottos);

        // 당첨번호를 입력받는다.
        System.out.println("당첨 번호를 입력해 주세요");
        String[] numbers = readLine().trim().split(",");
        Lotto lotto = new Lotto(arrayToListNumbers(numbers));

        // 보너스 번호를 입력받는다.
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = readLine().trim();
        Integer bonusNumber = stringToInteger(bonus);
        validateBonusNumber(bonusNumber, lotto);

        // 결과를 출력한다.
        System.out.println("당첨 통계");
        System.out.println("---");

        List<Integer> lottoResults = Lotto.checkLottoNumber(lotto, randomLottos);
        List<Boolean> bonusNumberResults = Lotto.checkBonusNumber(randomLottos, bonusNumber);
        if (lottoResults.size() != bonusNumberResults.size()) {
            throw new RuntimeException("[ERROR] 로또번호 확인 중 에러가 발생했습니다.");
        }


        List<Result> results = new ArrayList<>();

        for (int i = 0; i < lottoResults.size(); i++) {
            Result result = Result.getResult(lottoResults.get(i), bonusNumberResults.get(i));
            results.add(result); // nullable
        }

        BigDecimal prize = BigDecimal.ZERO;
        for (Result result : Result.values()) {
            int matchCount = Collections.frequency(results, result);
            System.out.println(result.getDescription() + "(" + result.getPrizeMoney() + ")" + " - " +
                    matchCount  + "개");

            prize = prize.add(result.getPrizeMoney().multiply(BigDecimal.valueOf(matchCount)));
        }

        BigDecimal profitRate = calculateProfitPercentage(prize, pay);
        System.out.println("총 수익률은 "+ profitRate + "%입니다.");

    }

    private static void validateBonusNumber(Integer bonus, Lotto lotto) {
        if (!Lotto.isLottoRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.\n");
        }

        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복을 허용하지 않습니다.");
        }
    }

    private static List<Integer> arrayToListNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Application::stringToInteger)
                .collect(Collectors.toList());
    }

    private static int stringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 로또 번호는 숫자만 입력가능합니다.\n");
        }
    }

    private static List<RandomLotto> drawLotto(int count) {
        List<RandomLotto> randomLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomLotto); // 숫자들을 오름차순으로 정렬
            randomLottos.add(new RandomLotto(randomLotto));
        }

        return randomLottos;
    }

    private static void printRandomLotto(List<RandomLotto> randomLottos) {
        for (RandomLotto randomLotto : randomLottos) {
            System.out.println(randomLotto.getRandomNumbers());
        }
    }


    private static BigDecimal calculateProfitPercentage(BigDecimal prizeMoney, BigDecimal pay) {
        BigDecimal percentage = (prizeMoney.subtract(pay)).divide(pay);
        return percentage.setScale(2, RoundingMode.HALF_UP);
    }
    private static void validatePayedMoney(BigDecimal pay) {
        if (!pay.remainder(BigDecimal.valueOf(1000)).equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위이어야 합니다.\n");
        }
    }
}
