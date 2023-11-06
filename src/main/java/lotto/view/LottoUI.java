package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validate.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoUI {
    public static int getPurchaseAmount() {
        int purchaseAmount;
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = LottoValidator.validatePurchaseAmount(Console.readLine());
                System.out.println();
                return purchaseAmount;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printRandomLottos(List<Lotto> lottos, int lottoCnt){
        System.out.println(lottoCnt+"개를 구매했습니다.");
        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
        System.out.println();
    }
}