package lotto.model;

import org.w3c.dom.CDATASection;

import java.util.*;

public class Intersection {

    public List<Integer> winNum(List<Integer> winNum, List<Set> lottoNum) {
        HashSet<Integer> convert = new HashSet<>(winNum);
        List<Integer> intersectionCount = new ArrayList<>();
        for (Set intersection : lottoNum) {
            intersection.retainAll(convert);
            intersectionCount.add(intersection.size());
        }
        return intersectionCount;
    }

    public boolean bonusNum(int bonusNum, List<Set> lottoNum) {
        if (lottoNum.contains(bonusNum)) {
            return true;
        }
        return false;
    }
}
