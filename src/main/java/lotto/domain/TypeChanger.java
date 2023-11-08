package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.validator.ValidateNumber;

public class TypeChanger {
    private static final String BLANK = " ";
    private static final String COMMA = ",";
    private static final String LENGTH_ZERO = "";
    private static TypeChanger typeChanger;

    private TypeChanger(){
    }

    public static TypeChanger getTypeChanger() {
        if (typeChanger == null) {
            typeChanger = new TypeChanger();
        }
        return typeChanger;
    }


    public List<String> stringToListWithComma(String numbers) {
        numbers = numbers.replace(BLANK, LENGTH_ZERO);
        return List.of(numbers.split(COMMA));
    }

    public int from(String number) {
        ValidateNumber.isNumber(number);
        return Integer.parseInt(number);
    }

    public List<Integer> from(List<String> numbers) {
        return numbers.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
