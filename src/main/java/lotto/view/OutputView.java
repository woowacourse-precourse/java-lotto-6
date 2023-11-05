package lotto.view;

import java.util.List;

public class OutputView {

    public static void printGetPurchasePriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoNumMessage(int num) {
        System.out.println();
        StringBuilder lottoNum = new StringBuilder();
        lottoNum.append(num);
        lottoNum.append("개를 구매했습니다.");
        System.out.println(lottoNum);
    }

    public static void printLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }
}
