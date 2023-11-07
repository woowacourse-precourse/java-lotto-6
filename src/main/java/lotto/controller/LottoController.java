package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottosList;
import lotto.view.ConsolePrint;

public class LottoController {
    private LottosList lottosList;
    private Lotto winningNumber;

    public LottoController() {

    }

    public void start() {
        lottosList = new LottosList(ConsolePrint.readPrice());
        winningNumber = new Lotto(
                ConsolePrint.readWinningNum().split(","));

        compareNumbers();
    }

    public List<Integer> compareNumbers() {
        return lottosList.getLottosList().stream()
                .mapToInt(lotto -> countSameNumbers(lotto.getNumbers(), winningNumber.getNumbers()))
                .boxed()
                .collect(Collectors.toList());
    }

    public int countSameNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }


}
