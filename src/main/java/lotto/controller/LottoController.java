package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

        makeRank(compareNumbers());
    }

    public List<Integer> compareNumbers() {
//        return lottosList.getLottosList().stream()
//                .mapToInt(lotto -> countSameNumbers(lotto.getNumbers(), winningNumber.getNumbers()))
//                .boxed()
//                .collect(Collectors.toList());
        List<Integer> countList = new ArrayList<>();

        IntStream.range(0, lottosList.getLottosList().size())
                .filter(index -> {
                    int count = countSameNumbers(lottosList.getLottosList().get(index).getNumbers(),
                            winningNumber.getNumbers());
//                    System.out.println(count);
//                    if (count == 5) {
//                        processCountIs5(index, lottosList);
//                    }
                    countList.add(count); // 모든 count를 리스트에 추가
                    return count == 5;
                })
                .forEach(index -> {
                    System.out.println("index:" + index);
                    processCountIs5(index, lottosList);
                });

        System.out.println(countList);
        return countList;
    }

    public int processCountIs5(int index, LottosList lottoBox) {
        Lotto lotto = lottoBox.getLottosList().get(index);
        if (lotto.getNumbers().contains(bonus.getNumber())) {
            lottoBox.checkBonus(index);
        }
        return index;
    }

    public int countSameNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int result = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        System.out.println(result);
        return result;
    }

    void printLottos() {
        ConsolePrint.printPurchased(lottosList.getLottosList().size());
        for (Lotto lotto : lottosList.getLottosList()) {
            ConsolePrint.printLotto(lotto);
        }

    }

    public void makeRank(List<Integer> sames) {
        System.out.println(sames);
        ConsolePrint.print3Same(Collections.frequency(sames, 3));
        ConsolePrint.print4Same(Collections.frequency(sames, 4));
        int result = Collections.frequency(sames, 5);
        int bonusSame = Collections.frequency(lottosList.getBonusCheck(), true);
        ConsolePrint.printBonusX(result - bonusSame);
        ConsolePrint.printBonusO(bonusSame);
        ConsolePrint.print3Same(Collections.frequency(sames, 3));
    }

    public void compareBonus(List<Integer> sames, int index) {

    }

}
