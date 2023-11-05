package lotto.view;

import lotto.domain.Ranking;
import lotto.dto.LottoDto;
import lotto.dto.WinningResultDto;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    private static String USER_LOTTO_MESSAGE = "개를 구매했습니다.";

    private ConsoleOutputView() {
    }

    private static class ConsoleOutputViewHolder {
        private static ConsoleOutputView consoleOutputView = new ConsoleOutputView();
    }

    public static ConsoleOutputView getInstance() {
        return ConsoleOutputView.ConsoleOutputViewHolder.consoleOutputView;
    }

    @Override
    public void printUserLotto(List<LottoDto> lottoDtos) {
        print(lottoDtos.size() + USER_LOTTO_MESSAGE);
        lottoDtos.stream()
                .forEach(lottoDto -> print(lottoDto.getNumbers()));
    }

    @Override
    public void printWinningResult(WinningResultDto winningResultDto) {
        Arrays.stream(Ranking.values())
                .forEach(ranking -> System.out.print(ranking.getMatchCount() + "개 일치 (" + ranking.getReward() + "원) - " + winningResultDto.getRankingCount(ranking) + "개\n"));

        System.out.println("총 수익률은 " + winningResultDto.getReturnRate() + "%입니다.");
    }
}
