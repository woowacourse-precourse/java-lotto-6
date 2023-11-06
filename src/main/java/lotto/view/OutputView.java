package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class OutputView {

    public static void printPurchaseHistory(List<Lotto> list) {
        print(String.format("%d개를 구매했습니다.", list.size()));
        for (Lotto lotto : list) {
            List<LottoNumber> lottoNumbers = lotto.toIntegerList();
            print(lottoNumbers.stream().map(LottoNumber::getNumber).sorted().toList().toString());
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
