package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {
    public List<Integer> buyLotto(){
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    public Grade checkResult(Lotto lotto, List<Integer> inputNumbers, int bonusNumber){
        int count = 0;
        boolean isBonus = false;

        for (Integer inputNumber : inputNumbers) {
            if(lotto.getNumbers().contains(inputNumber)){
                count ++;
            }
        }

        if (count == 5){
            if(lotto.getNumbers().contains(bonusNumber)){
                isBonus = true;
            }
        }
        return Grade.valueOfHit(count, isBonus);
    }

    // 전체 등수 확인
    public List<Grade> totalGrade(List<Lotto> lottoList, List<Integer> inputNumbers, int bonusNumber){
        List<Grade> grades = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            Grade grade = checkResult(lotto, inputNumbers, bonusNumber);
            grades.add(grade);
        }

        return grades;
    }

    public String getRateOfReturn(int inputMoney, int outputMoney){
        return String.format("%.1f", ((double) outputMoney /inputMoney) * 100);
    }
}
