package lotto;

import java.util.List;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Service.LottoNumberService.LottoNumberService;
import lotto.Service.LottoTicketService.LottoTicketService;

public class Application {


    public static void main(String[] args) {
        LottoTicketService number = new LottoTicketService();
        LottoSet lottoList = number.GenerateLottoSet();

        // 생성된 로또 번호 출력
        for ( Lotto lotto : lottoList.getLottoSet()) {
            System.out.print("로또번호 : ");
            for( Integer a : lotto.getNumbers()) {
                System.out.print(a + ",");
            }
            System.out.println();
        }




    }

}
