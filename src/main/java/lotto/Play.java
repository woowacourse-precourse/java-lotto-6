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
    boolean check;

    public int inputInt(){
        String input = null;
        check=true;
        while(check){
            input=readLine();
            check=isNumeric(input);
        }
        return Integer.parseInt(input);
    }

    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
            return true;
        }

        for (int i = 0; i < str.length(); i++) {

            if (!Character.isDigit(str.charAt(i))) {
                System.out.println("[ERROR] 숫자만 입력해 주세요.");
                return true;
            }
        }

        return false;
    }
    public String inputStr(){
        return readLine();
    }

    public void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        check=true;
        while(check){
            money=inputInt();
            check=isThousand();
        }
    }

    public boolean isThousand(){
        if(money%1000==0)
            return false;
        System.out.println("[ERROR] 천원단위로 입력해 주세요.");
        return true;
    }
    public void inputCount(){
        count=money/1000;
    }

    public void inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        check=true;
        while(check){
            while(check) {
                bonusNumber = inputInt();
                check = isValidBonus();
            }
            check=isDuplicate();
        }
    }

    public boolean isDuplicate(){
        if(winNumber.contains(bonusNumber)){
            System.out.println("[ERROR] 로또번호와 다른 번호를 입력해야 합니다.");
            return true;
        }
        return false;
    }

    public boolean isValidBonus(){
        if(bonusNumber<1 || bonusNumber>45){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return true;
        }
        return false;
    }

    public void inputWinNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String carNameList;
        String[] arrayString = new String[0];
        check=true;
        while(check){
            while(check){
                carNameList = inputStr();
                arrayString = carNameList.split(",");
                check=isCount(arrayString);
            }

            int[] num = Arrays.stream(arrayString).mapToInt(Integer::parseInt).toArray();
            check=isValidLotto(num);
            winNumber.clear();
            for(int i : num){
                winNumber.add(i);
            }
        }
    }
    public boolean isCount(String[] strings){
        if(strings.length==6){
            return false;
        }
        System.out.println("[ERROR] 로또 번호는 6자리만 입력해야 합니다.");
        return true;
    }
    public boolean isValidLotto(int[] num){
        for(int i : num){
            if(i<1 || i>45){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                return true;
            }
        }
        return false;
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
