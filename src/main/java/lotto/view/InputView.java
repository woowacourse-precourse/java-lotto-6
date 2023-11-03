package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Phrase;
import lotto.model.dto.MoneyRequestDto;

public class InputView {
    public static MoneyRequestDto getLottoMoney() {
        System.out.println(Phrase.INPUT_LOTTO_MONEY.getPhrase());
        return new MoneyRequestDto(Console.readLine());
    }
}
