package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.constance.PrintConst;
import lotto.model.domain.result.LottoResult;
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

    @Override
    public void printResult(List<Entry<LottoResult, Integer>> results) {
        for(Map.Entry<LottoResult, Integer> result : results){
            LottoResult lottoResult = result.getKey();
            int count = result.getValue();
            Writer.printUsingFormat(PrintConst.FORMAT_RESULT, lottoResult, count);
        }
    }

    @Override
    public void printRevenue(double revenue) {
        Writer.printUsingFormat(PrintConst.FORMAT_REVENUE, revenue);
    }


}
