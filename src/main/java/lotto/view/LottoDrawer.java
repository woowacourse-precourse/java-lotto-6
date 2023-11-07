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
        List<Integer> lottoNumber = lottoNumber();
        int bonusNumber = bonusNumber();
        lottoController.inputLotto(lottoNumber, bonusNumber);
    }

    private List<Integer> lottoNumber(){
        ConvertToList lottoConvertor = null;

        try {
            lottoConvertor = ConvertToList.from(readLine());
        }catch (InputException ie) {
            lottoNumber();
        }

        return lottoConvertor.getValue();
    }

    private int bonusNumber(){
        ConvertToInt bonusConvertor = null;

        try {
            bonusConvertor = ConvertToInt.from(readLine());
        }catch (InputException ie) {
            bonusNumber();
        }

        return bonusConvertor.getValue();
    }

    public void inputWinRecord() {
        lottoController.inputWinRecord();
    }
}
