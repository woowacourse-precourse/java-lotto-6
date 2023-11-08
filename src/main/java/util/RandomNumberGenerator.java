package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> create (int count, int start, int end){
        List<Integer> nums;
        while(true){
            nums = Randoms.pickUniqueNumbersInRange(start, end, count);
            List<Integer> copyNums = new ArrayList<>();
            if(nums.stream().allMatch(num-> !copyNums.contains(num) && copyNums.add(num)))
                break;
        }
       return nums;
    }

}
