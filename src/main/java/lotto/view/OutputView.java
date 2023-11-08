package lotto.view;


import lotto.model.LottoResult;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public static void printPurchaseAmountInputMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCountMessage(Integer lottoCount){
        System.out.printf("\n%d개를 구매했습니다.\n",lottoCount);
    }

    

}