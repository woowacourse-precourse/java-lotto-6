package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    Input input;
    List<Lotto> lottoList;

    LottoGame(Input input) {
        this.input = input;
    }

    public void runGame() {
        Integer totalPrice = inputTotalPrice();
        Integer lottoCount = totalPrice / 1000;
        System.out.println(String.format("%d개를 구했습니다.", totalPrice/1000));
        List<Lotto> lottoList = generateLotto(lottoCount);
        inputWinningNumbers();
    }

    private Integer inputTotalPrice() {
        Integer inputPrice = input.inputIntegerWithMessage(Script.TOTALPRICE);
        if (inputPrice % 1000 != 0) {
            Error.UNIT.print();
            return inputTotalPrice();
        }
        System.out.println();
        return inputPrice;
    }

    private List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = input.inputIntegerListWithMessage(Script.WINNINGNUMBERS);
        return List.of(1);
    }

    private List<Lotto> generateLotto(Integer count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
        }
        return lottoList;
    }

}
