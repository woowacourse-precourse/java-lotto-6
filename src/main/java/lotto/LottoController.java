package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int quantity;
        LottoFunction lottoFunction = new LottoFunction();

        System.out.println(Print.priceRequest);
        quantity = lottoFunction.getQuantity(Console.readLine());
        System.out.println(String.format(Print.quantity, quantity) + "\n");

        List<Lotto> lottos = lottoFunction.buyLotto(quantity);

        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }

        System.out.println(Print.lottoNumberRequest);
        HashSet<Integer> luckyNumbers = lottoFunction.getLuckyNumbers(Console.readLine());

        System.out.println(Print.bonusNumberRequest);
        Integer bonusNumber = lottoFunction.getBonusNumber(Console.readLine(), luckyNumbers);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.compare(luckyNumbers, bonusNumber));
        }


    }


}
