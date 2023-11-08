package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private final List<Lotto> lottos;
    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public Referee(List<Lotto> lottos, WinningNumbers winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Grade> calculateGrades() {
        List<Grade> grades = new ArrayList<>();
        for(Lotto lotto : lottos) {
            int matchCount = getWinningNumberMatchCount(lotto);
            int bonusCount = getBonusNumberMatchCount(lotto);
            Grade grade = Grade.findGrade(matchCount, bonusCount);
            if (grade != null) {
                grades.add(grade);
            }
        }
        return grades;
    }

    public Map<String, Integer> getStatics(List<Grade> grades) {
        Map<String, Integer> map = new LinkedHashMap();
        map.put("3",0);
        map.put("4",0);
        map.put("5",0);
        map.put("5+B",0);
        map.put("6",0);
        for(Grade grade: grades) {
            int value = map.get(grade.getRank());
            map.put(grade.getRank(), value+1);
        }
        return map;
    }

    public int getWinningNumberMatchCount(Lotto lotto) {
        int winNumberMatchCount = 0;
        for (String winningNumber : winningNumbers.getNumbers()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                winNumberMatchCount++;
            }
        }
        return winNumberMatchCount;
    }

    public int getBonusNumberMatchCount(Lotto lotto) {
        int bonusNumberMatchCount = 0;
        if (lotto.getNumbers().contains(bonusNumber)) {
            bonusNumberMatchCount++;
        }
        return bonusNumberMatchCount;
    }
}
