package lotto.view.component.input;

import lotto.view.component.Component;

public final class InputMoneyComponent implements Component {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    @Override
    public String render() {
        return INPUT_PRICE_MESSAGE;
    }
}
