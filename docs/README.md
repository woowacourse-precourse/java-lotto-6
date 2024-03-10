![스크린샷 2024-03-10 오후 4.22.34.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F82%2F66zt2rjn769ftdd689_2327m0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_m1V9bJ%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-10%20%EC%98%A4%ED%9B%84%204.22.34.png)

![스크린샷 2024-03-10 오후 4.22.53.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F82%2F66zt2rjn769ftdd689_2327m0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_Jwp5li%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-10%20%EC%98%A4%ED%9B%84%204.22.53.png)

## 클래스 분리

![스크린샷 2024-03-10 오후 4.23.18.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F82%2F66zt2rjn769ftdd689_2327m0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_oJCxEG%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-10%20%EC%98%A4%ED%9B%84%204.23.18.png)

실행 흐름도에서 사용되는 명사를 추출하였다. 로또, 구매자, 당첨 로또, 통계들을 확인할 수 있었고 객체를 구성하였다.

## 실행 흐름

![스크린샷 2024-03-10 오후 4.24.03.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F82%2F66zt2rjn769ftdd689_2327m0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_lp1eat%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-10%20%EC%98%A4%ED%9B%84%204.24.03.png)

메시지를 전달하는 것으로 어떠한 메서드를 사용해야 하는지에 대해서도 쉽게 생각할 수 있었다.

## 조립을 활용하자

상속 관계로 구성이 되어있으면 상위 클래스의 변경이 용이하지 않다.

상위 클래스의 작은 변경들이 하위 클래스에서 어떠한 영향을 끼칠지는 아무도 모른다.

그렇기에 상속의 방식보단 필드로 객체를 참조하는 방식을 선택했다.

## 검증방식

```java
ublic class Lotto {
    private final List<Integer> numbers; 

    
    public Lotto(List<Integer> numbers) {
        validate(numbers); 
        this.numbers = numbers; 
    }

    // 번호 리스트를 검증
    private void validate(List<Integer> numbers) {
        validateCount(numbers); 
        validateRange(numbers); 
        validateDuplication(numbers); 
    }

    // 번호 리스트의 길이를 검증
    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("Invalid number count. Expected: 6, Actual: " + numbers.size());
        }
    }

    // 번호 리스트의 각 항목이 유효한 범위 내에 있는지 검증
    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("Invalid number range. Number should be between 1 and 45: " + number);
            }
        }
    }

    // 번호 리스트에 중복된 번호가 있는지 검증
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("Duplicate numbers are not allowed.");
        }
    }
}
```

검증이 어디에 위채해야하며 어떻게 존재해야 하는지에 대해서도 고민해볼 수 있었다.

생성 전 검증 과정이 존재하고 검증을 통과하지 못하게 해놓으면 객체 생성이 이뤄지지 않는다. 즉 클라이언트 입장에서 잘못된 값을 입력하더라도 잘못된 객체 생성의 오용을 막을 수 있다.

코드는 다른 사람이 보기에도 그 의도가 잘 파악되어 있는 것이 중요하다고 느낄 수 있었다.

## Enum

Enum(열거형)은 바뀌지 않는 값들의 집합을 뜻한다.

미션 요구 사항에는 Java Enum을 활용해야 한다는 요구사항이 있었기에 최대한 활용하려고 노력했었다.

```java
public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    MISS(0, 0, "낙첨 - "); // 미당첨

    Ranking(int matchCount, int winningAmount, String message) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.message = message;
    }
    
   

```

로또 등수인 Rank는 일치한 개수, 상금, 보너스 번호의 일치 여부가 변하지 않을 값이라 판단하여 Enum으로 사용하기에 적합하다고 판단을 했다.

## 테스트 코드

이번 미션을 진행하면서 가장 어려웠고, 고민했던 부분은 테스트라고 말할 수 있을 거 같다.

테스트의 적용이 어려웠던 것은 실제로 코드를 작성하면서 테스트의 적용이 익숙하지 않은 숙련의 문제도 있을 것이고 실제로 테스트의 적용이 어렵게 구현이 되어있다고 미션란에 설명이 되어있었다.

테스트를 구현과 같은 레벨로 취급하며 테스트가 진행이 되지 않을 경우 설계를 변경하는 것을 고려하게끔 설명하고 있었다.

이번 미션을 통해 테스트 코드의 가치를 많이 느낄 수 있었고, public을 활용하여 최대한 많은 메서드들을 검증하기 위해서 노력했다.

```java
class WinningResultTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,8,10:FOURTH",
            "1,2,3,8,9,10:FIFTH", "1,2,8,9,10,11:MISS"}, delimiter = ':')
    @DisplayName("사용자가 구매한 로또 번호와 당첨번호를 비교해 등수 확인")
    void compareWinningResults(String input, Ranking expectedRanking) {
        List<Integer> ticketNumbers = parseInputToList(input);
        Lotto userLotto = new Lotto(ticketNumbers);
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusBall = 7;
        WinningResult winningResult = new WinningResult(winningLotto, bonusBall);

        assertThat(winningResult.match(userLotto)).isEqualTo(expectedRanking);
    }

    private List<Integer> parseInputToList(String input) {
        String[] numbersAsString = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberAsString : numbersAsString) {
            numbers.add(Integer.parseInt(numberAsString));
        }
        return numbers;
    }
}
```

**Parameterized Test 활용**: @ParameterizedTest와 @CsvSource를 활용하여 여러 입력 값에 대해 단일 테스트 메서드를 반복해서 실행할 수 있었다. 이렇게 하면 테스트 코드의 중복을 줄이고, 유사한 테스트 케이스를 한 곳에 모아서 관리할 수 있게끔 작성하였다.