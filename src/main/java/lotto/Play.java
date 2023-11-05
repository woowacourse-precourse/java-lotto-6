package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Play {
    private static final String ERROR_NUMBER= "[ERROR] 숫자만 입력해 주세요.";
    private static final String ERROR_THOUSAND= "[ERROR] 천원단위로 입력해 주세요.";
    private static final String ERROR_DUPLICATE= "[ERROR] 로또번호와 다른 번호를 입력해야 합니다.";
    private static final String ERROR_VALIDNUMBER= "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_VALIDLENGTH= "[ERROR] 로또 번호는 6자리만 입력해야 합니다.";
    private static final String ERROR_LOTTODUPLICATENUMBER= "[ERROR] 로또 번호가 중복되었습니다.";

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
            try{
                check=isNumeric(input);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NUMBER);
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw new IllegalArgumentException(ERROR_NUMBER);
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
            try{
                money=inputInt();
                check=true;
                isThousand();
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void isThousand(){
        if(money%1000==0) {
            check = false;
        }
        throw new IllegalArgumentException(ERROR_THOUSAND);
    }
    public void inputCount(){
        count=money/1000;
    }

    public void inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        check=true;
        while(check){
            try{
                bonusNumber = inputInt();
                check=true;
                isDuplicate();
                isValidBonus();
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void isDuplicate(){
        if(winNumber.contains(bonusNumber)){
            check=true;
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
        check=false;
    }
    public void isValidBonus(){
        if(check){
            return;
        }
        if(bonusNumber<1 || bonusNumber>45){
            check=true;
            throw new IllegalArgumentException(ERROR_VALIDNUMBER);
        }
        check=false;
    }

    public void inputWinNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String carNameList;
        String[] arrayString;
        check=true;
        while(check){
            try{
                carNameList = inputStr();
                arrayString = carNameList.split(",");
                int[] num = Arrays.stream(arrayString).mapToInt(Integer::parseInt).toArray();

                isCount(arrayString);
                isValidLotto(num);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }

    public void isCount(String[] strings){
        if(strings.length==6){
            check=false;
            return;
        }
        throw new IllegalArgumentException(ERROR_VALIDLENGTH);
    }
    public void isValidLotto(int[] num){
        if(check){
            return;
        }

        for(int i : num){
            if(i<1 || i>45){
                check=true;
                throw new IllegalArgumentException(ERROR_VALIDNUMBER);
            }
        }

        winNumber.clear();
        for(int i : num){
            winNumber.add(i);
        }
        check=false;
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
