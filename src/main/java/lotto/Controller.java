package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.PrizeM;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private final Service service;
    static int bonusNum;
    static Lotto lotto;

    public Controller() {
        this.service = new Service();
    }

    public void buyingLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        int amount= price/1000;
        System.out.println("\n"+amount+"개를 구매했습니다.");
        List<List<Integer>> lottoNum = service.lottoDraw(amount);
        for (List<Integer> num : lottoNum) {
            System.out.println("[" + num.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]");
        }
    }

    public void drawLottoWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] split = Console.readLine().split(",");
        System.out.println("\n보너스 번호를 입력해 주세요");
        bonusNum = Integer.parseInt(Console.readLine());
        lotto = service.saveWinningNumbers(split);
    }


    public void lotteryForWinners() {
        System.out.println("\n당첨 통계\n" + "---");
        int[] winner = service.findWinner(lotto, bonusNum);
        System.out.println("3개 일치 "+ PrizeM.FIVE.getValue()+" - "+winner[3]+"개");
        System.out.println("4개 일치 "+ PrizeM.FOUR.getValue()+" - "+winner[4]+"개");
        System.out.println("5개 일치 "+ PrizeM.THREE.getValue()+" - "+winner[5]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 "+ PrizeM.TWO.getValue()+" - "+winner[7]+"개");
        System.out.println("6개 일치 "+ PrizeM.ONE.getValue()+" - "+winner[6]+"개");
    }
}