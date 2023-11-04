package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Play {
    public int money = 0;
    public int count = 0;
    public List<Integer> winNumber=new ArrayList<>();
    public int bonusNumber=0;

    public int inputInt(){
        return Integer.parseInt(readLine());
    }
    public String inputStr(){
        return readLine();
    }
    public void inputMoney(){
        money=inputInt();
    }
    public void inputCount(){
        count=money/1000;
    }
    public void inputBonusNumber(){
        bonusNumber=inputInt();
    }
    public void inputWinNumber(){
        String carNameList = inputStr();
        String[] arrayString = carNameList.split(",");
        int[] num = Arrays.stream(arrayString).mapToInt(Integer::parseInt).toArray();
        for(int i : num){
            winNumber.add(i);
        }
    }

    public void playLotto(){

        inputMoney();
        inputCount();

        Papers papers=new Papers();
        papers.createPapers(count);
        papers.printPapers();

        inputWinNumber();
        inputBonusNumber();

        Lotto lotto = new Lotto(winNumber);

        papers.creatCorrespondNum(lotto.getLottoNumbers(),bonusNumber);
        papers.creatWinMoney();
        lotto.saveMatchingNumbers(papers.papers);
        lotto.saveRateOfReturn(papers.papers,money);


        lotto.printMatchingNumbers();
        lotto.printRateOfReturn();
    }

}
