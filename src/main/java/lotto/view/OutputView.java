package lotto.view;

import lotto.common.Message;

import java.util.List;

public class OutputView {

    public void printLotto(List<Integer> lotto) {
        StringBuilder output = new StringBuilder("[");
        for (Integer number : lotto) {
            output.append(lotto).append(", ");
        }
        output.replace(output.length() - 2, output.length(), "]");
        System.out.println(output);
    }

    public void printResult(List<Integer> result) {
        String output = Message.RESULT.getMessage()
                .replaceFirst("cond0", Integer.toString(result.get(0)))
                .replaceFirst("cond1", Integer.toString(result.get(1)))
                .replaceFirst("cond2", Integer.toString(result.get(2)))
                .replaceFirst("cond3", Integer.toString(result.get(3)))
                .replaceFirst("cond4", Integer.toString(result.get(4)))
                .replaceFirst("cond5", Integer.toString(result.get(5)));
        System.out.println(output);
    }

    public void printMessage(Message condition) {
        System.out.println(condition.getMessage());
    }

    public void printMessage(Message condition, int count) {
        System.out.println(condition.getMessage().replace("cond", Integer.toString(count)));
    }

}
