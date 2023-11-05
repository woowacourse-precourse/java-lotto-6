package lotto;

import java.util.HashMap;
import java.util.List;

public class Output {
    private static final String NUMBER_OF_PURCHAGE = "개를 구매했습니다.";

    public void printNumberOfPurchase(int lottoTicket) {
        System.out.println();
        System.out.println(lottoTicket + NUMBER_OF_PURCHAGE);
    }

    public void printRandomLottoNumbers(HashMap<Integer, List<Integer>> randomLottoNumbers) {
        for (int key : randomLottoNumbers.keySet()) {
            System.out.println(randomLottoNumbers.get(key));
        }
    }
}
