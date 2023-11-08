package lotto;

import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Model.LottoWinningResult.LottoWinningResult;
import lotto.Service.LottoResultService.LottoResultVerifier;
import lotto.Service.LottoTicketService.LottoTicketService;

public class Application {


    public static void main(String[] args) {
        LottoTicketService number = new LottoTicketService();
        LottoResultVerifier resultVerifier = new LottoResultVerifier();

        LottoSet lottoList = number.GenerateLottoSet();


        // 생성된 로또 번호 출력
        for (Lotto lotto : lottoList.getLottoSet()) {
            System.out.print("로또번호 : ");
            for (Integer a : lotto.getNumbers()) {
                System.out.print(a + ",");
            }
            System.out.println();
        }

        LottoWinningResult result = resultVerifier.findWinningLotto(lottoList);

        System.out.println(result);


    }

}
