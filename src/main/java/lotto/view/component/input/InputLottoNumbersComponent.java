package lotto.view.component.input;

import lotto.view.component.Component;

public final class InputLottoNumbersComponent implements Component {
    private static final String INPUT_LOTTO_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";

    @Override
    public String render() {
        return INPUT_LOTTO_NUMBERS_MESSAGE;
    }

}
