package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

public class LottoView {
    public String inputMoney() {
        System.out.println(Message.INPUT_MONEY_MESSAGE.getValue());
        return Console.readLine();
    }

    public void outputLottos(List<Lotto> lottos, int lottoCount) {
        System.out.println();
        System.out.println(String.format(Message.OUTPUT_LOTTO_BUY.getValue(), lottoCount));
        for (Lotto l : lottos)
            System.out.println(l.getNumbers());
        System.out.println();
    }

    public String inputWinningNumber() {
        System.out.println(Message.INPUT_WINNIG_NUMBER_MESSAGE.getValue());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER_MESSAGE.getValue());
        return Console.readLine();
    }

    public void outputStatisticsResult(List<Integer> matches, double rate) {
        System.out.println();
        System.out.println(String.format(Message.OUTPUT_WIN_COUNT.getValue(), matches.get(0), matches.get(1), matches.get(2), matches.get(3), matches.get(4)));
        System.out.println(String.format(Message.OUTPUT_STATISTICS.getValue(), rate));
    }

    public void outputError(String errorMsg) {
        System.out.println(errorMsg);
    }
}
