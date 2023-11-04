package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Stream;

class User {

    public int inputPurchasingVolume(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
//        입력값 검증 함수
        int volume = Integer.parseInt(input);
        return volume/1000;
    }

    public List<Integer> inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
//       입력값 검증 함수
        Integer[] inputNums = Stream.of(input.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(inputNums));
        return numbers;
    }

    public int inputBonusNumber(){
        String input = Console.readLine();
//        입력값 검증 함수
        int number = Integer.parseInt(input);
        return number;
    }

    public List<Integer> getLottoNumbers (){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<List<Integer>> getLottoAsMuchAsVolume(int volume){
        List<List<Integer>> lottoPapers = new ArrayList<>();
        for(int i=0; i<volume; i++){
            List<Integer> lottoNumbers = getLottoNumbers();
            Collections.sort(lottoNumbers);
            lottoPapers.add(lottoNumbers);
        }
        return lottoPapers;
    }

    public int countSingleLottoMatchNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        int count = 0;
        for(int lottoNum : lottoNumbers){
            if(winningNumbers.contains(lottoNum)){
                count++;
            }
        }
        return count;
    }

    public boolean checkBonusNumber(List<Integer> singleLotto, int bonusNumber){
        if(singleLotto.contains(bonusNumber)){
            return true;
        }
        return false;
    }

    public List<Integer> countAllLottoMatchNumbers(List<List<Integer>> allLotto, List<Integer> winningNumbers){
        int count = 0;
        List<Integer> lottoMatchingCount = new ArrayList<>();
        for(List<Integer> singleLotto : allLotto){
            count = countSingleLottoMatchNumbers(singleLotto, winningNumbers);
            lottoMatchingCount.add(count);
        }
        return lottoMatchingCount;
    }
}