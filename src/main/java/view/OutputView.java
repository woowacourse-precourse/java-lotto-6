package view;

import message.OuputMessage;
import model.ResultLotto;
import model.ResultLottos;

import java.util.List;
import java.util.Objects;

public class OutputView {
    public void printLottoCount(Integer count) {
        System.out.println(count + OuputMessage.PAYRESULT.toString());
    }

    public void printLottos(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printResult(ResultLottos resultLottos) {
        System.out.println(OuputMessage.HEADRESULT);
        printResultLottos(resultLottos);
    }

    private void printResultLottos(ResultLottos resultLottos) {
        for (ResultLotto lotto : ResultLotto.values()) {
            if (Objects.equals(lotto.getEqualCount(), OuputMessage.MATCHTHREE.getMatchCount())) {
                System.out.println("3개 일치 (5,000원) - " + resultLottos.findResultCount(lotto) + "개");
            } else if (Objects.equals(lotto.getEqualCount(), OuputMessage.MATCHFOUR.getMatchCount())) {
                System.out.println("4개 일치 (50,000원) - " + resultLottos.findResultCount(lotto) + "개");
            } else if (Objects.equals(lotto.getEqualCount(), OuputMessage.MATCHFIVE.getMatchCount()) && !lotto.getBonus()) {
                System.out.println("5개 일치 (1,500,000원) - " + resultLottos.findResultCount(lotto) + "개");
            } else if (Objects.equals(lotto.getEqualCount(), OuputMessage.MATCHFIVE.getMatchCount())) {
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultLottos.findResultCount(lotto) + "개");
            } else if (Objects.equals(lotto.getEqualCount(), OuputMessage.MATCHSIX.getMatchCount())) {
                System.out.println("6개 일치 (2,000,000,000원) - " + resultLottos.findResultCount(lotto) + "개");
            }
        }
    }

    public void printReturnRate(double rate) {
        String returnRate = String.format("%,.1f", rate);
        System.out.println(OuputMessage.TOTALRATE.getMessage() + returnRate + OuputMessage.PERCENT.getMessage());
    }

}
