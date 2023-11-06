package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Application.LOTTO_PRICE;

public class Validation {

    public void price(int userPurchaseAmount) {
        if (userPurchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원 입니다. 1,000원 단위로 다시 입력해주세요.");
        }
    }

    public void duplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다. 다시 입력해주세요.");
        }
    }
}
