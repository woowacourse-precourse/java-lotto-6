package lotto.service.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.input.GetWinningNumberDto;
import lotto.util.message.Printer;
import lotto.util.validate.Validator;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.StackManipulation.Illegal;

public class InputView implements Input{
    @Override
    public GetLottoCountDto getLottoBuyMoney() {
        try{
            Printer.askBuyMoney();
            return new GetLottoCountDto(Validator.checkBuyMoney(getMoneyReadLine()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getLottoBuyMoney();
        }
    }

    @Override
    public GetWinningNumberDto getWinningNumber() {
        try{
            Printer.askWinningNumber();
            return new GetWinningNumberDto(Validator.checkWinningNumbers(getWinningNumbersReadline()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningNumber();
        }

    }

    @Override
    public GetBonusNumberDto getBonusNumber(final GetWinningNumberDto getWinningNumberDto) {
        try {
            Printer.askBonusNumber();
            return new GetBonusNumberDto(Validator.checkBonusNumber(getWinningNumberDto, getBonusNumberReadline()));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(getWinningNumberDto);
        }
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
