package lotto.model;
import lotto.view.View;
import java.util.Arrays;
import java.util.List;

public class LottoSetUp {
    static int[][] lottos;
    static int[] winningNumbers;
    static int rows;
    static int cols;

    public static int[][] makeListToGetLottos() {
        rows = 6;
        cols = View.getTotalNumber();
        int[][] lottos = new int[cols][rows];
        return lottos;
    }
    public static int[] listToIntArray(List<Integer> list) {
        int[] lottos = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lottos[i] = list.get(i);
        }
        return lottos;
    }

    public static int[][] toMakeIncreseLotto() {
        lottos = LottoGet.getLottos();
        for(int i = 0; i < View.getTotalNumber(); i++) {
            Arrays.sort(lottos[i]);
        }
        return lottos;
    }

    public static int[] winningNumberToInt() {
        String input = View.getWinningNumber();
        String[] inputs = input.split(",");
        winningNumbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            winningNumbers[i] = Integer.parseInt(inputs[i]);
        }
        return winningNumbers;
    }

    public static int getcols() {
        return cols;
    }

    public static int[][] getLottos() {
        return lottos;
    }

    public static int[] getWinningNumbers() {
        return winningNumbers;
    }
}
