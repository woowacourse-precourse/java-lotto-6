package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Lotto.MAX;
import static lotto.domain.Lotto.MIN;
import static lotto.domain.Lotto.NUMBER_LENGTH;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.ResultCode;

public class LottoService {

    public Integer readPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String errorMessage = "[ERROR] 로또 구입 금액은 1,000원 단위의 숫자여야 합니다.";

        try {
            Integer result = Integer.parseInt(readLine());
            if (!validatePurchasePrice(result)) {
                throw new IllegalArgumentException(errorMessage);
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    boolean validatePurchasePrice(Integer price) {
        if (price < 1000 || price % 1000 != 0) {
            return false;
        }

        return true;
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String errorMessage = "[ERROR] 당첨 번호는 1부터 45 사이의 중복되지 않는 숫자여야 합니다.";

        try {
            return convertStringToIntegerList(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private List<Integer> convertStringToIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        String[] fragments = input.split(",");
        for (String fragment : fragments) {
            result.add(Integer.parseInt(fragment));
        }

        return result;
    }

    public Integer readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String errorMessage = "[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 숫자여야 합니다.";

        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public List<Lotto> issueLotto(Integer purchasePrice) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < purchasePrice / 1000; i++) {
            result.add(new Lotto(pickUniqueNumbersInRange(MIN, MAX, NUMBER_LENGTH)));
        }
        return result;
    }

    public void printLottoCount(Integer count) {
        System.out.printf("%d개를 구매했습니다.", count);
        System.out.println();
    }

    public void printLotto(Lotto lotto) {
        System.out.printf("%s", lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
        System.out.println();
    }

    public void printResult(Map<ResultCode, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(ResultCode.values())
                .forEach(v -> printSingleResult(v, resultMap.getOrDefault(v, 0)));
    }

    private void printSingleResult(ResultCode resultCode, Integer value) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

        System.out.printf("%d개 일치", resultCode.matchCount);
        if (resultCode.bonusMatch) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.printf(" (%s원) - %d개", numberFormat.format(resultCode.prize), value);
        System.out.println();
    }

    public void printProfitability(double profitability) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitability);
    }
}
