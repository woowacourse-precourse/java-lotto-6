package lotto.view;

import lotto.domain.Lotto;
import lotto.util.Constant;

import java.text.MessageFormat;
import java.util.List;

public class OutputView {

    public void printResult(Integer lottoNum){
        System.out.println(MessageFormat.format(Constant.LOTTO_AMOUNT, lottoNum));
    }

    public void printLottos(List<Lotto> lottos){
        lottos.forEach(lotto ->
            System.out.println(lotto.getNumbers().toString()));
    }
}
