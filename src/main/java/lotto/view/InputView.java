package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.dto.PlayerRequestDto;

import static lotto.constants.Phrase.INPUT_LOTTO_MONEY;
import static lotto.constants.Phrase.INPUT_LOTTO_PRIZE;

public class InputView {
    public static PlayerRequestDto getLottoMoney() {
        System.out.println(INPUT_LOTTO_MONEY.getPhrase());
        return new PlayerRequestDto(Console.readLine());
    }

    public static String getLottoPrize() {
        System.out.println("\n" + INPUT_LOTTO_PRIZE.getPhrase());
        return Console.readLine();
    }
}
