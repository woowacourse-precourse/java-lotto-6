package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Stream;

class User {

    public int inputPurchasingVolume(){
        String input = Console.readLine();
//        입력값 검증 함수
        int volume = Integer.parseInt(input);
        return volume/1000;
    }

    public List<Integer> inputWinningNumbers(){
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

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Lotto> getLottoAsMuchAsVolume(int volume) {
        List<Lotto> allLotto = new ArrayList<>();
        for (int i = 0; i < volume; i++) {
            List<Integer> lottoNumbers = getLottoNumbers();
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            allLotto.add(lotto);
        }
        return allLotto;
    }
}