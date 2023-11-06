package lotto.Output;

import java.util.HashMap;
import lotto.EnumList.ConstantNumber;
import lotto.EnumList.WiningInventory;
import lotto.ResultLotto;

public class Output {
    private static final String result = "당첨 통계";
    private static final String line = "---";
    private final String resultSize = "개";

    public void printResultOutput() {
        System.out.println(result);
        System.out.println(line);
    }

    public void printWining(HashMap<String, Integer> winList) {
        int count = ConstantNumber.ZERO.value();

        while (count < ConstantNumber.FIVE.value()) {
            if (count == ConstantNumber.ZERO.value()) {
                System.out.println(WiningInventory.PRINT_FIFTH.message() + winList.get(WiningInventory.FIFTH.message())
                        + resultSize);
            } else if (count == ConstantNumber.ONE.value()) {
                System.out.println(
                        WiningInventory.PRINT_FOURTH.message() + winList.get(WiningInventory.FOURTH.message())
                                + resultSize);
            } else if (count == ConstantNumber.TWO.value()) {
                System.out.println(WiningInventory.PRINT_THIRD.message() + winList.get(WiningInventory.THIRD.message())
                        + resultSize);
            } else if (count == ConstantNumber.THREE.value()) {
                System.out.println(
                        WiningInventory.PRINT_SECOND.message() + winList.get(WiningInventory.SECOND.message())
                                + resultSize);
            } else if (count == ConstantNumber.FOUR.value()) {
                System.out.println(WiningInventory.PRINT_FIRST.message() + winList.get(WiningInventory.FIRST.message())
                        + resultSize);
            }
            count++;
        }
    }

    public void printRateOfReturn(Double rate) {
        System.out.print("총 수익률은 " + rate + "%입니다.");
    }
}
