package lotto.domain.answer.number;

import camp.nextstep.edu.missionutils.Console;

public class LotteryBonusNumberService {
    public Integer getBonusAnswer() {
        boolean sucess = false;
        String bonusInput = null;
        while (!sucess) {
            bonusInput = Console.readLine();
            sucess = isValidBonus(sucess, bonusInput);
        }
        return LottoAnswerMapper.mapToBonus(bonusInput);
    }

    private boolean isValidBonus(boolean sucess, String bonusInput) {
        try {
            LottoAnswerValidator.validateBonusInput(bonusInput);
            sucess = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return sucess;
    }
}
