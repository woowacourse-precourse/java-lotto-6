package lotto.view;

import lotto.dto.LottoesDto;
import lotto.dto.ResultDto;
import lotto.util.consts.PreviewSentence;
import lotto.util.consts.Ranking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class OutputView {

    private static final int NEVER_COUNTED = 0;

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
        System.out.print(PreviewSentence.LINE_SEPARATOR.getMessage());
        System.out.println(PreviewSentence.START_WIN_RESULT.getMessage());
        System.out.println(PreviewSentence.BAR_SEPARATOR.getMessage());

        Map<Ranking, Integer> rankingCounts = resultDto.rankingCounts();
        Arrays.stream(Ranking.values())
                .sorted(Comparator.reverseOrder())
                .forEach(ranking -> {
                    Integer rankingCount = rankingCounts.getOrDefault(ranking, NEVER_COUNTED);
                        System.out.println(ranking.getMessage(rankingCount));
                });

        System.out.println(PreviewSentence.BENEFIT_RATE_ANNOUNCEMENT.getMessage(resultDto.benefitRate()));
    }
}
