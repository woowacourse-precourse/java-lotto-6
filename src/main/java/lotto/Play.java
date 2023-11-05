package lotto;

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
        String input = readLine();
        for(int i =0;i<input.length();i++){
            if(input.charAt(i)<'0' || input.charAt(i)>'9' ){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
        return Integer.parseInt(input);
    }
    public String inputStr(){
        return readLine();
    }

    public void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        money=inputInt();
        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 천원단위로 입력해주세요.");
        }
    }
    public void inputCount(){
        count=money/1000;
    }

    public void inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber=inputInt();
        if(winNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 로또번호중 하나와 중복됩니다.");
        }
    }

    public void inputWinNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String carNameList = inputStr();
        String[] arrayString = carNameList.split(",");
        int[] num = Arrays.stream(arrayString).mapToInt(Integer::parseInt).toArray();

        if(num.length!=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리만 입력해야 합니다.");
        }

        for(int i : num){
            if(i<1 || i>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
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

        System.out.println("\n당첨 통계");
        System.out.println("---");
        lotto.printMatchingNumbers();
        lotto.printRateOfReturn();
    }

}
