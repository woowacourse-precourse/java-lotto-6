package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Store {

    private static int paperNumber = 0;
    private static List<List<Integer>> randomNumbers = new ArrayList<>();

    public static List<List<Integer>> randomNumbers(){
        return makeRandomNumbers(countLottoPaper());
    }

    private static int countLottoPaper(){
        paperNumber = UserInputStore.getLottoPurchase()/1000;

        return paperNumber;
    }

    public static int getPaperNumbers(){
        return paperNumber;
    }

    private static List<List<Integer>> makeRandomNumbers(int paperNumber){
        for (int i = 0; i < paperNumber; i++) {
            List<Integer> Numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(Numbers); //오름차순 정렬
            randomNumbers.add(Numbers);
        }
        return randomNumbers;
    }

    public static List<List<Integer>> getMyLottoNumbers(){
        return randomNumbers;
    }
}
