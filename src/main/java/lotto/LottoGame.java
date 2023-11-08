package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {
    public static int purchase = 0;
    public static int count;
    public static List<Lotto> lottos = new ArrayList<>();
    public static Lotto winningLotto;
    public static int bonusNumber;
    public static List<Integer> rewardList = Arrays.asList(0,0,0,0,0);
    public static Exception exception = new Exception();

    void StartGame(){
        System.out.println("구입금액을 입력해 주세요.");
        inputPurchase();
        System.out.println("\n"+count+"개를 구매했습니다.");
        printLottos();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        inputWinningNumber();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        inputBonusNumber();
        calculateReward();
        printReward();
    }

    void inputPurchase(){
        checkValidPurchase(readLine());
        count = purchase/1000;
    }

    void checkValidPurchase(String input){
        if(!exception.checkInputIsNumber(input)){
            inputPurchase();
        }
        purchase = Integer.valueOf(input);
        if(!exception.checkValidPurchase(purchase)){
            inputPurchase();
        }
    }

    List<Integer> makeLotto(){
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto);
        return lotto;
    }

    void printLottos(){
        for(int i=0;i<count;i++){
            List<Integer> lotto = makeLotto();
            lottos.add(new Lotto(lotto));
            System.out.println(lotto);
        }
    }

    void inputWinningNumber(){
        List<String> splitInput = Arrays.asList(readLine().split(","));
        List<Integer> splitNumber = new ArrayList<>();
        for(int i=0;i<6;i++){
            String here = splitInput.get(i);
            if(!exception.checkInputIsNumber(here) || !exception.checkInputInRange(here)) {
                inputWinningNumber();
            }
            splitNumber.add(Integer.valueOf(here));
        }
        if(!exception.checkSizeIsSix(splitNumber.size())){
            inputWinningNumber();
        }
        winningLotto = new Lotto(splitNumber);
    }

    void inputBonusNumber(){
        String input = readLine();
        if(!exception.checkInputIsNumber(input) || !exception.checkInputInRange(input)){
            inputBonusNumber();
        }
        bonusNumber = Integer.valueOf(input);
        if(exception.checkDuplication(bonusNumber,winningLotto)){
            inputBonusNumber();
        }
    }

    void calculateReward(){
        for(Lotto lotto : lottos){
            int correct = 0;
            boolean isBonusNumber = false;
            for(int i=0;i<6;i++){
                if(lotto.contain(winningLotto.returnNumber(i))){
                    correct++;
                }
                if(lotto.contain(bonusNumber)){
                    isBonusNumber=true;
                }
            }
            countReward(correct,isBonusNumber);
        }
    }

    void countReward(int correct,boolean isBonusNumber){
        int here=0;
        if(correct==3){
            here = rewardList.get(0);
            rewardList.set(0,here+1);
        }
        if(correct==4){
            here = rewardList.get(1);
            rewardList.set(1,here+1);
        }
        if(correct==5 && !isBonusNumber){
            here = rewardList.get(2);
            rewardList.set(2,here+1);
        }
        if(correct==5 && isBonusNumber){
            here = rewardList.get(3);
            rewardList.set(3,here+1);
        }
        if(correct==6){
            here = rewardList.get(4);
            rewardList.set(4,here+1);
        }
    }

    String calculateEarningRate(){
        return String.format("%.1f",
                (double)((reward.fifth.money*rewardList.get(0))
                +(reward.fourth.money*rewardList.get(1))
                +(reward.third.money*rewardList.get(3))
                +(reward.second.money*rewardList.get(2))
                +(reward.first.money*rewardList.get(4)))
                        /purchase*100);
    }

    void printReward(){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 ("+reward.fifth.formatMoney()+"원) - "+rewardList.get(0)+"개");
        System.out.println("4개 일치 ("+reward.fourth.formatMoney()+"원) - "+rewardList.get(1)+"개");
        System.out.println("5개 일치 ("+reward.third.formatMoney()+"원) - "+rewardList.get(3)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 ("+reward.second.formatMoney()+"원) - "+rewardList.get(2)+"개");
        System.out.println("6개 일치 ("+reward.first.formatMoney()+"원) - "+rewardList.get(4)+"개");
        System.out.println("총 수익률은 "+calculateEarningRate()+"%입니다.");
    }


}
