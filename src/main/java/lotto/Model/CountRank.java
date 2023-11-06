package lotto.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountRank {
    public static List<Integer> countRank(List myLotto, List correctLotto, String bonus) {
        List<Integer> countList = new ArrayList<>();

        for (int i = 0; i < myLotto.size(); i++) {
            int count = 0;
            for(int j = 0; j < correctLotto.size(); j++) {
                if (Arrays.asList(myLotto.get(i).toString().replace(" ", "").replace("[", "").
                        replace("]", "").split(",")).contains(correctLotto.get(j).toString()))
                {
                    count++;
                }
                if(count == 5){
                    if (Arrays.asList(myLotto.get(i).toString().replace(" ", "").replace("[", "").
                            replace("]", "").split(",")).contains(bonus)){
                        count = count + 2;
                    }
                }
            }
            countList.add(count);
        }
        return countList;
    }
}
