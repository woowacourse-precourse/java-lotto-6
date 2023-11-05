package lotto.io;

import static java.util.Collections.sort;

import java.util.Collections;
import java.util.List;

public class LottoOutputView {

    public void printLottoPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

}
