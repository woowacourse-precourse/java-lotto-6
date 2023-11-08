package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import lotto.constant.Constant;
import lotto.dto.ResultDTO;
import lotto.model.Result;

public class LottoService {

    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER, Constant.LOTTO_TOTAL_NUMBERS);
    }

    public ResultDTO calculateResult(Lotto lottos, List<Integer> resultNumbers, int bonusNumber){
        int count=0;
        boolean isBonus=false;
        for(int number :lottos.getNumbers()){
            if(resultNumbers.contains(number)){
                ++count;
            }
            if(number==bonusNumber) isBonus=true;
        }
        return new ResultDTO(count,isBonus);
    }

    public Result calculateTotalResult(List<Lotto> lottos, List<Integer> resultNumbers, int bonusNumber){
        List<ResultDTO> resultDTOs = new ArrayList<>();
        for(Lotto lotto:lottos){
            resultDTOs.add(calculateResult(lotto,resultNumbers,bonusNumber));
        }
        return convertTypeResult(resultDTOs);
    }

    public Result convertTypeResult(List<ResultDTO> resultDTOS){
        Result result = new Result(0,0,0,0,0);
        for(ResultDTO resultDTO:resultDTOS){
            if(resultDTO.sameCount==3) result.addFifth();
            else if(resultDTO.sameCount==4) result.addFourth();
            else if(resultDTO.sameCount==5 && !resultDTO.isBonus) result.addThird();
            else if(resultDTO.sameCount==5 && resultDTO.isBonus) result.addSecond();
            else if(resultDTO.sameCount==6) result.addFifth();
        }
        return result;
    }
}
