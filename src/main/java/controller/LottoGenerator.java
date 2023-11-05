package controller;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    //로또 생성을 담당하는 클래스

    private int lottoCount;

    public LottoGenerator(int price) {
        lottoCount = price / 1000;
    }

    public List<Integer> createLotto(){
        List<Integer> test = new ArrayList<>();
        return test;
    }


}
