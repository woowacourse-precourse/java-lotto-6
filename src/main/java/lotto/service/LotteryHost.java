package lotto.service;

import lotto.domain.Rank;
import lotto.view.Ask;

import java.util.ArrayList;
import java.util.List;

public class LotteryHost {

    public List<Integer> result = new ArrayList<>();
    public List<Integer> compare(List<Integer> numbers, List<List<Integer>> randomNumbers) {
        List<Integer> random = new ArrayList<>();

        int number=0;
        for (int i = 0; i < randomNumbers.size(); i++) {
            random = randomNumbers.get(i);
            for(int j = 0; j <6; j++){
                for(int k =0; k<6; k++){
                    if(numbers.get(j).equals(random.get(k))){
                        number++;
                    }
                }
            }
        }
        compareRank(number, randomNumbers);

        return result;
    }

    public void compareRank(int number, List<List<Integer>> randomNumbers){

        Ask ask = new Ask();
        boolean flag = false;

        for(int i=0; i< result.size(); i++){
            result.indexOf(5);
            if(result.get(i) == 5)
                for(int num: randomNumbers.get(i)){
                    if(num == ask.bonusNumber){
                        flag = true;
                    }
                }
        }

        if(number ==3){
            Rank.FIFTH.setNumber(1);
        }else if (number ==4){
            Rank.FORTH.setNumber(1);
        }else if(number ==5 && !flag){
            Rank.THIRD.setNumber(1);
        }else if(number ==5 && flag){
            Rank.SECOND.setNumber(1);
        }else if(number == 6){
            Rank.FIRST.setNumber(1);
        }

    }


}
