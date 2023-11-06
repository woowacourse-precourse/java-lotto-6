package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;
import static lotto.Lotto.LottoRank.*;

public class LottoController {

    private List<Lotto> lotto = new ArrayList<>();
    private Lotto winLotto;
    private int bonusNumber;

    public int first;
    public int second;
    public int third;
    public int fourth;
    public int fifth;

    public void startLotto() {
        OutputView.printGetPurchasePriceMessage();
        int purchasePrice = InputView.inputPurchasePrice();

        int lottoNum = getLottoNum(purchasePrice);
        OutputView.printLottoNumMessage(lottoNum);

        for(int i = 0; i < lottoNum ; i++) {
            List<Integer> lottoNumber = getLottoNumber();
            OutputView.printLottoNumber(lottoNumber);
            lotto.add(new Lotto(lottoNumber));
        }

        System.out.println();

        OutputView.printWinNumberMessage();
        getWinLottoNumber();

        OutputView.printBonusNumberMessage();
        bonusNumber = getBonusNumber();

        for (int i = 0; i < lottoNum; i++) {
            List<Integer> lottoNumbers = lotto.get(i).getNumbers();
            List<Integer> winNumbers = winLotto.getNumbers();
            int sameNumberCount = compareLotto(lottoNumbers, winNumbers);
//            System.out.println("다시 한 번!!! 갯수는!!! " + sameNumberCount);
//            System.out.println("어떤 로또라고??? " + lotto.get(i));
            setRank(lotto.get(i), sameNumberCount);
//            System.out.println("그렇다면... 이 로또의 등수는!!! " + lotto.get(i).getRank());
        }

        /**
         * 로또 배열
         * 그 중에 한 로또를 뽑는 걸 반복하는 함수
         * ture인 숫자의 갯수를 카운트
         * 뽑은 로또의 숫자들을 하나씩 win로또 배열에 비교하는 함수 -> true 리턴
         */

        for (int i = 0; i < lottoNum; i++) {

            switch (lotto.get(i).getRank()) {
                case FIRST:
                    first += 1;
                    break;
                case SECOND:
                    second += 1;
                    break;
                case THIRD:
                    third += 1;
                    break;
                case FOURTH:
                    fourth += 1;
                    break;
                case FIFTH:
                    fifth += 1;
                    break;
            }

        }

        List<Integer> rates = new ArrayList<>();
        rates.add(first);
        rates.add(second);
        rates.add(second);
        rates.add(fourth);
        rates.add(fifth);

        long rateOfProfit = getRateOfProfit(purchasePrice, rates);

        System.out.println("당첨 통계");
        System.out.println("---");

        StringBuilder result = new StringBuilder();

        result.append("3개 일치 (5,000원) - ");
        result.append(fifth);
        result.append("개\n");

        result.append("4개 일치 (50,000원) - ");
        result.append(fourth);
        result.append("개\n");

        result.append("5개 일치 (1,500,000원) - ");
        result.append(third);
        result.append("개\n");

        result.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        result.append(second);
        result.append("개\n");

        result.append("6개 일치 (2,000,000,000원) - ");
        result.append(first);
        result.append("개\n");

//        result.append(FIRST);
//        result.append(first);
//        result.append("개\n");
//
//        result.append(SECOND);
//        result.append(second);
//        result.append("개\n");
//
//        result.append(THIRD);
//        result.append(third);
//        result.append("개\n");
//
//        result.append(FOURTH);
//        result.append(fourth);
//        result.append("개\n");
//
//        result.append(FIFTH);
//        result.append(fifth);
//        result.append("개\n");

//        getRateOfProfit(purchasePrice, rates);

        result.append("총 수익률은 ");
        result.append(String.format("%.2f", rateOfProfit));
        result.append("%입니다.");

        System.out.println(result);


    }

    public int getLottoNum(int purchasePrice) {
        int lottoNum = purchasePrice / 1000;
        return lottoNum;
    }

    public List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sort(lottoNumber);
        return lottoNumber;
    }

    public void getWinLottoNumber() {
        List<Integer> winNumber = InputView.inputWinNumber();

        try {
            winLotto = new Lotto(winNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("당첨 번호를 6개 입력해주세요.");
            getWinLottoNumber();
        }

//        try {
//            Validator.winNumberDuplication(winNumber);
//        } catch (IllegalArgumentException e) {
//            System.out.println("당첨 번호를 중복 없이 입력해주세요.");
//            getWinLottoNumber();
//        }
    }

    public int getBonusNumber() {
        int bonusNumber = InputView.inputBonusNumber();

        try {
            Validator.bonusNumberNum(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("1개만 입력하세요.");
            getLottoNumber();
        }

        return bonusNumber;
    }

    public int compareLotto(List<Integer> lottoNumber, List<Integer> winNumber) {

        int count = 0;

        for(int i = 0; i < lottoNumber.size(); i++) {
            if (winNumber.contains(lottoNumber.get(i))) {
                count += 1;
            }
        }

//        System.out.println(lottoNumber + " 인 로또의 같은 번호 갯수는: " + count);

        return count;

//        for (int i = 0; i < lottoNumber.size() < i++) {
//            winNumber.contains(lottoNumber.get(i));
//        }
//        lottoNumber.forEach(num -> winNumber.contains(num));

    }

    public boolean compareBonusNumber(Lotto lotto, int bonusNumber) {

        List<Integer> lottoNumber = lotto.getNumbers();

        if (lottoNumber.contains(bonusNumber)) {
            return true;
        }

        return false;
    }

    private void setRank(Lotto lotto, int sameNumberCount) {
//        System.out.println("갯수가 잘 들어갔나??? " + sameNumberCount);
        switch (sameNumberCount) {
            case 6:
                lotto.setRank(FIRST);
                break;
            case 5:
//                System.out.println("switch가 잘 되나??? " + sameNumberCount);
                if (compareBonusNumber(lotto, bonusNumber)) {
                    lotto.setRank(SECOND);
                    break;
                }
                lotto.setRank(THIRD);
                break;
            case 4:
                lotto.setRank(THIRD);
                break;
            case 3:
                lotto.setRank(FOURTH);
                break;
            case 2:
                lotto.setRank(FIFTH);
                break;
            case 1:
                lotto.setRank(LOOSE);
                break;
            case 0:
                lotto.setRank(LOOSE);
                break;
        }
    }

    private long getRateOfProfit(int purchasePrice, List<Integer> rates) {
        return getTotalAmount(rates) / purchasePrice;
    }

    private int getTotalAmount(List<Integer> rates) {
        int total = 0;

        for (int i = 0; i < 5; i++) {
            total += getRatePrice(i + 1, rates.get(i));
        }

        return total;
    }

    private int getRatePrice(int rate, int rateNum) {

        switch (rate) {
            case 5:
                return 5000 * rateNum;
            case 4:
                return 50000 * rateNum;
            case 3:
                return 1500000 * rateNum;
            case 2:
                return 30000000 * rateNum;
            case 1:
                return 2000000000 * rateNum;
        }

        return 0;

    }
}
