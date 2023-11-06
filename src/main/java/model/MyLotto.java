package model;

import java.util.ArrayList;
import java.util.List;
import util.NumberGenerator;

public class MyLotto {

    int lottoPaper;
    public NumberGenerator numberGenerator = new NumberGenerator();
    ArrayList<List<Integer>> myLottoNumber = new ArrayList<>();


    public void buyLotto(int lottoCost){
        lottoPaper = lottoCost/1000;
    }

    public int getLottoPaper(){
        return lottoPaper;
    }

    public ArrayList<List<Integer>> getMyLottoNumber(){
        return myLottoNumber;
    }

    public void createMyLottoNumber(int lottoPaper){
        for(int i = 0; i<lottoPaper; i++){
            myLottoNumber.add(numberGenerator.generate());
        }
    }

}
