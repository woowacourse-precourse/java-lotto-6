package lotto;

import java.util.HashMap;
import java.util.List;

public class Output {
    private static final String NUMBER_OF_PURCHAGE = "개를 구매했습니다.";

    public void printNumberOfPurchase(int lottoTicket) {
        System.out.println("\n" + lottoTicket + NUMBER_OF_PURCHAGE);
    }

    public void printRandomLottoNumbers(int lottoTicket) {
        LottoGenerate lottoGenerate = new LottoGenerate();

        HashMap<Integer, List<Integer>> result = lottoGenerate.getRandomLottoResult(lottoTicket);

        for (int key : result.keySet()) {
            System.out.println(result.get(key));
        }
    }
}
