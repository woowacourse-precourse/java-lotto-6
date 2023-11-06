package lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCalculator {
    public int checkMatch(List<Integer> nums1, List<Integer> nums2){
        return (int)nums1.stream().filter(o -> nums2.stream().anyMatch(Predicate.isEqual(o))).count();
    }
}
