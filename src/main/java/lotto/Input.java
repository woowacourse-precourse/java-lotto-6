package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Input {

    private int amount;
    List<List<Integer>> lottos;
    private String inputSpeech = "구입금액을 입력해 주세요.";
    private String amountSpeech = "개를 구매했습니다.";
    private String amountError = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";

    public Input() {
        System.out.println(inputSpeech);
        start();
    }

    private void start() {
        amount = Integer.parseInt(Console.readLine());
        amountValidate(amount);
    }

    private void amountValidate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(amountError);
        }

        lottoCount(amount / 1000);
    }

    private void lottoCount(int divisionAmount){
        System.out.println(divisionAmount+amountSpeech);
        makeLottoNumber(divisionAmount);
    }

    private void makeLottoNumber(int lottoAmount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(getNumber());
        }
    }

    private List<Integer> getNumber(){
        List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        return numberSort(lottoNumber);
    }

    private List<Integer> numberSort(List<Integer> lottoNumber){
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
