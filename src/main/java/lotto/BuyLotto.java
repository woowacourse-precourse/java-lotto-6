package lotto;

import Output.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    private static List<Lotto> lotto = new ArrayList<>();
    private static Output output = new Output();

    public void buyAllLotto(int money) {
        for (int i = 0; i < money; i++) {
            Lotto paper = new Lotto(pickNumber());
            lotto.add(paper);
        }
        output.lottoAllPaperPrint(lotto);
    }

    public List<Integer> pickNumber() {
        List<Integer> paper = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(paper);
        return paper;
    }

    public boolean checkSameNumber(List<Integer> paper, int number) {
        boolean result = true;
        for (int i = 0; i < paper.size(); i++) {
            if (paper.get(i) == number) {
                result = false;
                break;
            }
        }
        return result;
    }
}
