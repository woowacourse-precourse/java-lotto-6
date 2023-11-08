package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class UserView {

    public static String inputPaidAmount() {
        System.out.println("구입금액을 입력해 주세요.(천원 단위)");
        return Console.readLine();
    }


    public static void outputBuyLotto(List<Lotto> lottos) {
        System.out.println("\n"+ lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }


    public static String inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
