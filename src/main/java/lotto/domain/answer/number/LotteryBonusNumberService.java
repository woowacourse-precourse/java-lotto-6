package lotto.domain.answer.number;

import camp.nextstep.edu.missionutils.Console;

public class LotteryBonusNumberService {
    public Integer getBonusAnswer() {
        boolean sucess = false;
        String bonusInput = null;
        while (!sucess) {
            bonusInput = Console.readLine();
            try {
                LottoAnswerValidator.validateBonusInput(bonusInput);
                sucess = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return LottoAnswerMapper.mapToBonus(bonusInput);
    }
}
