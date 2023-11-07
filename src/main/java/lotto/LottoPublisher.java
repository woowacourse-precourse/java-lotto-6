package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.lottoUI.LottoUI;

public class LottoPublisher {
    public LottoPublisher(int Amount) {
        this.publish_num = (Amount / Lotto_price);
    }
    private static int publish_num;
    static final int Lotto_price = 1000;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LottoNum = 6;

    private static List<List<Integer>> lottoNumbers = new ArrayList<>();

    public static void PrintLotto() {
        LottoUI.DisplayOfLottoNumber(publish_num);
        List<List<Integer>> lottoNumbers = LottoSixNumber(publish_num);
        printLottoNumbers(lottoNumbers);
        LottoNumberSetter.parseWinningNumbers(publish_num);
    }

    public static List<List<Integer>> LottoSixNumber(int count) {
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(generateLotto());
        }
        return lottoNumbers;
    }

    private static List<Integer> generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN, MAX, LottoNum));
        Collections.sort(numbers);  //List를 오름차순으로 정렬
        return numbers;
    }


    private static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    public static List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public static int getPublish_num() {
        return publish_num;
    }
}