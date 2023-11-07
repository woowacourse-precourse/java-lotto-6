package lotto;

import java.util.List;

public class OutputView {

    void printPurchasedLottoQuantity(int count){
        System.out.println(String.format("%d개를 구매했습니다."));
    }

    void printLottoNumbers(List<List<Integer>> lottoNumbers){
        for(List<Integer> numbers: lottoNumbers){
            System.out.println(numbers);
        }
    }
}
