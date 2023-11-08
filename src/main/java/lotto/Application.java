package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static final int NUM_OF_LOTTO_NUMBERS = 6;

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
        for (int i=0; i<lottoCount; i++){
            numbers = getNumbers();
            numbers.sort(Comparator.naturalOrder());
            lottos[i] = new Lotto(numbers);
            System.out.println(numbers);
        }

        return lottos;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoCount;
        Lotto[] lottos;
        
        lottoCount = buying();
        lottos = getLottos(lottoCount);

    }
}
