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

    public int calculateRank(int correct_number, int bonus) {
        int result = correct_number;
        if (correct_number == 6) {
            result = 7;
        }
        if (correct_number == 5 && bonus == 1) {
            result = 6;
        }
        if (correct_number < 3) {
            result = 0;
        }
        return result;
    }

    public int paperRank(List<Integer> paper, List<Integer> answer_number, int bonus) {
        int correct_number = 0;
        int bonus_number = 0;
        int result=0;
        for (int p = 0, a = 0; p < 6 || a < 6; ) {
            if (paper.get(p) == answer_number.get(a)) {
                correct_number++;
                p++;
                a++;
            }
            if (paper.get(p) == bonus) {
                bonus_number++;
            }
            if (paper.get(p) < answer_number.get(a)) {
                p++;
            }
            if (answer_number.get(a) < paper.get(p)) {
                a++;
            }
        }
        result = calculateRank(correct_number,bonus_number);
        return result;
    }
}
