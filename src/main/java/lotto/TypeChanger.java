package lotto;

import java.util.List;

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

    public int stringToInteger(String number) {
        return Integer.parseInt(number);
    }

    public List<Integer> from(List<String> numbers) {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
