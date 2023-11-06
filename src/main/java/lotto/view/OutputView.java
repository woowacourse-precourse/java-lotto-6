package lotto.view;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printRequestPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoQuantity(int quantity){
        System.out.println(quantity+"개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            Object[] lottoNumber = lotto.getNumbers().toArray();
            System.out.println(Arrays.toString(lottoNumber));
        }
    }

    public static void printRequestWinnerNumberMessage(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumberMessage(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
