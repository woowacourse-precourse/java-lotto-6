package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumberDTO;

import static lotto.CommonUnits.*;

public class Inputter {
    private static Inputter inputter;

    private Inputter() {}

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

    public int purchase() {
        int won;

        System.out.println("구입금액을 입력해 주세요.");
        won = parseInt(Console.readLine());
        System.out.println();
        return won;
    }

    public LottoNumberDTO lottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return new LottoNumberDTO(Arrays.stream(Console.readLine().split(","))
                .mapToInt(this::parseInt).boxed().collect(Collectors.toList()));
    }

    public int bonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return parseInt(Console.readLine());
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.");
        }
    }
}
