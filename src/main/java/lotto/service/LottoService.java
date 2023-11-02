package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Lotto.MAX;
import static lotto.domain.Lotto.MIN;
import static lotto.domain.Lotto.NUMBER_LENGTH;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Game;
import lotto.domain.Lotto;

public class LottoService {

    public Integer readPurchasePrice() {
        String errorMessage = "[ERROR] 로또 구입 금액은 1,000원 단위의 숫자여야 합니다.";

        Integer result;
        try {
            result = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }

        if (validatePurchasePrice(result)) {
            throw new IllegalArgumentException(errorMessage);
        }

        return null;
    }

    boolean validatePurchasePrice(Integer price) {
        if (price < 1000 || price % 1000 != 0) {
            return false;
        }

        return true;
    }

    public List<Integer> readWinningNumbers() {
        String errorMessage = "[ERROR] 당첨 번호는 1부터 45 사이의 중복되지 않는 숫자여야 합니다.";

        List<Integer> result;
        try {
            result = convertStringToIntegerList(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }

        return result;
    }

    private List<Integer> convertStringToIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        String[] fragments = readLine().split(",");
        for (String fragment : fragments) {
            result.add(Integer.parseInt(fragment));
        }

        return result;
    }

    public Integer readBonusNumber() {
        String errorMessage = "[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 숫자여야 합니다.";

        Integer result;
        try {
            result = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }

        return result;
    }

    public List<Lotto> issueLotto(Integer purchasePrice) {
        List<Lotto> result = new ArrayList<>();
        for(int i = 0; i < purchasePrice / 1000; i++) {
            result.add(new Lotto(pickUniqueNumbersInRange(MIN, MAX, NUMBER_LENGTH)));
        }
        return result;
    }

    public void printResult() {

    }
}
