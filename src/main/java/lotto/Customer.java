package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer 클래스는 복권 티켓을 구매하고 결과를 확인하는 고객을 나타낸다.
 */
public class Customer {
    private Lotto[] lottos; // 구매한 복권의 배열
    private List<Integer> winninglotto; // 당첨 번호 리스트
    private int lotto_count, bonus_number, money, total_reward;
    private final int[] winner_count = new int[6]; // 당첨된 등수의 복권 수

    /**
     * Customer 클래스의 생성자. 복권 티켓을 구매하고 당첨 번호를 입력한 후 결과를 알린다.
     */
    public Customer(){
        purchaseLotto();
        getNumber();
        informResult();
    }

    /**
     * 당첨 결과를 알리며, 각 복권의 당첨 등수 및 총 수익률을 출력한다.
     */
    private void informResult(){
        System.out.println("\n당첨 통계\n---");
        checklotto();
        broadcastWinner();
        System.out.printf("총 수익률은 %,.1f", getRate() * 100);
        System.out.println("%입니다.");
    }

    /**
     * 각 상금 당첨자 수를 출력한다.
     */
    private void broadcastWinner(){
        System.out.println(Rank.FIFTH.label() + " - " + winner_count[5] + "개");
        System.out.println(Rank.FOURTH.label() + " - " + winner_count[4]+ "개");
        System.out.println(Rank.THIRD.label() + " - " + winner_count[3]+ "개");
        System.out.println(Rank.SECOND.label() + " - " + winner_count[2]+ "개");
        System.out.println(Rank.FIRST.label() + " - " + winner_count[1]+ "개");
    }

    /**
     * 총 수익률을 계산하여 반환한다.
     */
    private double getRate(){
        return (double)total_reward / (double)money;
    }

    /**
     * 주어진 Rank(등수)에 해당하는 당첨 번호 인덱스를 반환한다.
     * @param lotto Rank(등수)
     * @return 당첨 번호 인덱스
     */
    private int findWinner(Rank lotto){
        if(lotto == Rank.FIRST)
            return 1;
        if(lotto == Rank.SECOND)
            return 2;
        if(lotto == Rank.THIRD)
            return 3;
        if(lotto == Rank.FOURTH)
            return 4;
        if(lotto == Rank.FIFTH)
            return 5;
        return 0;
    }

    /**
     * 각 복권 티켓을 확인하고, 총 수익 및 각 당첨 복권 수를 업데이트한다.
     */
    private void checklotto(){
        for (Lotto lotto : lottos) {
            Rank rank = lotto.checkPlace(winninglotto, bonus_number);
            total_reward += rank.reward();
            winner_count[findWinner(rank)]++;
        }
    }

    /**
     * 당첨 번호와 보너스 번호를 입력한다.
     */
    private void getNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        getWinningNum();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        getBonusNum();
    }

    /**
     * 보너스 번호를 입력받고 저장한다.
     */
    private void getBonusNum(){
        bonus_number = Integer.parseInt(Console.readLine());
    }

    /**
     * 당첨 번호를 입력받고 저장한다.
     */
    private void getWinningNum(){
        String input = Console.readLine();
        String[] tmp = input.split(",");

        winninglotto = new ArrayList<>();
        for(int i = 0; i < 6; ++i)
            winninglotto.add(Integer.parseInt(tmp[i]));
    }

    /**
     * 구입 금액을 입력하고, 복권을 구매한다.
     */
    private void purchaseLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        lotto_count = getMoney() / 1000;

        System.out.println("\n" + lotto_count + "개를 구매했습니다.");
        createLotto();
    }

    /**
     * 구매한 복권을 생성한다.
     */
    private void createLotto(){
        lottos = new Lotto[lotto_count];
        for(int i = 0; i < lotto_count; ++i) {
            List<Integer> number = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos[i] = new Lotto(number);
            lottos[i].sortNumber();
            lottos[i].showNumber();
        }
    }

    /**
     * 구입 금액을 입력하고 유효성을 검사한 후 반환한다.
     * @return 구입 금액
     */
    private int getMoney(){
        readInput();
        checkMoney();

        return money;
    }

    /**
     * 입력된 금액이 유효한지 확인한다.
     */
    private void checkMoney(){
        try{
            if(money % 1000 != 0)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 잘못된 금액입니다. 다시 입력해주세요.");
            getMoney();
        }
    }
    /**
     * 사용자로부터 입력을 받아, 금액을 저장한다.
     * 만약 사용자의 입력이 숫자가 아닌 다른 문자가 올 경우, 다시 입력 받는다.
     */
    private void readInput(){
        while(true){
            try{
                money = Integer.parseInt(Console.readLine());
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 숫자만 입력해주세요. 다시 입력해주세요.");
            }
        }
    }
}
