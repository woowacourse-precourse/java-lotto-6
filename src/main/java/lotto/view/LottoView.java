package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import lotto.model.Lotto;

public class LottoView {

    // 로또 구입 금액 입력 받기
    public static Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        return price;
    }

    // 로또 구매 결과 출력
    public static void printPurchaseResult(List<Lotto> lottoList) {
        System.out.println();
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 로또 당첨 번호 입력 받기
    public static String inputWinningNumber() {
        System.out.println();
        System.out.println("당첨번호를 입력해 주세요.");
        return Console.readLine();
    }


}
