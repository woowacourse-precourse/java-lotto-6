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
    static int amount;

    public Controller() {
        this.service = new Service();
    }

    public void buyingLotto() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int price = Integer.parseInt(Console.readLine());
                if (price % 1000 != 0) throw new IllegalArgumentException();
                amount= price/1000;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 입력값입니다.");
            }
        }
        System.out.println("\n"+amount+"개를 구매했습니다.");
    }

    public void lottoDraw() {
        List<List<Integer>> lottoNum = service.lottoDraw(amount);
        for (List<Integer> num : lottoNum) {
            System.out.println("[" + num.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]");
        }
    }

    public void drawLottoWinningNumber() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String[] split = Console.readLine().split(",");
                lotto = service.saveWinningNumbers(split);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" +e.getMessage());
            }
        }
    }

    public void drawLottoBonusNumber() {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요");
            try {
                bonusNum = Integer.parseInt(Console.readLine());
                if (bonusNum < 1 || bonusNum > 45) {
                    throw new IllegalArgumentException("1부터 45사이의 수를 입력해야 합니다.");
                }
                lotto.checkBonusNum(bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] "+e);
            }
        }
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

    public void findRateOfReturn() {
        double rateOfReturn = service.findRateOfReturn();
        System.out.printf("총 수익률은 %.1f%%입니다." ,rateOfReturn/(amount*10));
    }
}