package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.config.AppConfig;
import lotto.config.exception.InputException;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.controller.LottoController;
import lotto.view.convert.ConvertToInt;
import lotto.view.convert.ConvertToList;

public class LottoDrawer {
    private LottoController lottoController = AppConfig.getController();

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
            ConvertToInt bonusConvertor = ConvertToInt.from(readLine());
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
