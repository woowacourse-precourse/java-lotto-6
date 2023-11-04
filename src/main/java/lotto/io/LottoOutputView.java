package lotto.io;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;

public class LottoOutputView {

    public void printLottoPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
