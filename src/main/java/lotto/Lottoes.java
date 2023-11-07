package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {
    private final int number_of_lottoes;
    public static List<Lotto> lottoes = new ArrayList<>();

    public Lottoes(int numberOfLottoes) {
        this.number_of_lottoes = numberOfLottoes;
    }

    public void print_numberOfLottoes(){
        System.out.println("\n" + number_of_lottoes + "개를 구매했습니다.");
    }
    private List<Integer> pickLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void createLottoes(){
        for(int i = 1; i <= number_of_lottoes; i++) {
            List<Integer> picked_numbers = pickLottoNumbers();
            try {
                Lotto lotto = new Lotto(picked_numbers);
                lottoes.add(lotto);
            } catch (IllegalArgumentException e){
                System.out.println("[Error] " + e.getMessage() + " " + i + "번 로또를 재발행합니다.");
                i--;
            }
        }
    }

    public void printLottoes(){
        for(Lotto lotto : lottoes){
            lotto.printNumbers();
        }
    }
}
