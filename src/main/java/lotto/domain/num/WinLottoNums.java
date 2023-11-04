package lotto.domain.num;

import lotto.utill.Utii;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 당첨 번호 클래스
 */
public class WinLottoNums {
    private static final String COMMA_REGEX = ",";
    private List<Integer> winLottoNums;

    public WinLottoNums(String numLine) {
        String[] numArr = makeArrFromStrLine(numLine);

        winLottoNums = makeIntListFromStrArr(numArr);
    }

    private String[] makeArrFromStrLine(String numLine) {
        return numLine.split(COMMA_REGEX);
    }

    private List<Integer> makeIntListFromStrArr(String[] numArr) {
        return Arrays.stream(numArr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * 당첨 번호 추첨 번호가 같은지 확인한다.
     *
     * @return
     */
    public Boolean isSame(Integer num, Integer indexOfSpecial) {
        int valueOfIndexSpecial = winLottoNums.get(indexOfSpecial);
        boolean isSame = Utii.isSameInt(num, valueOfIndexSpecial);

        if (isSame) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return winLottoNums.toString();
    }
}
