package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.WildcardType;
import lotto.Model.Lotto;
import lotto.Model.Price;
import lotto.Model.PriceValidator;
//import lotto.Model.WinningLottoValidator;

public class InputView {

    public static Price inputPriceForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String input = Console.readLine();
            return new Price(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPriceForLotto();
        }
    }

//        try {
//            PriceValidator priceValidator = new PriceValidator(Console.readLine());
//            return new Price(priceValidator.getInputPrice());
//        } catch (IllegalArgumentException e) {
//            System.out.println("[ERROR] 1000원 단위로 1000원~20억원 사이에서 입력해주세요. 예시) 3000");
//            return inputPriceForLotto();
//        }


//    public static Lotto inputWinningLotto() {
//        System.out.println("당첨 번호를 입력해 주세요.");
//
//
////        try {
////            WinningLottoValidator winningLottoValidator = new WinningLottoValidator(Console.readLine());
////            return new Lotto(winningLottoValidator.getWinningLotto());
////        } catch (IllegalArgumentException e) {
////            System.out.println("[ERROR] 숫자와 쉼표로만 당첨 번호를 입력해 주세요.");
////            return inputWinningLotto();
////        }
////    }
//
}
