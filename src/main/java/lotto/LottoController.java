package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int quantity;
        LottoFunction lottoFunction = new LottoFunction();
        LuckyNumber luckyNumber = new LuckyNumber();
        Print print = new Print();

        System.out.println(Print.priceRequest);
        quantity = lottoFunction.getQuantity(Console.readLine());
        System.out.println(String.format(Print.quantity, quantity) + "\n");

        List<Lotto> lottos = lottoFunction.buyLotto(quantity);
        print.lottoNumber(lottos);

        System.out.println(Print.lottoNumberRequest);
        List<Integer> trimmedInput = lottoFunction.trimInput(Console.readLine());
        luckyNumber.getNumbers(trimmedInput);

        System.out.println(Print.bonusNumberRequest);
        luckyNumber.getBonusNumber(Console.readLine());

        List<Prize> prizes = lottoFunction.getPrizes(lottos, luckyNumber);
        print.analysis(quantity, prizes);


    }


}
