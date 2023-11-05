package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.message.OutputMessage;
import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;

    public void outputPublishLottos(int inputPrice){
        int lottoCount = inputPrice / LOTTO_PRICE;
        System.out.println(String.format(OutputMessage.BUYING_RESULT, lottoCount));
    }

}
