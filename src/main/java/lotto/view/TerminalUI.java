package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.constance.PrintConst;
import lotto.model.domain.Lotto;
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
    public void printPurchasedLottos(List<Lotto> lottosDTO) {
        Writer.printUsingFormat(PrintConst.FORMAT_LOTTO_SIZE, lottosDTO.size());
        for(Lotto lotto : lottosDTO){
            Writer.printUsingFormat(PrintConst.FORMAT_LOTTO_NUMBERS, lotto.getNumbers().toArray());
        }
    }

    @Override
    public List<Integer> getAnswerNumber() {
        Writer.printEmtpyLine();
        Writer.printGuide(PrintConst.GUIDE_LOTTO_NUMBERS);
        return Reader.getAnswerNumbers();
    }

    @Override
    public Integer getBonusNumber() {
        Writer.printEmtpyLine();
        Writer.printGuide(PrintConst.GUIDE_BONUS_NUMBERS);
        return Reader.getBonusNumber();
    }

    @Override
    public void printResult(List<Entry<LottoResult, Integer>> results) {
        Writer.printGuide("당첨 통계\n---");
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
