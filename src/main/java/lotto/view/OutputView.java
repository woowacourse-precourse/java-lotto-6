package lotto.view;

import lotto.domain.DrawResult;
import lotto.service.LottosDTO;
import lotto.service.PriceDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottos(LottosDTO lottosDTO, PriceDTO priceDTO) {
        List<String> lottoNumbers = new ArrayList<>();
        System.out.println();
        System.out.println(String.format("%s개를 구매했습니다.",priceDTO.getPurchaseNumber()));
        for (List<Integer> numbers : lottosDTO.getNumbers()) {
            String lottoNumber = numbers.stream()
                    .sorted()
                    .map(number -> Integer.toString(number))
                    .collect(Collectors.joining(", "));
            System.out.println(String.format("[%s]",lottoNumber));;
        }
    }

    public static void printResult(DrawResult drawResult, PriceDTO priceDTO) {
        Map<String, Integer> result = drawResult.getResult();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(String.format("%s%d개",entry.getKey(), entry.getValue()));
        }
        double earningRate = drawResult.getEarningRate(priceDTO.getPrice());
        System.out.println(String.format("총 수익률은 %s%%입니다.", earningRate));
        System.out.println("---");
    }
}
