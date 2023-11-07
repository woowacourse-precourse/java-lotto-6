package lotto.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountRank {
    public static List<Integer> countRank(List myLotto, List correctLotto, String bonus) {
        List<Integer> countList = new ArrayList<>();

        for (int i = 0; i < myLotto.size(); i++) {
            List splitList = Arrays.asList(myLotto.get(i).toString().replace(" ", "").replace("[", "").
                    replace("]", "").split(","));
            int count = countCorrect(splitList, correctLotto, bonus);
            countList.add(count);
        }
        return countList;
    }
    private static int countCorrect(List splitList, List correctLotto, String bonus){
        int count = 0;
        for(int i = 0; i < correctLotto.size(); i++){
            if (splitList.contains(correctLotto.get(i).toString())){
                count++;
            }
            if (count == 5 && splitList.contains(bonus)){
                count = count + 2;
            }
        }
        return count;
    }
}
