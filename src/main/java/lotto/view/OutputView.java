package lotto.view;


import java.util.List;
import lotto.constants.Config;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

public class OutputView {
    public void printGeneratedLottos(LottoMachine lottoMachine) {
        long lottoCount = lottoMachine.getInputAmount() / Config.LOTTO_PRICE;
        System.out.println(lottoCount+"개를 구매했습니다.");
        List<Lotto> lottos = lottoMachine.getLottos();
        lottos.forEach(System.out::println);
        System.out.println();
    }
}
