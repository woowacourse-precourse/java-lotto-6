package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {
    public List<Integer> randomNumber(int size, int start, int end){
        ArrayList<Integer> numArray = new ArrayList<>();

        while(numArray.size() < size){
            int num = Randoms.pickNumberInRange(start, end);
            if(!numArray.contains(num)){
                numArray.add(num);
            }
        }
        return numArray;
    }
}
