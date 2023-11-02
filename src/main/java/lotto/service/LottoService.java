package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    public Integer readPurchasePrice() {
        Integer result;
        try {
            result = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위의 숫자여야 합니다.");
        }

        if (validatePurchasePrice(result)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위의 숫자여야 합니다.");
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
        return null;
    }

    public Integer readBonusNumber() {
        return null;
    }

    public List<Lotto> issueLotto(Integer purchasePrice) {
        return null;
    }

    public void printResult() {

    }
}
