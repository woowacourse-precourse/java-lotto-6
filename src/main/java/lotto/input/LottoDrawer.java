package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.ApplicationContext;
import lotto.controller.LottoController;
import lotto.exception.InputException;
import lotto.input.convert.ConverToInt;
import lotto.input.convert.ConvertToList;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class LottoDrawer {
    private LottoController lottoController = ApplicationContext.getController();

    public void inputLotto() {
        OutputMessage.print(MessageType.INPUT_START_WIN_NUMBER);
        try {
            ConvertToList lottoConvertor = ConvertToList.from(readLine());
            List<Integer> numbers = lottoConvertor.getValue();

            lottoController.inputLotto(numbers);
        } catch (InputException ie) {
            inputLotto();
        }

    }

    public void inputBonus() {
        OutputMessage.print(MessageType.INPUT_START_BONUS);
        try {
            ConverToInt bonusConvertor = ConverToInt.from(readLine());
            int number = bonusConvertor.getValue();

            lottoController.inputBonus(number);
        }catch (InputException ie){
            inputBonus();
        }
    }

    public void inputWinRecord() {
        lottoController.inputWinRecord();
    }
}
