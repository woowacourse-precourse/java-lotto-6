package lotto.view.impl;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.Inputable;
import lotto.view.Outputable;
import lotto.view.View;

public class LottoBuyView extends View implements Inputable, Outputable{
    private final static String moneyInputText = "구입금액을 입력해 주세요.";
    private final static String outputText = "개를 구매했습니다.";

    private final static String DELIMITER = ", ";
    private final static String BEGIN_MARKER = "[";
    private final static String END_MARKER = "]";

    @Override
    public Object inputView() {
        printView(moneyInputText);
        return new Money(Console.readLine());
    }

    @Override
    public void outputView(Object obj) {
        if (obj instanceof Lottos lottos){
            lottoCountView(lottos.getLottoCount());
            lottoNumberView(lottos);
        }

    }

    private static void lottoCountView(Integer lottoCount) {
        printView(lottoCount + outputText);
    }

    private static void lottoNumberView(Lottos lottos) {
        for (Lotto lotto : lottos) {
            printView(buildLottoNumberView(lotto));
        }
    }

    private static String buildLottoNumberView(Lotto lotto) {
        List<String> strList = convertIntListToStringList(lotto);
        return BEGIN_MARKER + String.join(DELIMITER, strList) + END_MARKER;
    }

    private static List<String> convertIntListToStringList(Lotto lotto){
        return lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

}
