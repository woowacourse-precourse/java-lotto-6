package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public void outputLottoCount(int count) {
        System.out.print(count);
        System.out.print("개를 구매했습니다.\n");
    }

    public void outputLottosNumber(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::toStringLotto)
                .forEach(System.out::println);
    }
    public void outputWinningResult() {

    }
}
