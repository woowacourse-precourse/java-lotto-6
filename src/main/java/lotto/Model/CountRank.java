package lotto.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountRank {
    public static List<Integer> countRank(List myLotto, List correctLotto) {
        List<Integer> countList = new ArrayList<>();

        for (int i = 0; i < myLotto.size(); i++) {
            int count = 0;
            for(int j = 0; j < correctLotto.size(); j++) {
                if (Arrays.asList(myLotto.get(i).toString().replace(" ", "").replace("[", "").
                        replace("]", "").split(",")).contains(correctLotto.get(j).toString()))
                {
                    count++;
                }
            }
            System.out.println(myLotto.get(i) + " " + count);
            countList.add(count);
        }
        return countList;
    }
}
