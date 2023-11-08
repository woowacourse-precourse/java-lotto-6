package lotto.view;

import static lotto.model.domain.result.LottoResult.SECOND;

import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Pattern;
import lotto.constance.GameConst;
import lotto.constance.PrintConst;
import lotto.model.domain.Revenue;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.result.LottoResult;
import lotto.model.domain.result.LottoResultAndCount;
import lotto.view.io.Reader;
import lotto.view.io.Writer;

/**
 * Lotto 어플리케이션에서 필요한 입,출력 기능들을 기능 단위로 묶어 제공합니다.
 */
public class TerminalUI {
    private static final Pattern answerNumbersPattern =
            Pattern.compile(GameConst.FORMAT_INPUT_ANSWERS);
    private static final DecimalFormat moneyFormat =
            new DecimalFormat(PrintConst.DECIMAL_FORMAT_MONEY);

    public void printEmptyLine() {
        Writer.printMessage("");
    }

    public void printException(IllegalArgumentException e) {
        Writer.printMessage(PrintConst.PREFIX_EXCEPTION + e.getMessage());
    }

    public int getMoney() {
        Writer.printMessage(PrintConst.GUIDE_PURCHASE);
        return Reader.getOneNumber();
    }

    public void printPurchasedLottos(List<Lotto> lottosDTO) {
        Writer.printUsingFormat(PrintConst.FORMAT_LOTTO_PURCHASE, lottosDTO.size());
        for (Lotto lotto : lottosDTO) {
            Writer.printUsingFormat(PrintConst.FORMAT_LOTTO_NUMBERS, lotto.getNumbers().toArray());
        }
        Writer.printMessage("");
    }

    public List<Integer> getAnswerNumber() {
        Writer.printMessage(PrintConst.GUIDE_LOTTO_NUMBERS);
        return Reader.getNumbersInPattern(
                input -> input.replaceAll(" ", ""),
                answerNumbersPattern,
                GameConst.DELIMITER
        );
    }

    public Integer getBonusNumber() {
        Writer.printMessage(PrintConst.GUIDE_BONUS_NUMBERS);
        return Reader.getOneNumber();
    }

    public void printResult(List<LottoResultAndCount> results) {
        Writer.printMessage(PrintConst.TITLE_RESULTS);

        for (LottoResultAndCount result : results) {
            LottoResult lottoResult = result.getLottoResult();
            int count = result.getCount();
            Writer.printUsingFormat(PrintConst.FORMAT_RESULT_AND_COUNT, buildLottoResultString(lottoResult), count);
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
