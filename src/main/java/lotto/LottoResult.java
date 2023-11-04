package lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class LottoResult {

    private List<WinningLotto> winningLottos = new ArrayList<>();
    private Float rateOfReturn;

    public LottoResult() {
        this.rateOfReturn = 0.0F;
    }

    public LottoResult showLottoResult(final List<Integer> winningNumbers, final Integer bonus, final List<Lotto> lottos) {
        this.winningLottos = lottos.stream()
                .map(lotto -> lotto.compareWinningNumbers(winningNumbers, bonus))
                .toList();

        float averageOfPrice = (float) this.winningLottos.stream()
                .mapToLong(WinningLotto::getPrice)
                .average()
                .getAsDouble();

        this.rateOfReturn = averageOfPrice / 10;

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "3개 일치 (5,000원) - %d개\n" +
                        "4개 일치 (50,000원) - %d개\n" +
                        "5개 일치 (1,500,000원) - %d개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                        "6개 일치 (2,000,000,000원) - %d개\n" +
                        "총 수익률은 %.1f%%입니다.",
                frequency(this.winningLottos, WinningLotto.FIFTH_PLACE),
                frequency(this.winningLottos, WinningLotto.FOURTH_PLACE),
                frequency(this.winningLottos, WinningLotto.THIRD_PLACE),
                frequency(this.winningLottos, WinningLotto.SECOND_PLACE),
                frequency(this.winningLottos, WinningLotto.FIRST_PLACE),
                this.rateOfReturn
        );
    }

}
