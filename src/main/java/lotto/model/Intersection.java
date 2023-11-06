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

    public List bonusNum(int bonusNum, List<Set> lottoNum) {
        List<Integer> intersectionBonus = new ArrayList<>();
        for (Set intersectionCheck : lottoNum){
            if (intersectionCheck.contains(bonusNum)){
                intersectionBonus.add(1);
            }
            if (!intersectionCheck.contains(bonusNum)){
                intersectionBonus.add(0);
            }
        }
        return intersectionBonus;
    }
}
