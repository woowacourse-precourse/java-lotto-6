package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoService {
    public List<Integer> makeRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
    public Lotto[] makeLottoList(int how){
        Lotto[] lottos=new Lotto[how];
        for(int i=0;i<how;i++){
            lottos[i]=new Lotto(makeRandomNumber());
        }
        return lottos;
    }
    public int compare(Lotto answer, Lotto consumer) {
        List<Integer> answerNumbers = answer.getNumbers();
        List<Integer> consumerNumbers = consumer.getNumbers();
        int correct = 0;
        for (int i = 0; i < consumerNumbers.size(); i++) {
            if (answerNumbers.contains(consumerNumbers.get(i))) {
                correct++;
            }
        }
        return correct;
    }
    public int[] compareAllLotto(Lotto[] lottos,Lotto answer,int bonusNum){
        int[] result=new int[5];
        for(int i=0;i<lottos.length;i++){
            int correct=compare(answer,lottos[i]);
            boolean bonus=compareBonusNumber(lottos[i],bonusNum);
            increaseResult(result,correct,bonus);
        }
        return result;
    }
    private void increaseResult(int[] result,int correct,boolean bonus){
        if(correct==3) result[0]++;
        else if(correct==4) result[1]++;
        else if(correct==5&&!bonus) result[2]++;
        else if(correct==5&&bonus) result[3]++;
        else if(correct==6) result[4]++;
    }
    public boolean compareBonusNumber(Lotto answer, int bonusNumber) {
        return answer.getNumbers().contains(bonusNumber);
    }


}
