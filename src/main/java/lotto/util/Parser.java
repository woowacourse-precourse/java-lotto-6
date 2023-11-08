package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    public static int convertInt(String inputNum) throws IllegalArgumentException{
        try {
            return Integer.parseInt(inputNum);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] : 숫자로 입력해주세요.");
        }
    }

    public static List<Integer> convertWinningNum(String inputWinningNum) throws IllegalArgumentException{
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(inputWinningNum, ",");
        while(st.hasMoreTokens()) {
            String nextNumber = st.nextToken();
            winningNumbers.add(convertInt(nextNumber));
        }
        return winningNumbers;
    }

}
