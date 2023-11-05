package lotto.View;

import lotto.Constant.RecordConstant;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView
{
    public void printLotto(List<List<Integer>> lotto)
    {
        lotto.stream()
                .map(innerList -> innerList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
                .forEach(System.out::println);
    }

    public void printResultRecord(List<Integer> resultRecord)
    {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i = 0 ; i< RecordConstant.NUMBER_OF_RANKING ; i++)
        {
            System.out.print(RecordConstant.NameOfRanking.findByIndex(i).getDescription());
            System.out.println(resultRecord.get(i) + "개");
        }
    }
}
