package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Phrase;
import lotto.model.dto.PlayerRequestDto;

public class InputView {
    public static PlayerRequestDto getLottoMoney() {
        System.out.println(Phrase.INPUT_LOTTO_MONEY.getPhrase());
        return new PlayerRequestDto(Console.readLine());
    }
}
