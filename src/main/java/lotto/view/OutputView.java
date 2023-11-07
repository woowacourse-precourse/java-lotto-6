package lotto.view;

import java.util.List;

public class OutputView {
    public static void requestMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printAmountLotto(int amount){
        System.out.printf("\n%d개를 구매했습니다.\n", amount);
    }

    public static void printLottoList(List<List<Integer>> lottoNumbersList){
        for(List<Integer> lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }
}
