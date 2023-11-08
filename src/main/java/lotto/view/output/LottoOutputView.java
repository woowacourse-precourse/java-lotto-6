package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoDto;
import lotto.controller.dto.LottoDtos;
import lotto.domain.entity.Rank;
import lotto.service.dto.GameResult;

public class LottoOutputView {

    // TODO: 2023-11-08 하위 클래스로 분리 
    private final String FORMAT_LOTTO_AMOUNT = "개를 구매했습니다.";
    private final String NOTICE_BONUS_NUMBER = "보너스 번호를 입력해주세요";
    private final String NOTICE_NUMBERS = "당첨번호를 입력해주세요";
    private final String NOTICE_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private final String SECOND_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private final String RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private final String EARNING_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private final String LOTTO_NUMBERS_JOIN_DELIMITER = ", ";
    private final String LEFT_BRACKET = "[";
    private final String RIGHT_BRACKET = "]";
    private final String BAR  = "---";
    private final String STATISTICS_FORMAT = "당첨 통계";

    public void askPurchasePrice() {
        System.out.println(NOTICE_PURCHASE_PRICE);
    }

    public void askLottoNumbers() {
        System.out.println();
        System.out.println(NOTICE_NUMBERS);
    }

    public void askLottoBonusNumber() {
        System.out.println();
        System.out.println(NOTICE_BONUS_NUMBER);
    }

    public void printLottos(final LottoDtos lottoDtos) {
        System.out.println();
        System.out.println(lottoDtos.size() + FORMAT_LOTTO_AMOUNT);
        printLottos(lottoDtos.lottoDtos());
    }

    private void printLottos(final List<LottoDto> lottoDtos) {
        lottoDtos.stream()
                .map(this::parseLottoNumber)
                .forEach(this::printNumbers);
    }

    private String parseLottoNumber(final LottoDto lottoDto) {
        List<String> numbers = lottoDto.numbers()
                .stream()
                .map(Object::toString)
                .toList();
        return String.join(LOTTO_NUMBERS_JOIN_DELIMITER, numbers);
    }

    private void printNumbers(final String numbers) {
        System.out.println(LEFT_BRACKET + numbers + RIGHT_BRACKET);
    }

    public void printResult(final GameResult gameResult) {
        printResultHead();
        printAllRankResult(gameResult.rankBoard());
        printEarning(gameResult);

    }

    private void printResultHead() {
        System.out.println(STATISTICS_FORMAT);
        System.out.println(BAR);
    }

    private void printAllRankResult(Map<Rank, Long> rankBoard) {
        rankBoard.keySet()
                .forEach(rank -> {
                    printResultEachRank(rank, rankBoard.get(rank));
                });
    }

    private void printResultEachRank(final Rank rank, final Long count) {
        int countForRank = rank.getCountForRank();
        String prizeFormat = rank.getPrizeFormat();

        if (rank == Rank.SECOND) {
            printFormattingResult(
                    SECOND_RESULT_FORMAT, count, countForRank, prizeFormat);
            return;
        }
        printFormattingResult(RESULT_FORMAT, count, countForRank, prizeFormat);
    }

    private void printFormattingResult(
            final String format,
            final Long count,
            final int countForRank,
            final String prizeFormat) {
        System.out.printf(format, countForRank, prizeFormat, count);
    }

    private void printEarning(GameResult gameResult) {
        System.out.printf(EARNING_FORMAT, gameResult.earningRate());
    }
}
