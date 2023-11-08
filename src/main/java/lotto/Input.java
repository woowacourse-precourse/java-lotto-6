package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Input {

    private int amount;
    private List<List<Integer>> lottos;
    private final int lottoPrice = 1000;
    private String inputSpeech = "구입금액을 입력해 주세요.";
    private String amountSpeech = "개를 구매했습니다.";
    private String winningInputSpeech = "당첨 번호를 입력해 주세요.";
    private static String bonusInputSpeech = "보너스 번호를 입력해 주세요.";


    public Input() {
        System.out.println(inputSpeech);
        start();
    }

    private void start() {
        amount = Integer.parseInt(Console.readLine());
        amountValidate(amount);
    }

    private void amountValidate(int amount) {
        if (amount == 0 || amount % lottoPrice != 0) {
            new ThrowNewException().amountException();
        }

        lottoCount(amount / lottoPrice);
    }

    private void lottoCount(int divisionAmount) {
        System.out.println(divisionAmount + amountSpeech);
        makeLottoNumber(divisionAmount);
    }

    private void makeLottoNumber(int lottoAmount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(getLottoNumber());
        }

        outputLottos();
        winningInput();
    }

    private List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numberSort(lottoNumber);
    }

    private List<Integer> numberSort(List<Integer> lottoNumber) {
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    private void outputLottos() {
        StringBuilder lottosNumber = new StringBuilder();
        for (List<Integer> lotto : lottos) {
            lottosNumber.append(lotto + "\n");
        }
        System.out.println(lottosNumber);
    }

    private void winningInput() {
        String winningInput = Console.readLine();
        winningDivision(winningInput);
    }

    private void winningDivision(String winningInput) {
        List<Integer> winningNumber = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(winningInput,",");
        while(st.hasMoreTokens()){
            winningNumber.add(Integer.parseInt(st.nextToken()));
        }

        new Lotto(winningNumber);
    }

    public static int getBonusNumber(){
        System.out.println(bonusInputSpeech);
        return Integer.parseInt(Console.readLine());
    }


}
