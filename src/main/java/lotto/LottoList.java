package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final int number_of_lotto;
    private List<Lotto> lottoList;

    public LottoList(int purchaseAmount) {
        this.number_of_lotto = purchaseAmount / 1000;
    }

    public int getNumber_of_lotto() {
        return number_of_lotto;
    }

    public int getLottoListSize() {
        return lottoList.size();
    }

    public void printNumberOfLotto(){
        System.out.println("\n" + number_of_lotto + "개를 구매했습니다.");
    }
    private List<Integer> pickLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void createLottoList(){
        lottoList = new ArrayList<>();
        for(int i = 1; i <= number_of_lotto; i++) {
            List<Integer> picked_numbers = pickLottoNumbers();
            try {
                Lotto lotto = new Lotto(picked_numbers);
                lottoList.add(lotto);
            } catch (IllegalArgumentException e){
                System.out.println("[Error] " + e.getMessage() + " " + i + "번 로또를 재발행합니다.");
                i--;
            }
        }
    }

    public void printLottoList(){
        for(Lotto lotto : lottoList){
            lotto.printNumbers();
        }
    }
}
