package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    private final int money;
    private static final int PRICE=1000;
    private final List<Lotto> lottos = new ArrayList<>();
    private final List<Integer> results = new ArrayList<>(Collections.nCopies(6,0));
    private float earn=0;
    private final List<Integer> winNumbers = new ArrayList<>();
    private int bonusNumber;

    public Game(String moneyString){
        moneyValidCheck(moneyString);
        this.money = Integer.parseInt(moneyString);
        for (int i = 0; i < money/PRICE; i++) {
            makeLotto();
        }
        printLotto();
    }

    public void setBonusNumber(String numberString){
        bonusNumberValidate(numberString);
        this.bonusNumber = Integer.parseInt(numberString);
    }

    private void bonusNumberValidate(String bonusString){
        int bonusNumber;
        try{
            bonusNumber = Integer.parseInt(bonusString);
        }catch(Exception e){
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        if(winNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("겹치는 숫자가 있습니다.");
        }
    }

    public void setWinNumbers(String numbersString){
        winNumberValidCheck(numbersString);
        String[] split = numbersString.split(",");
        for (String s:split) {
            winNumbers.add(Integer.parseInt(s));
        }
    }

    private void winNumberValidCheck(String winNumber){
        String[] split = winNumber.split(",");
        List<Integer> numbers = new ArrayList<>();
        if(split.length!=6){
            throw new IllegalArgumentException("입력값의 개수가 맞지 않습니다.");
        }
        for (String numberString:split) {
            int number;
            try{
                number = Integer.parseInt(numberString);
            }catch(Exception e){
                throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
            }
            if(number<1 || number>45){
                throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
            }
            numbers.add(number);
        }
        if(numbers.stream().distinct().count()!=6){
            throw new IllegalArgumentException("겹치는 숫자가 있습니다.");
        }
    }

    private void moneyValidCheck(String moneyString){
        int buyMoney;
        try{
            buyMoney = Integer.parseInt(moneyString);
        }catch(Exception e){
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        if(buyMoney%PRICE>0){
            throw new IllegalArgumentException("1000의 단위로 입력해 주세요.");
        }
    }

    private void makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottos.add(new Lotto(numbers));
    }

    private void printLotto(){
        System.out.printf("%d개를 구매했습니다.\n",this.money/PRICE);
        for (Lotto lotto:lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    private void Result(){
        for (Lotto lotto:lottos) {
            PRIZE win = lotto.Score(winNumbers,bonusNumber);
            results.set(win.getScore(),results.get(win.getScore())+1);
            earn+=win.getValue();
        }
    }

    public void printResult(){
        Result();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%s) - %d개\n",PRIZE.FIFTH,results.get(4));
        System.out.printf("4개 일치 (%s) - %d개\n",PRIZE.FORTH,results.get(3));
        System.out.printf("5개 일치 (%s) - %d개\n",PRIZE.THIRD,results.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s) - %d개\n",PRIZE.SECOND,results.get(1));
        System.out.printf("6개 일치 (%s) - %d개\n",PRIZE.FIRST,results.get(0));

        System.out.printf("총 수익률은 %,.1f%s입니다.",earn/money*100,"%");
    }
}
