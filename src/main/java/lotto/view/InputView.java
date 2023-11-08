package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoUtils;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> promptForWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        return LottoUtils.convertStringToLottoNumberList(input); // LottoUtils 메소드 사용
    }

    public int promptForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }
}
