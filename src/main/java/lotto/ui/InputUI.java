package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author 민경수
 * @description input ui
 * @since 2023.11.04
 **********************************************************************************************************************/
public class InputUI {

    public int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

}