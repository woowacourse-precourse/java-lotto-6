package lotto.domain.generators;

import lotto.contants.OutputEnum;

import java.util.List;

public class WinningNumberGenerator {
    public List<Integer> generator(String str){
        return List.of(str.replaceAll("\\s", "").split(",")).stream()
                .map(it -> {
                    try {
                        return Integer.parseInt(it);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(
                                OutputEnum.output.ERR_LOTTO_MUST_BE_NUMBER.getDescription()
                        );
                    }
                }).toList();
    }
}
