package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private static OutputView outputView = new OutputView();

    private OutputView() {

    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printIssueNumbers(List<Integer>[] issueNumbers, int count) {
        System.out.println(count+"개를 구매했습니다.");
        for(int i=0;i<count;i++){
            System.out.println(issueNumbers[i]);
        }
    }
}
