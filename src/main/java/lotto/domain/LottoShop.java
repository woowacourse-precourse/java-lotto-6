package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.dto.response.LottiesInfoDto;

public class LottoShop {
    public LottiesInfoDto sellLotties(int money) {
        int ticket = money / ConstantValue.THOUSAND;
        List<List<Integer>> numbers = createNumbers(ticket);
        return new LottiesInfoDto(ticket, numbers);
    }

    private List<List<Integer>> createNumbers(int tickets) {
        List<List<Integer>> numbers = new ArrayList<>();
        for (int a = 0; a < tickets; a++) {
            numbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return numbers;
    }
}
