package lotto.view.component.input;

import lotto.view.component.Component;

public final class InputBonusNumberComponent implements Component {
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    @Override
    public String render() {
        return INPUT_BONUS_NUMBER_MESSAGE;
    }
}
