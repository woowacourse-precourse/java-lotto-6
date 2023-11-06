package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_BUY_COST = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    private final List<String> lottoWinningNums = new ArrayList<>();

    public String InputBuyCost() {
        System.out.println(INPUT_BUY_COST);
        return Console.readLine();
        // 예외 처리
    }

    public List<String> InputLottoWinningNums() {
        System.out.println(INPUT_LOTTO_NUMS);
        return SplitLottoWinningNums(Console.readLine());
    }

    public String InputBonusNum() {
        System.out.println(INPUT_BONUS_NUM);
        return Console.readLine();
        //예외 처리
    }

    public List<String> SplitLottoWinningNums(String lottoNums) {
        String[] numResult = lottoNums.split(",");
        lottoWinningNums.addAll(Arrays.asList(numResult));

        return lottoWinningNums;
    }
}
