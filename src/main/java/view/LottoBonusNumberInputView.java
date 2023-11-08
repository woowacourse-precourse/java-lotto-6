package view;

import camp.nextstep.edu.missionutils.Console;
import validator.BonusNumberGeneratorValidator;

public class LottoBonusNumberInputView {
    final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    BonusNumberGeneratorValidator bonusNumberGeneratorValidator = new BonusNumberGeneratorValidator();

    public int readLottoBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        String bonusNumber = Console.readLine();
        while (true) {
            try {
                int bonusNumberValue = bonusNumberGeneratorValidator.vaildBonusNumber(bonusNumber);
                return bonusNumberValue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
