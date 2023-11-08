package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTable {
    private static final int INPUT_DIGIT_FIRST = 1;
    private static final int INPUT_DIGIT_LAST = 45;
    private static final int COLUMN = 6;

    private Map<Integer, List<Integer>> lottoTable = new HashMap<>();
    private int row;

    public LottoTable(int row) {
        this.row = row;
        generateLottoTable();
    }

    public int getRow() {
        return row;
    }

    private void generateLottoTable() {
        for (int i = 0; i < row; i++) {
            List<Integer> sortedLottoRow = Randoms.
                    pickUniqueNumbersInRange(INPUT_DIGIT_FIRST, INPUT_DIGIT_LAST, COLUMN)
                    .stream()
                    .sorted()
                    .toList();
            lottoTable.put(i, sortedLottoRow);
        }
    }

    public Map<Integer, List<Integer>> getLottoTable() {
        return lottoTable;
    }
}