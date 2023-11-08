package lotto.domain.services;

import lotto.contants.LottoEnum;
import lotto.controller.view.Output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoDrawer {
    private final Output output;

    public LottoDrawer(Output output) {
        this.output = output;
    }

    public Map<LottoEnum.grade, Integer> draw(Map<Integer, List<Integer>> lottos, List<Integer> winningNumber, int bonusNumber){
        Map<LottoEnum.grade, Integer> gradeMap = initLottoGradeMap();
        for(List<Integer> lottoNumber : lottos.values()){
            int correct = (int)lottoNumber.stream().filter(winningNumber::contains).count();
            if(correct==3){
                gradeMap.put(LottoEnum.grade.FIFTH, gradeMap.get(LottoEnum.grade.FIFTH)+1);
            }
            if(correct==4){
                gradeMap.put(LottoEnum.grade.FOURTH, gradeMap.get(LottoEnum.grade.FOURTH)+1);
            }
            if(correct==5){
                determine2ndOr3rd(gradeMap,lottoNumber, bonusNumber);
            }
            if(correct==6){
                gradeMap.put(LottoEnum.grade.FIRST, gradeMap.get(LottoEnum.grade.FIRST)+1);
            }
        }
        output.printView(gradeMap);
        return gradeMap;
    }

    private static Map<LottoEnum.grade, Integer> initLottoGradeMap(){
        Map<LottoEnum.grade, Integer> gradeMap = new HashMap<>();
        gradeMap.put(LottoEnum.grade.FIFTH, 0);
        gradeMap.put(LottoEnum.grade.FOURTH, 0);
        gradeMap.put(LottoEnum.grade.THIRD, 0);
        gradeMap.put(LottoEnum.grade.SECOND, 0);
        gradeMap.put(LottoEnum.grade.FIRST, 0);

        return gradeMap;
    }

    private static void determine2ndOr3rd(Map<LottoEnum.grade, Integer> gradeMap, List<Integer> lottoNumber, int bonusNumber){
        if(lottoNumber.contains(bonusNumber)){
            gradeMap.put(LottoEnum.grade.SECOND, gradeMap.get(LottoEnum.grade.SECOND)+1);
            return;
        }
        gradeMap.put(LottoEnum.grade.THIRD, gradeMap.get(LottoEnum.grade.THIRD)+1);
    }

}
