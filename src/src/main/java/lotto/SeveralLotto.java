package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeveralLotto {

    ArrayList<Lotto> manyLotto;
    int numberOfLotto; //로또 개수

    SeveralLotto(int number){
        this.numberOfLotto = number;
        manyLotto =  new ArrayList<Lotto>();
        makeAllLotto();
        printAllLotto();
    }

    public List<Integer> getSixRandomNumbers(){
        List<Integer> sixNumber = new ArrayList<Integer>();
        sixNumber = Randoms.pickUniqueNumbersInRange(ConstantCollection.LOTTO_NUMBER_MIN,
                ConstantCollection.LOTTO_NUMBER_MAX, ConstantCollection.NUMBER_IN_LOTTO);
        Collections.sort(sixNumber);

        return sixNumber;
    }

    public Lotto makeOneLotto(){
        return new Lotto(getSixRandomNumbers());
    }

    public void makeAllLotto(){ //로또 numberOfLotto 만큼 만들기
        for(int i=0; i<numberOfLotto; i++){
            manyLotto.add(makeOneLotto());
        }
    }

    public void printAllLotto(){
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");
        for (Lotto eachLotto : manyLotto) {
            eachLotto.printNumbers();
        }
    }



}
