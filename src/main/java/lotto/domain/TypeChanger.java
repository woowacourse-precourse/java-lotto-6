package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.validator.ValidateNumber;

public class TypeChanger {
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
        numbers = numbers.replace(" ", "");
        return List.of(numbers.split(","));
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
