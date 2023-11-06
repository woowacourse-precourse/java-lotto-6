package lotto.view;

import static lotto.model.domain.result.LottoResult.SECOND;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import lotto.constance.GameConst;
import lotto.constance.PrintConst;
import lotto.model.domain.Revenue;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.result.LottoResult;
import lotto.view.io.Reader;
import lotto.view.io.Writer;

public class TerminalUI {
    private static Pattern answerNumbersPattern =
            Pattern.compile(GameConst.FORMAT_INPUT_ANSWERS);

    private static final DecimalFormat moneyFormat =
            new DecimalFormat(PrintConst.DECIMAL_FORMAT_MONEY);

    public void printEmptyLine() {
        Writer.printMessage("");
    }

    public void printException(IllegalArgumentException e) {
        Writer.printMessage(PrintConst.EXCEPTION_PREFIX + e.getMessage());
    }

    public int getMoney() {
        Writer.printMessage(PrintConst.GUIDE_PURCHASE);
        return Reader.getOneNumber();
    }

    public void printPurchasedLottos(List<Lotto> lottosDTO) {
        Writer.printUsingFormat(PrintConst.FORMAT_LOTTO_SIZE, lottosDTO.size());
        for (Lotto lotto : lottosDTO) {
            Writer.printUsingFormat(PrintConst.FORMAT_LOTTO_NUMBERS, lotto.getNumbers().toArray());
        }
    }

    public List<Integer> getAnswerNumber() {
        Writer.printMessage("");
        Writer.printMessage(PrintConst.GUIDE_LOTTO_NUMBERS);
        return Reader.getNumbersInPattern(
                input -> input.replaceAll(" ", ""),
                answerNumbersPattern,
                GameConst.DELIMITER
        );
    }

    public Integer getBonusNumber() {
        Writer.printMessage("");
        Writer.printMessage(PrintConst.GUIDE_BONUS_NUMBERS);
        return Reader.getOneNumber();
    }

    public void printResult(List<Entry<LottoResult, Integer>> results) {
        Writer.printMessage(PrintConst.TITLE_RESULTS);

        for (Map.Entry<LottoResult, Integer> result : results) {
            LottoResult lottoResult = result.getKey();
            int count = result.getValue();
            Writer.printUsingFormat(PrintConst.FORMAT_RESULT, buildLottoResultString(lottoResult), count);
        }
    }

    private String buildLottoResultString(LottoResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PrintConst.FORMAT_COLLECTION_COUNT, result.getCollectCount()));
        if (result.equals(SECOND)) {
            sb.append(PrintConst.FORMAT_BONUS);
        }
        sb.append(String.format(PrintConst.FORMAT_PRICE, getMoneyString(result.getPrize())));
        return sb.toString();
    }


    private String getMoneyString(int prize) {
        return moneyFormat.format(prize);
    }

    public void printRevenue(Revenue revenue) {
        Writer.printUsingFormat(PrintConst.FORMAT_REVENUE,
                new DecimalFormat(PrintConst.DECIMAL_FORMAT_REVENUE)
                        .format(revenue.getRevenue()));
    }
}
