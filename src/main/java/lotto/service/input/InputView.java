package lotto.service.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.input.GetWinningNumberDto;
import lotto.util.validate.Validator;

public class InputView implements Input{
    @Override
    public GetLottoCountDto getLottoBuyMoney() {
        return new GetLottoCountDto(
                Validator.checkBuyMoney(
                        getMoneyReadLine()
                )
        );
    }

    @Override
    public GetWinningNumberDto getWinningNumber() {
        return new GetWinningNumberDto(
                Validator.checkWinningNumbers(
                        getWinningNumbersReadline()
                )
        );
    }

    @Override
    public GetBonusNumberDto getBonusNumber(GetWinningNumberDto getWinningNumberDto) {
        return new GetBonusNumberDto(
                Validator.checkBonusNumber(
                        getWinningNumberDto,
                        getBonusNumberReadline()
                )
        );
    }

    private static String getMoneyReadLine() {
        return Console.readLine();
    }

    private static String getWinningNumbersReadline(){
        return Console.readLine();
    }

    private static String getBonusNumberReadline(){
        return Console.readLine();
    }
}
