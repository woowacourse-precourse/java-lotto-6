package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.Map;
import lotto.ApplicationContext;
import lotto.controller.LottoController;
import lotto.input.convert.ConverToInt;
import lotto.input.convert.ConvertToList;

public class LottoDrawer {
    private LottoController lottoController = ApplicationContext.getController();

    public void inputLotto(){
        ConvertToList lottoConvertor = ConvertToList.from(readLine());
        ConverToInt bonusConvertor = ConverToInt.from(readLine());

        List<Integer> numbers = lottoConvertor.getValue();
        int bonus = bonusConvertor.getValue();

        lottoController.inputLotto(numbers, bonus);
    }

    public void compareWinning(){
        lottoController.compareWinning();
    }
}
