package lotto.service.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.input.GetWinningNumberDto;
import lotto.util.message.Printer;
import lotto.util.validate.Validator;

public class InputView implements Input{
    @Override
    public GetLottoCountDto getLottoBuyMoney() {
        Printer.askBuyMoney();
        return new GetLottoCountDto(
                Validator.checkBuyMoney(
                        getMoneyReadLine()
                )
        );
    }

    @Override
    public GetWinningNumberDto getWinningNumber() {
        Printer.askWinningNumber();
        return new GetWinningNumberDto(
                Validator.checkWinningNumbers(
                        getWinningNumbersReadline()
                )
        );
    }

    @Override
    public GetBonusNumberDto getBonusNumber(GetWinningNumberDto getWinningNumberDto) {
        Printer.askBonusNumber();
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
