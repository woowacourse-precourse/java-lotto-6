package view;

import camp.nextstep.edu.missionutils.Console;

public class LottoBonusNumberInputView {
    final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public int readLottoBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        String bonusNumber = Console.readLine();
        int bonusNumberValue = Integer.parseInt(bonusNumber);
        return bonusNumberValue;
    }
}
