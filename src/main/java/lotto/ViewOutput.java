package lotto;

import java.util.ArrayList;
import java.util.List;

public class ViewOutput {
    private static StringBuilder stringBuilder = new StringBuilder();

    public void showLottoList(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            stringBuilder.append("[");

            for(int index = 0; index < 6; index++) {
                List<Integer> lottoNumbers = new ArrayList<>();
                stringBuilder.append(lottoNumbers.get(index) + ", ");
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
            stringBuilder.append("]\n");
        }

        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }
}
