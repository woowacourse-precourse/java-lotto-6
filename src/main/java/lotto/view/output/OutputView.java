package lotto.view.output;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {
    private static final String PURCHASED_LOTTO_SIZE_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String PURCHASED_LOTTO_NUMBERS_MESSAGE_FORMAT = "[%s]";
    private static final String LOTTO_NUMBERS_JOINING_DELIMETER = ", ";
    private static final String LOTTO_RESULT_TITLE_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_RANK_MATCH_COUNT_MESSAGE_FORMAT = "%d개 일치";
    private static final String BONUS_NUMBER_MATCHED_MESSAGE = ", 보너스 볼 일치";
    private static final String LOTTO_RANK_PRIZE_MESSAGE_FORMAT = " (%,d원)";
    private static final String LOTTO_RESULT_MATCH_COUNT_MESSAGE_FORMAT = " - %d개";
    private static final String PRIZE_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f%%입니다.";

    private OutputView() {
    }

    public static void printPurchasedLottos(Customer customer) {
        List<Lotto> purchasedLottos = customer.purchasedLottos();
        System.out.printf(PURCHASED_LOTTO_SIZE_MESSAGE_FORMAT, purchasedLottos.size());

        for (Lotto purchasedLotto : purchasedLottos) {
            String joinedLottoNumbers = joiningLottoNumbers(purchasedLotto.numbers());
            System.out.printf(PURCHASED_LOTTO_NUMBERS_MESSAGE_FORMAT, joinedLottoNumbers);
        }
    }

    private static String joiningLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.value()))
                .collect(joining(LOTTO_NUMBERS_JOINING_DELIMETER));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_TITLE_MESSAGE);

        for (String lottoRankResultMessage : lottoRankResultMessages(lottoResult)) {
            System.out.println(lottoRankResultMessage);
        }
    }

    private static List<String> lottoRankResultMessages(LottoResult lottoResult) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .sorted(Comparator.comparingInt(LottoRank::prize))
                .map(lottoRank -> lottoRankResultMessage(lottoRank, lottoResult.count(lottoRank)))
                .toList();
    }

    private static String lottoRankResultMessage(LottoRank rank, int count) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(LOTTO_RANK_MATCH_COUNT_MESSAGE_FORMAT, rank.matchCount()));
        if (rank.hasBonusNumber()) {
            stringBuilder.append(BONUS_NUMBER_MATCHED_MESSAGE);
        }
        stringBuilder.append(String.format(LOTTO_RANK_PRIZE_MESSAGE_FORMAT, rank.prize()));
        stringBuilder.append(String.format(LOTTO_RESULT_MATCH_COUNT_MESSAGE_FORMAT, count));

        return stringBuilder.toString();
    }

    public static void printPrizeRate(LottoResult lottoResult) {
        System.out.printf(PRIZE_RATE_MESSAGE_FORMAT, lottoResult.calculatePrizeRate());
    }
}

