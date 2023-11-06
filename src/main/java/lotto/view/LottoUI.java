package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validate.LottoValidator;

import java.util.List;

public class LottoUI {
    public static int getPurchaseAmount() {
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                return LottoValidator.validatePurchaseAmount(Console.readLine());
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }


}
