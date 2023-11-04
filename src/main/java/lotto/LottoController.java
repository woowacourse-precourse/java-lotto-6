package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;

public class LottoController {

    public static void main(String[] args) {

        LottoFunction lottoFunction = new LottoFunction();

        int amount;

        System.out.println(Print.priceRequest);

        amount = lottoFunction.divideThousand(Console.readLine());

        System.out.println(String.format(Print.amount, amount) + "\n");

        List<Lotto> lottos = lottoFunction.buyLotto(amount);

        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }

        System.out.println(Print.lottoNumberRequest);
        HashSet<Integer> LuckyNumbers = lottoFunction.getLuckyNumbers(Console.readLine());

        System.out.println(LuckyNumbers);

        System.out.println(Print.bonusNumberRequest);
        String Number = Console.readLine();


    }


}
