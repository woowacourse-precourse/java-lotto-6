package lotto.service.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetLottoBuyMoneyDto;
import lotto.dto.input.GetWinningNumberDto;

public class InputView implements Input{
    @Override
    public GetLottoBuyMoneyDto getLottoBuyMoney() {
        Integer money = getMoney();
        if(money%1000 != 0){
            throw new IllegalArgumentException("구입 금액 단위는 천원 단위여야 합니다.");
        }
    }

    private static Integer getMoney() {
        try{
            return Integer.valueOf(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }

    @Override
    public GetWinningNumberDto getWinningNumber() {
        return null;
    }

    @Override
    public GetBonusNumberDto getBonusNumber() {
        return null;
    }
}
