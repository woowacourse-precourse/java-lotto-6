package lotto.view;

import static lotto.constants.LottoIOMessage.BUYING_QUANTITY_FORMAT;

import java.util.List;

public class OutputView {
    public void printQuantityAndAllNumbers(int quantity, List<List<Integer>> manyLotto) {
        System.out.printf(BUYING_QUANTITY_FORMAT, quantity);
        printAllLottoNumber(manyLotto);
    }
    public void printAllLottoNumber(List<List<Integer>> manyLotto) {
        for (List<Integer> oneLotto : manyLotto) {
            printOneLottoNumber(oneLotto);
        }
    }
    public void printOneLottoNumber(List<Integer> oneLotto) {
        System.out.println(convertLottoNumToString(oneLotto));
    }
    public String convertLottoNumToString(List<Integer> oneLotto) {
        StringBuilder lottoNum = new StringBuilder("[" + oneLotto.get(0));
        for (int i = 1; i < oneLotto.size(); i++) {
            lottoNum.append(", ");
            lottoNum.append(oneLotto.get(i));
        }
        lottoNum.append("]");
        return lottoNum.toString();
    }
}
