package lotto;

import lotto.constant.Constant;

import java.util.*;

import static lotto.UserInput.*;
import static lotto.common.Common.strToInt;

public class Winning {

    List<Integer> listNumber;
    List<Integer> listPrize;
    HashMap<Integer, Integer> map;
    int bonus;

    private int getIndex(int[] counts, List<Integer> list){
        int idx = -1;

        if (counts[0] <= 5) idx = counts[0] - 3;
        if (counts[0] == 5 && counts[1] == 1)
            idx = list.size() - 2;
        if (counts[0] == 6) idx = list.size() - 1;
        return idx;
    }

    public void calc(List<Lotto> listLotto){
        List<Integer> listPrize = this.listPrize;

        for (Lotto lotto : listLotto){
            int[] counts = lotto.countWin(this.listNumber, this.bonus);
            int idx = getIndex(counts, listPrize);
            if (idx >= 0) {
                int key = listPrize.get(idx);
                this.map.put(key, this.map.get(key) + 1);
            }
        }
    }

    private List<Integer> getListPrize(HashMap<Integer, Integer> map){
        Set<Integer> set = map.keySet();
        List<Integer> keyList = new ArrayList<>(set);

        Collections.sort(keyList);
        return keyList;
    }

    private HashMap<Integer, Integer> initMap(){
        return new HashMap<>(){{//초기값 지정
            put(5000, 0);
            put(50000, 0);
            put(1500000, 0);
            put(30000000, 0);
            put(2000000000, 0);
        }};
    }

    private void validBonus(List<Integer>listNum, int bonus){
        validNum(bonus);
        if (listNum.contains(bonus)) {
            throw new IllegalArgumentException(
                    Constant.error + Constant.existNumber
            );
        }
    }

    private int getBonus(List<Integer> listNumber){
        int bonus = strToInt(inputBonus());

        validBonus(listNumber, bonus);
        return bonus;
    }

    private void validNum(int num){
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(
                    Constant.error + Constant.invaildNumber
            );
        }
    }

    private void validArray(String[] array){
        if (array.length != 6) {
            throw new IllegalArgumentException(
                    Constant.error + Constant.invaildLength
            );
        }
    }

    private List<Integer> getListNumber(){
        String[] arrWinning = inputNumbers().split(",");
        List<Integer> listNumber = new ArrayList<>();

        validArray(arrWinning);
        for (String s : arrWinning) {
            int num = strToInt(s);
            validNum(num);
            listNumber.add(num);
        }
        return listNumber;
    }

    public Winning(){
        this.listNumber = getListNumber();
        this.bonus = getBonus(this.listNumber);
        this.map = initMap();
        this.listPrize = getListPrize(map);
    }
}
