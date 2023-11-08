package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static final int PRICE_OF_LOTTO = 1000;
    public static final int NUM_OF_LOTTO_NUMBERS = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public static final int NUM_OF_RANKS = 5;
    public enum Ranks {
        FIRST, SECOND, THIRD, FOURTH, FIFTH
    }
    public static class Rewards {
        public static final int First = 2000000000;
        public static final int Second = 30000000;
        public static final int Third = 1500000;
        public static final int Fourth = 50000;
        public static final int Fifth = 5000;

        public static final int[] rewards = {First, Second, Third, Fourth, Fifth};
    }

    public static class Winner {
        List<Integer> winNums = new ArrayList<Integer>();
        int bonusNum = 0;

        public Winner() {
            this.winNums = new ArrayList<Integer>();
            this.bonusNum = 0;
        }
    }

    public static int strToNum(String inp) {
        int num;

        try {
            num = Integer.parseInt(inp);
        }
        catch (NumberFormatException exp){
            throw new IllegalArgumentException();
        }

        return num;
    }

    public static int isBuyingValid(String inp) {
        int paying = strToNum(inp);

        if ((paying % PRICE_OF_LOTTO) != 0) {
            throw new IllegalArgumentException();
        }

        return paying % PRICE_OF_LOTTO;
    }

    public static int buying() {
        String inp;
        int lottoCount;

        System.out.println("구입금액을 입력해 주세요.");

        inp = camp.nextstep.edu.missionutils.Console.readLine();
        lottoCount = isBuyingValid(inp);
        
        System.out.printf("\n%d개를 구매했습니다.\n", lottoCount);
    
        return lottoCount;
    }

    public static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();

        for (int i=0; i<NUM_OF_LOTTO_NUMBERS; i++){
            numbers.add(Randoms.pickNumberInRange(1, 45));
        }

        return numbers;
    }

    public static Lotto[] getLottos(int lottoCount) {
        Lotto[] lottos = new Lotto[lottoCount];

        List<Integer> numbers;
        for (int i = 0; i < lottoCount; i++){
            numbers = getNumbers();
            numbers.sort(Comparator.naturalOrder());
            lottos[i] = new Lotto(numbers);
            System.out.println(numbers);
        }

        return lottos;
    }

    public static int isLottoNumValid(String inp) {
        int num = strToNum(inp);

        if ((num < MIN_LOTTO_NUMBER) || (MAX_LOTTO_NUMBER < num)) {
            throw new IllegalArgumentException();
        }

        return num;
    }

    public static List<Integer> isWinnersValid(String inp) {
        List<Integer> winNums = new ArrayList<Integer>();

        if (!inp.contains(",")) {
            throw new IllegalArgumentException();
        }

        String[] ArraysInp = inp.split(",");

        if (ArraysInp.length != 6) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < ArraysInp.length; i++) {
            winNums.add(isLottoNumValid(ArraysInp[i]));
        }

        return winNums;
    }

    public static Winner getWinner() {
        Winner winner = new Winner();
        
        System.out.println("당첨 번호를 입력해 주세요.");
        winner.winNums = isWinnersValid(camp.nextstep.edu.missionutils.Console.readLine());

        System.out.printf("\n보너스 번호를 입력해 주세요.\n");
        winner.bonusNum = isLottoNumValid(camp.nextstep.edu.missionutils.Console.readLine());

        return winner;
    }

    public static int[] calWins(int[] wins, int winCount, int bonusCount) {
        if (winCount == 6) {
            wins[Ranks.FIRST.ordinal()]++;
        } 
        if ((winCount == 5) && (bonusCount == 1)) {
            wins[Ranks.SECOND.ordinal()]++;
            return wins;
        }
        if (winCount == 5) {
            wins[Ranks.THIRD.ordinal()]++;
        }
        if (winCount == 4) {
            wins[Ranks.FOURTH.ordinal()]++;
        } 
        if (winCount == 3) {
            wins[Ranks.FIFTH.ordinal()]++;
        } 
        return wins;
    }

    public static void printWins(int[] wins) {
        System.out.printf("\n당첨 통계\n---\n");

        System.out.printf("3개 일치 (5,000원) - %d개\n", wins[Ranks.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", wins[Ranks.THIRD.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", wins[Ranks.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", wins[Ranks.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", wins[Ranks.FIRST.ordinal()]);
    }

    public static void printRate(int lottoCount, int[] wins) {
        int payed = lottoCount * PRICE_OF_LOTTO;

        int totalRewards = 0;
        for (int i = 0; i < NUM_OF_RANKS; i++) {
            totalRewards = totalRewards + (wins[i] * Rewards.rewards[i]);
        }

        System.out.printf("총 수익률은 %2f입니다.\n", totalRewards / payed);
    }

    public static void lottery(int lottoCount, Lotto[] lottos, Winner winner) {
        int[] wins = {0, 0, 0, 0, 0};

        for (int i = 0; i < lottoCount; i++) {
            wins = calWins(wins, lottos[i].lottery(winner.winNums), lottos[i].lottery(winner.bonusNum));
        }

        printWins(wins);
        printRate(lottoCount, wins);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoCount;
        Lotto[] lottos;
        Winner winner;
        
        lottoCount = buying();
        lottos = getLottos(lottoCount);
        winner = getWinner();

        lottery(lottoCount, lottos, winner);
    }
}
