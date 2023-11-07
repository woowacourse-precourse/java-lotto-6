package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class UserData {
    public int money;
    public int lottoCount;
    public List<Lotto> userLotto;
    public double returnRate;
    public int[] userRanks = new int[5];
    public int[] prize = {2000000000, 30000000, 1500000, 50000, 5000};
    public int earn = 0;

    public UserData(){
        inputMoney();
        setLottoCount();

        setUserLotto();
    }

    public void inputMoney(){
        String rawMoney = Console.readLine();
        validateMoney(rawMoney);
        money = Integer.parseInt(rawMoney);
    }

    public void validateMoney(String raw){
        try {
            if(Integer.parseInt(raw) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액의 단위는 1000원 이어야 합니다.");
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수여야 합니다.");
        }
    }

    public void setLottoCount(){
        lottoCount = money / 1000;
    }

    public Lotto getRandomLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public void setUserLotto(){
        userLotto = new ArrayList<>(lottoCount);
        for(int i = 0; i<lottoCount; i++){
            userLotto.add(getRandomLotto());
        }
    }

    public void printUserLotto(){
        for(int i = 0;i<lottoCount;i++){
            userLotto.get(i).printLotto();
        }
    }

    public void checkLotto(WinLotto winLotto, Lotto userLotto){
        int countExistNum, rank;
        int flag = 0;

        countExistNum = winLotto.winLotto.countExistNumber(userLotto);
        if(countExistNum == 6){
            flag = 1;
        }

        if (userLotto.isExistNumber(winLotto.bonus)){
            countExistNum++;
        }

        rank = checkRank(countExistNum, flag);
        if(rank != 0){
            userRanks[rank-1]++;
        }
    }

    public int checkRank(int count, int flag){
        if(flag == 1) return 1;
        if(flag == 0 && count == 5) return 2;
        if(count == 5) return 3;
        if(count == 4) return 4;
        if(count == 3) return 5;
        return 0;
    }

    public void printRanks(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", userRanks[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", userRanks[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", userRanks[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", userRanks[1]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", userRanks[0]);
    }

    public void calculateEarn(){
        for(int i= 0;i<5;i++){
            earn += userRanks[i] * prize[i];
        }
    }

    public void calculateReturnRate(){
        calculateEarn();
        System.out.println((double)earn);
        System.out.println((double)money);
        returnRate = (double) earn/(double) money*100;
        System.out.println(returnRate);
    }
}
