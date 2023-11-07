package lotto.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottosList;
import lotto.view.ConsolePrint;

public class LottoController {
    private LottosList lottosList;
    private Lotto winningNumber;

    private BonusNumber bonus;

    public LottoController() {

    }

    public void start() {
        lottosList = new LottosList(ConsolePrint.readPrice());
        printLottos();
        winningNumber = new Lotto(
                ConsolePrint.readWinningNum().split(","));
        bonus = new BonusNumber(ConsolePrint.readBonusNum());
        compareNumbers();

    }

    public List<Integer> compareNumbers() {
//        return lottosList.getLottosList().stream()
//                .mapToInt(lotto -> countSameNumbers(lotto.getNumbers(), winningNumber.getNumbers()))
//                .boxed()
//                .collect(Collectors.toList());
        List<Lotto> lottos = lottosList.getLottosList();
        return IntStream.range(0, lottos.size()) // 0부터 리스트 크기까지의 인덱스 스트림 생성
                .filter(index -> {
                    int count = countSameNumbers(lottos.get(index).getNumbers(),
                            winningNumber.getNumbers());
                    return count == 5;
                })
                .mapToObj(index -> processCountIs5(index, lottosList))
                .collect(Collectors.toList());
    }

    public int processCountIs5(int index, LottosList lottoBox) {
        Lotto lotto = lottoBox.getLottosList().get(index);
        if (lotto.getNumbers().contains(bonus.getNumber())) {
            lottoBox.checkBonus(index);
        }
        return index;
    }

    public int countSameNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    void printLottos() {
        ConsolePrint.printPurchased(lottosList.getLottosList().size());
        for (Lotto lotto : lottosList.getLottosList()) {
            ConsolePrint.printLotto(lotto);
        }

    }

    public void makeRank(List<Integer> sames) {
        ConsolePrint.print3Same(Collections.frequency(sames, 3));
        ConsolePrint.print4Same(Collections.frequency(sames, 4));
        ConsolePrint.printBonusX(Collections.frequency(sames, 5));
        ConsolePrint.print3Same(Collections.frequency(sames, 3));
    }

    public void compareBonus(List<Integer> sames, int index) {

    }

}
