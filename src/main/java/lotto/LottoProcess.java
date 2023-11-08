package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoProcess {
    private static final int numLottoNum = 6;
    private int quantityLotto;
    private Lotto[] lottos;
    
    public void setNumLotto() {
        quantityLotto = new BuyLotto().BuyLotto();
        printLotto();
    }

    public void printLotto() {
        System.out.println("\n" + quantityLotto + "개를 구매했습니다.");
        issueLotto();
    }

    public void issueLotto() {
        lottos = new Lotto[numLottoNum];
        for (int i = 0; i < quantityLotto; i++) {
            List<Integer> lottoNumbers = generateLottoNum();
            System.out.println(lottoNumbers);
            lottos[i] = new Lotto(lottoNumbers);
        }
    }

    public List<Integer> generateLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

}
