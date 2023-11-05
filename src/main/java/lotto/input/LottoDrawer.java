package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.ApplicationContext;
import lotto.controller.LottoController;
import lotto.exception.InputException;
import lotto.input.convert.ConverToInt;
import lotto.input.convert.ConvertToList;

public class LottoDrawer {
    private LottoController lottoController = ApplicationContext.getController();

    public void inputLotto() {
        try {
            ConvertToList lottoConvertor = ConvertToList.from(readLine());
            List<Integer> numbers = lottoConvertor.getValue();

            lottoController.inputLotto(numbers);
        } catch (InputException ie) {
            inputLotto();
        }

    }

    public void inputBonus() {
        try {
            ConverToInt bonusConvertor = ConverToInt.from(readLine());
            int number = bonusConvertor.getValue();

            lottoController.inputBonus(number);
        }catch (InputException ie){
            inputBonus();
        }
    }

    public void compareWinning() {
        lottoController.compareWinning();
    }
}
