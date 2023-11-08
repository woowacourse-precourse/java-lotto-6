package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputUtil {
    public static List<Integer> inputNumbers(String str) {
        StringTokenizer st = new StringTokenizer(str, ",");
        List<Integer> results = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            int num = Integer.parseInt(temp);
            if(num >45 || num <1) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            results.add(num);
        }

        return results;
    }
}
