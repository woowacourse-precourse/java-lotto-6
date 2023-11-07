package lotto;

import lotto.constant.Constant;

import java.util.*;

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

    private void validBonus(List<Integer>listNumber, int bonus){
        validNum(bonus);
        if (listNumber.contains(bonus)) {
            throw new IllegalArgumentException(
                    Constant.error + Constant.existNumber
            );
        }
    }

    public void setBonus(String s){
        int bonus = strToInt(s);

        validBonus(this.listNumber, bonus);
    }

    private void checkDuplication(List<Integer> numbers) {
        List<Integer> l = new ArrayList<>();

        for (int n : numbers) {
            if (l.contains(n)) throw new IllegalArgumentException(
                    Constant.error + Constant.Deduplication);
            l.add(n);
        }
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

    private List<Integer> validate(String[] arr){
        List<Integer> listNumber = new ArrayList<>();

        validArray(arr);
        for (String s : arr) {
            int num = strToInt(s);
            validNum(num);
            listNumber.add(num);
        }
        checkDuplication(listNumber);
        return listNumber;
    }

    public void setListNumber(String s){
        String[] arr = s.split(",");
        this.listNumber = validate(arr);
    }

    public Winning(){
        this.listNumber = new ArrayList<>();
        this.bonus = 0;
        this.map = initMap();
        this.listPrize = getListPrize(this.map);
    }
}
