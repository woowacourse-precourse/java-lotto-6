package lotto.view;

import java.util.List;

public class OutputView {
    private static int[] rank = new int[8];
    public static void winningLotto(List<Integer> numbers, List<List<Integer>> myNumbers) {
        for (List<Integer> myNumber : myNumbers) {
            checkLotto(numbers, myNumber);
        }
    }

    private static void checkLotto(List<Integer> numbers, List<Integer> myNumber) {
        int checkLottoNum = 0;
        for (int i = 0; i < myNumber.size(); i++) {
            if (numbers.contains(myNumber.get(i))) {
                checkLottoNum++;
            }
        }
        if (checkLottoNum == 5 && myNumber.contains(numbers.get(6))) {
            rank[7]++;
            return;
        }
        rank[6 - checkLottoNum]++;
    }

    public static int[] getRank() {
        return rank;
    }
}
