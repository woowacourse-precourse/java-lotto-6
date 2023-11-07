package lotto.view.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.validation.Validation;
import lotto.view.Inputable;
import lotto.view.Outputable;
import lotto.view.View;

public class LottoBuyView extends View implements Inputable, Outputable{
    private final static String moneyInputText = "구입금액을 입력해 주세요.";
    private final static String outputText = "개를 구매했습니다.";

    private final static String DELIMITER = ", ";
    private final static String BEGIN_MARKER = "[";
    private final static String END_MARKER = "]";

    private Validation moneyValidation;

    public LottoBuyView(Validation moneyValidation) {
        this.moneyValidation = moneyValidation;
    }

    @Override
    public Object inputView() {
        printView(moneyInputText);

        String money = Console.readLine();
        moneyValidation.validate(money);

        return new Money(money);
    }

    @Override
    public void outputView(Object obj) {
        if (obj instanceof Lottos lottos){
            lottoCountView(lottos.getLottoCount());
            return;
        }

        throw new IllegalArgumentException("asd");
    }

    private static void lottoCountView(Integer lottoCount) {
        printView(lottoCount + outputText);
    }

}
