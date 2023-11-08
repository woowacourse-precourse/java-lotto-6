package lotto.Print;

import lotto.Lotto.Lotto;
import lotto.Lotto.LottoGame;
import lotto.Result.Result;
import lotto.Result.WinningResult;

import java.util.List;
import java.util.Map;

public class Print {

    //로또 구입 메세지 출력
    public static void printBuyLotto() {
        System.out.println(Message.INPUT_LOTTO_PRICE_MESSAGE);
    }

    //구입한 로또 개수와 번호 출력
    public static void printPaidLottoResult(List<Lotto> paidLottos,int lottoBuyCount){
        System.out.printf("\n"+Message.INFORM_LOTTO_COUNT_MESSAGE+"\n",lottoBuyCount);
        for(Lotto paidLotto : paidLottos){
            System.out.println(paidLotto.getNumbers());
        }
    }


}