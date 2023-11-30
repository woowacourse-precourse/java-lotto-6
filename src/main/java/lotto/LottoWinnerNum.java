package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinnerNum {
    private final static String ERROR_SIZE="[ERROR] 6개의 번호를 입력해 주세요.";
    private final static String ERROR_NUM_LENGTH="[ERROR] 로또 번호는 1부터 45까지의 숫자만 가능합니다.";
    private final static String ERROR_DUPLICATE="[ERROR] 입력하실 6개의 번호는 서로 중복되면 안됩니다.";
    private final List<Integer> winnerNumList;
    private final int winnerBonusNum;

    public LottoWinnerNum(List<Integer> winnerNumList, int winnerBonusNum) {
        this.winnerBonusNum = winnerBonusNum;
        this.winnerNumList = winnerNumList;
        validateLottoWinnerNum(winnerNumList);
    }

    private void validateLottoWinnerNum(List<Integer> list) {
        checkNumDuplicate(winnerNumList);
        checkNumSize(winnerNumList);
        checkNumRange(winnerNumList);
    }


    private void checkNumSize(List<Integer> list) {
        if (list.size() != 6) {
            System.out.println(ERROR_SIZE);
            throw new IllegalArgumentException();
        }
    }

    private void checkNumRange(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if (number < 1 || number > 45) {
                System.out.println(ERROR_NUM_LENGTH);
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkNumDuplicate(List<Integer> list) {
        Set<Integer> checkList = new HashSet<>(list);
        if (checkList.size() != 6) {
            System.out.println(ERROR_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoWinnerNum() {
        return winnerNumList;
    }

    public int getWinnerBonusNum() {
        return winnerBonusNum;
    }
}
