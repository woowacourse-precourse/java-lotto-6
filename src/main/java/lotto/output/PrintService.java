package lotto.output;

import java.util.List;
import java.util.Map;
import lotto.ListDataTypeConverter;

public class PrintService {

    public static void requestInputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestInputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void informPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void buyLottoNumbers(Map<Integer, List<Integer>> lottoNumbers) {
        for (Integer key : lottoNumbers.keySet()) {
            String lottoNumber = String.join(", ",
                ListDataTypeConverter.intergerToString(lottoNumbers.get(key)));
            System.out.printf("[ %s ]\n", lottoNumber);
        }
    }
}
