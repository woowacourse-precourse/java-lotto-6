package lotto.v3.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.v2.util.LottoValidationUtilsV2;

import java.util.List;

public class LottoBonusNumberView {
    public int requestBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return parseBonusNumber(Console.readLine(), winningNumbers);
    }

}
