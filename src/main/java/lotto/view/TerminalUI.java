package lotto.view;

import java.util.List;
import lotto.constance.PrintConst;
import lotto.ui.Reader;
import lotto.ui.Writer;
import lotto.view.LottoGameUI;

public class TerminalUI implements LottoGameUI {
    @Override
    public int getMoney() {
        Writer.printGuide(PrintConst.GUIDE_PURCHASE);
        return Reader.getMoney();
    }

    @Override
    public List<Integer> getAnswerNumber() {
        Writer.printGuide(PrintConst.GUIDE_LOTTO_NUMBERS);
        return Reader.getAnswerNumbers();
    }

    @Override
    public Integer getBonusNumber() {
        Writer.printGuide(PrintConst.GUIDE_BONUS_NUMBERS);
        return Reader.getBonusNumber();
    }
}
