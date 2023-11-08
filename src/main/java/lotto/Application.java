package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static final int NUM_OF_LOTTO_NUMBERS = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

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

        if ((paying % 1000) != 0) {
            throw new IllegalArgumentException();
        }

        return paying % 1000;
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

    public static void lottery(int lottoCount, Lotto[] lottos, Winner winner) {
        int winCount;
        int bonusCount;
        List<Integer> wins = new ArrayList<Integer>(NUM_OF_LOTTO_NUMBERS + 1);

        for (int i = 0; i < lottoCount; i++) {
            winCount = lottos[i].lottery(winner.winNums);
            bonusCount = lottos[i].lottery(winner.bonusNum);
        }

        System.out.printf("\n당첨 통계\n---\n");
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
