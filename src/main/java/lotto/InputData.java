package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class InputData {

    public List<String> lottoMake(String input){
        List<String> lottoNumber = List.of(input.split(","));
        return lottoNumber;
    }

    public List<Integer> lottoList(List<String> lottomake){
        List<Integer> lottoNumber = lottomake.stream()
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList());
        return lottoNumber;
    }


}
