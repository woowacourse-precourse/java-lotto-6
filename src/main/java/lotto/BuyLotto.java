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
        int result = 0;
        for (int p = 0, a = 0; (p > 5 || a > 5); ) {
            if (paper.get(p).equals(answer_number.get(a))) {
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
        result = calculateRank(correct_number, bonus_number);
        return result;
    }

    public List<Integer> lottoRankInit() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            result.add(0);
        }
        return result;
    }

    public List<Integer> lottoRankEdit(List<Integer> rank, int rank_num) {
        if (rank_num == 7) {
            rank.set(4, rank.get(4) + 1);
        }
        if (rank_num == 6) {
            rank.set(3, rank.get(3) + 1);
        }
        if (rank_num == 5) {
            rank.set(2, rank.get(2) + 1);
        }
        if (rank_num == 4) {
            rank.set(1, rank.get(1) + 1);
        }
        if (rank_num == 3) {
            rank.set(0, rank.get(0) + 1);
        }
        return rank;
    }

    public List<Integer> lottoRank(List<Integer> answer_number, int bonus) {
        List<Integer> result = lottoRankInit();
        for (int i = 0; i < lotto.size(); i++) {
            List<Integer> paper = lotto.get(i).getLotto();
            int rank = paperRank(paper, answer_number, bonus);
            result = lottoRankEdit(result, rank);
        }
        return result;
    }
}
