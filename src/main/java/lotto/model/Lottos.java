package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoGrade;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<Lotto>();
    }

    public void generate(Integer number) {
        for (int i = 0; i < number; i++) {
            lottos.add(Lotto.generateLotto());
        }
    }

    public Map<LottoGrade, Integer> calculateLottoGrades(WinningLotto winningLotto) {
        Map<LottoGrade, Integer> grades = new HashMap<LottoGrade, Integer>();
        for (Lotto lotto : lottos) {
            LottoGrade lottoGrade = winningLotto.determineLottoGrade(lotto);
            grades.put(lottoGrade, grades.getOrDefault(lottoGrade, 0) + 1);
        }

        return grades;
    }

    @Override
    public String toString() {
        String ret = new String();

        for (Lotto lotto : lottos) {
            ret += lotto.toString() + "\n";
        }
        return ret;
    }
}
