package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoGameMessage;
import lotto.domain.LottoScore;
import lotto.domain.WinningStatistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGameUtil {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;
    private static final int PURCHASE_AMOUNT_FORMAT = 1000;
    public static final int ZERO = 0;
    public static final String CONTOUR_WITH_BLANK = " - ";
    private static final String SEPARATOR_WITH_BLANK = ", ";
    private static final String OPEN_SQUARE_BRACKET = "[";
    private static final String CLOSE_SQUARE_BRACKET = "]";
    private static final String SEPARATOR = ",";
    public static final List<LottoScore> LOTTO_SCORE_LIST = Stream.of(LottoScore.values())
            .collect(Collectors.toList());

    private LottoGameUtil() {}

    public static void validPurchaseAmountFormat(String amount) {
        if (Integer.parseInt(amount) % PURCHASE_AMOUNT_FORMAT != ZERO) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
    }
    
    public static int convertPurchaseAmount(String amount) {
        validPurchaseAmountFormat(amount);
        return Integer.parseInt(amount) / PURCHASE_AMOUNT_FORMAT;
    }

    public static List<Lotto> generateLottoNumbers(int purchase) {
        List<Lotto> lottoList = new ArrayList<>();
        while(purchase-- > ZERO) {
            lottoList.add(new Lotto(NumberUtil.numberGenerator(MIN, MAX, SIZE)));
        }
        return lottoList;
    }
    public static void viewNumberStatus(List<Integer> numbers) {
        OutputUtil.println(OPEN_SQUARE_BRACKET + numbers.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(SEPARATOR_WITH_BLANK)) + CLOSE_SQUARE_BRACKET);
    }

    public static void validNumbersContainsSeparator(String numbers) {
        if (!numbers.contains(SEPARATOR)) {
            throw new IllegalArgumentException(LottoGameMessage.NOT_VALID_INPUT);
        }
    }

    public static List<Integer> convertLottoNumber(String winningNumber) {
        return Arrays.stream(winningNumber.split(SEPARATOR))
                .map(number -> InputUtil.convert(number))
                .collect(Collectors.toList());
    }

    public static LottoScore getResult(int count, boolean isContainsBonus) {
        return LOTTO_SCORE_LIST.stream()
                .filter(lottoScore -> lottoScore.compare(count, isContainsBonus))
                .findFirst()
                .orElse(LottoScore.NOTHING);
    }

    public static WinningStatistic getWinningStatistics(List<LottoScore> winningStatistics) {
        return WinningStatistic.from(winningStatistics);
    }
}
