package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> create(int count, int start, int end){
        List<Integer> nums;
        while(true){
            nums = Randoms.pickUniqueNumbersInRange(start, end, count);
            if(!nums.stream().anyMatch(nums::contains))
                break;
        }
       return nums;
    }
}
