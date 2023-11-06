package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.EnumList.ConstantNumber;
import lotto.EnumList.WiningInventory;
import lotto.Output.Output;

public class ResultLotto {
    private final List<Integer> lottoNumber;
    private final int bonusNumber;
    private final int ZERO = 0;
    private static HashMap<String, Integer> winList;

    public ResultLotto(List<Integer> lotto, int bonusNumber) {
        this.lottoNumber = lotto;
        this.bonusNumber = bonusNumber;
        winList = initWiningList();
    }

    public void printResult(List<List<Integer>> lotto) {
        Output output = new Output();

        lotto.forEach(innerLotto -> {
            int count = Math.toIntExact(
                    innerLotto.stream()
                            .filter(lottoNumber::contains)
                            .count()
            );

            winningResult(count, innerLotto);
        });

        output.printResultOutput();
        output.printWining(winList);
    }

    private boolean secondWin(List<Integer> innerLotto) {
        return innerLotto.stream()
                .anyMatch(number -> number == bonusNumber);
    }

    private void winningResult(int count, List<Integer> innerLotto) {
        switch (count) {
            case 3 -> winList.put(WiningInventory.FIFTH.message(), winList.get(WiningInventory.FIFTH.message()) + 1);
            case 4 -> winList.put(WiningInventory.FOURTH.message(), winList.get(WiningInventory.FOURTH.message()) + 1);
            case 5 -> {
                if (secondWin(innerLotto)) {
                    winList.put(WiningInventory.SECOND.message(), winList.get(WiningInventory.SECOND.message()) + 1);
                    break;
                }
                winList.put(WiningInventory.THIRD.message(), winList.get(WiningInventory.THIRD.message()) + 1);
            }
            case 6 -> winList.put(WiningInventory.FIRST.message(), winList.get(WiningInventory.FIRST.message()) + 1);
        }
    }

    private HashMap<String, Integer> initWiningList() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put(WiningInventory.FIRST.message(), ZERO);
        hashMap.put(WiningInventory.SECOND.message(), ZERO);
        hashMap.put(WiningInventory.THIRD.message(), ZERO);
        hashMap.put(WiningInventory.FOURTH.message(), ZERO);
        hashMap.put(WiningInventory.FIFTH.message(), ZERO);

        return hashMap;
    }

    public long resultOfMoney() {
        long money = ConstantNumber.ZERO.value();

        for (String win : winList.keySet()) {
            money += winList.get(win) * executeMoney(win);
        }

        return money;
    }

    private long executeMoney(String winingKey) {

        if (winingKey.equals(WiningInventory.FIRST.message())) {
            return ConstantNumber.FIRST_WIN_PRIZE.value();
        } else if (winingKey.equals(WiningInventory.SECOND.message())) {
            return ConstantNumber.TWO_WIN_PRIZE.value();
        } else if (winingKey.equals(WiningInventory.THIRD.message())) {
            return ConstantNumber.THREE_WIN_PRIZE.value();
        } else if (winingKey.equals(WiningInventory.FOURTH.message())) {
            return ConstantNumber.FOUR_WIN_PRIZE.value();
        }

        return ConstantNumber.FIVE_WIN_PRIZE.value();
    }

}
