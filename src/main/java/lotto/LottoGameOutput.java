package lotto;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class LottoGameOutput {
    public void printLottoAmount(int amount){
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottoList();
        for (Lotto lotto : lottoList) {
            String numbers = lotto.getNumbers().toString();
            System.out.println(String.join(", ", numbers));
        }
    }

    public void printLottoResult(LottoResult lottoResult, double profit) {
        for(String str: lottoResult.getResultStrings()){
            System.out.println(str);
        }
        DecimalFormat df = new DecimalFormat("0.0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("총 수익률은 "+ df.format(profit) +"%입니다.");
    }
}
