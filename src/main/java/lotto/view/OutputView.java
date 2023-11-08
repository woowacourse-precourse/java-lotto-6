package lotto.view;

import lotto.dto.LottoesDto;
import lotto.dto.ResultDto;
import lotto.util.consts.PreviewSentence;
import lotto.util.consts.Ranking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import static lotto.util.consts.IntValueConst.NEVER_COUNTED;

public class OutputView {
    public void beforeInputMoney() {
        System.out.println(PreviewSentence.INPUT_MONEY.getMessage());
    }

    public void printPurchasedLottoes(LottoesDto lottoesDto) {
        printLottoCount(lottoesDto);
        printGeneratedLottoes(lottoesDto);
    }

    private void printLottoCount(LottoesDto lottoesDto) {
        int lottoCount = lottoesDto.getLottoCount();
        System.out.print(PreviewSentence.LINE_SEPARATOR.getMessage());
        System.out.println(PreviewSentence.SAY_LOTTO_COUNT.getMessage(lottoCount));
    }

    private void printGeneratedLottoes(LottoesDto lottoesDto) {
        lottoesDto.lottoDtos()
                .forEach(dto -> System.out.println(dto.numbers()));
    }

    public void beforeInputWinNumbers() {
        System.out.print(PreviewSentence.LINE_SEPARATOR.getMessage());
        System.out.println(PreviewSentence.INPUT_WIN_LOTTO_NUMBERS.getMessage());
    }

    public void beforeInputBonusNumber() {
        System.out.print(PreviewSentence.LINE_SEPARATOR.getMessage());
        System.out.println(PreviewSentence.INPUT_BONUS_NUMBER.getMessage());
    }

    public void announceFinalResult(ResultDto resultDto) {
        beforePrintFinalResult();
        printWinResult(resultDto);
        printBenefitRate(resultDto);
    }

    private void beforePrintFinalResult() {
        System.out.print(PreviewSentence.LINE_SEPARATOR.getMessage());
        System.out.println(PreviewSentence.START_WIN_RESULT.getMessage());
        System.out.println(PreviewSentence.BAR_SEPARATOR.getMessage());
    }

    private void printWinResult(ResultDto resultDto) {
        Map<Ranking, Integer> rankingCounts = resultDto.rankingCounts();
        Arrays.stream(Ranking.values())
                .sorted(Comparator.reverseOrder()) // 5등 -> 1등 순으로 정렬
                .forEach(ranking -> {
                    Integer rankingCount = rankingCounts.getOrDefault(ranking, NEVER_COUNTED.getValue());
                    System.out.println(ranking.getMessage(rankingCount));
                });
    }

    private void printBenefitRate(ResultDto resultDto) {
        System.out.println(PreviewSentence.BENEFIT_RATE_ANNOUNCEMENT.getMessage(resultDto.benefitRate()));
    }
}
