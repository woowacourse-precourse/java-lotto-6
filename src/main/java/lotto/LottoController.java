package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoController {
    LottoFunction lottoFunction = new LottoFunction();
    LuckyNumber luckyNumber = new LuckyNumber();
    Print print = new Print();
    int quantity;

    void run() {
        System.out.println(Print.priceRequest);
        quantity = lottoFunction.getQuantity(Console.readLine());
        System.out.println("\n" + String.format(Print.quantity, quantity));

        List<Lotto> lottos = lottoFunction.buyLotto(quantity);
        print.lottoNumber(lottos);

        System.out.println("\n" + Print.lottoNumberRequest);
        List<Integer> trimmedInput = lottoFunction.trimInput(Console.readLine());
        luckyNumber.getNumbers(trimmedInput);

        System.out.println("\n" + Print.bonusNumberRequest);
        luckyNumber.getBonusNumber(Console.readLine());

        List<Prize> prizes = lottoFunction.getPrizes(lottos, luckyNumber);
        print.analysis(quantity, prizes);
    }


}
