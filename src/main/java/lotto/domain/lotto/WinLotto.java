package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.etc.BounsNumber;
import lotto.utils.Prints;

public class WinLotto {
    private static Lotto lotto;
    private static BounsNumber bounsNumber;

    public BounsNumber getBonusNumber() {
        return bounsNumber;
    }

    public void createLotto() {
        try {
            Prints.INPUT_WINLOTTO.show();
            lotto = new Lotto(inputWinNumber());
            lotto.lottoByDuplicateNumber();
            lotto.lottoByRange();
        } catch (IllegalArgumentException e) {
            Prints.SHOW_ERROR_MSG.showFormat(e.getMessage());
            createLotto();
        }

    }

    public void createBonusNumber() {
        Prints.INPUT_BONUSNUMBER.show();
        bounsNumber = new BounsNumber(inputBonusNumber());
        bounsNumber.bonusnumNyRange();
        lotto.numberByContains(bounsNumber.getBounsNumber());
    }

    private List<Integer> inputWinNumber() {
        try {
            return Arrays.stream(Console.readLine().split(","))
                           .map(e -> Integer.parseInt(e))
                           .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(",로 구분하여 입력해주세요.");
        }
    }

    private int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public boolean contains(Integer number) {
        return lotto.contains(number);
    }
}
