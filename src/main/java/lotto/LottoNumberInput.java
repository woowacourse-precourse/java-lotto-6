package lotto;

import java.util.List;

public class LottoNumberInput {
    List<Integer> numbers;
    int countNum;
    int bonusNum;
    public void run (){
        moneyInput();
        numberInput();
        LottoGenerator lotto = new LottoGenerator(numbers,countNum,bonusNum);
    }

    private void moneyInput(){

    }

    private void numberInput(){

    }
}
