package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int lottoCount;
    private int lottoPrice;
    private List<Lotto> lottos;
    private List<Integer> ratings;
    private int totalPrize;

    public User() {
        lottos = new ArrayList<>();
        ratings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ratings.add(0);
        }
        totalPrize = 0;
    }

    private void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputText = Console.readLine();
        try {
            Validator.buyCheck(inputText);
            lottoPrice = Integer.parseInt(inputText);
            lottoCount = lottoPrice / 1000;
        } catch (IllegalArgumentException e) {
            buyLotto();
        }
    }

    public void getLotto() {
        buyLotto();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        printLotto();
    }

    private void printLotto() {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            lottos.get(i).printLottoNumber();
        }
    }

    public void calculate(List<Integer> targetNumbers, int bonusNumber) {
        for (int i = 0; i < lottoCount; i++) {
            int rate = lottos.get(i).calcMatch(targetNumbers,bonusNumber);
            ratings.add(rate-1,ratings.get(rate-1)+1);
        }
        calcPrize();
        printMatch();
        printBenefit();
    }
    private int money(int num){
        if(num == 1){
            return 200000000;
        }
        if(num == 2){
            return 30000000;
        }
        if(num == 3){
            return 1500000;
        }
        if(num == 4){
            return 50000;
        }
        if(num == 5){
            return 5000;
        }
        return 0;
    }

    private void calcPrize() {
        for (int i = 0; i < 5; i++) {
            totalPrize += money(ratings.get(i));
        }
    }

    private void printMatch(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ratings.get(4)+"개");
        System.out.println("4개 일치 (50,000원) - "+ratings.get(3)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ratings.get(2)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ratings.get(1)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ratings.get(0)+"개");
    }

    private void printBenefit(){
        double benefit = totalPrize/lottoPrice*100;
        System.out.println("총 수익률은 "+Math.round(benefit*10)/10.0+"%입니다.");
    }
}
