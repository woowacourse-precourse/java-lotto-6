# 입력 검증 타이밍 문제

로또를 구매한 뒤 추첨 전에 당첨 번호와 보너스 번호를 입력 받아야 한다.

```
당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7
```

이 때 출력되는 메세지는 위와 같으며 2회의 입력을 받는다.

그런데 현재 이 로직을 아래와 같이 처리하고 있다.

```java
 public DrawLottosDto inputDrawLottosDto() {
    // 1. "당첨 번호를 입력해 주세요." 출력
    new InputLottoNumbersComponent().renderTo(writer);
    // 2. 입력 받은 문자 저장
    final String lottoNumbersInput = readLine();

    // 3. "보너스 번호를 입력해 주세요." 출력
    new InputBonusNumberComponent().renderTo(writer);
    // 4. 입력 받은 문자 저장
    final String bonusNumberInput = readLine();

    // 5. Dto로 변환 및 검증
    return DrawLottosDto.from(lottoNumbersInput, bonusNumberInput);
}
```

일단 로또 번호와 보너스 번호를 저장한 뒤에, `DrawLottosDto`에 한 번에 넣어서 만들고

검증도 한 번에 처리하게 된다.

이렇게 작성할 경우의 문제는 다음과 같다.

```
당첨 번호를 입력해 주세요.
1,1,1,1,1,1#

보너스 번호를 입력해 주세요.
```

`#`이 존재하므로 입력 형식에 맞지 않아서 오류가 나야 하는데,

보너스 번호를 입력하라는 문구가 출력된다.

검증을 몰아서 하기 때문이다.

몰아서 검증해도 큰 문제가 되지는 않겠지만,

다음 요구 사항을 지키기 어려워진다.

```
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
"[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
```

로또 번호와 보너스 번호 중, 어디서 잘못된 값을 입력 받았는지 알아야 거기서부터 입력을 다시 받기 때문이다.

요구 사항이 엄청 자세히 나와 있지는 않아서 그냥 둘 다 받은 뒤에 검증하고,

둘 다 다시 받게 하는 방법도 있기는 하지만

그래도 좀 더 정확하게 만들어보기 위해 해결 방안을 생각해 보았다.

---

# 빌더 패턴

객체는 항상 생성부터 소멸까지 유효한 데이터를 가져야 한다.

객체 지향의 기본 수칙이다.

인간은 태어날 때부터 키, 몸무게 등의 속성이 0이 아닌 유효한 데이터를 가지며,

상품도 공장에서 출하할 때부터 길이 무게 높이, 부피등이 모두 정해져 있다.

그래서 생성 이후로는 유효한 데이터가 계속해서 소멸 시까지 유지되어야 하는데,

너무 복잡해서 한 번에 만들지 못하거나, 여러 객체와 상호작용 하면서 만들어야 하는 경우에 '빌더' 패턴을 사용해서

점진적으로 만들어 나갈 수 있다.

마치 공장에서 반도체나 자동차가 여러 공정을 거쳐서 완성되는 것과도 비슷하며,

아파트를 한층 한층 수 년간 쌓아가며 만드는 것과도 비슷한 이치다.

그래서 빌딩을 점진적으로 짓는다는 의미에서 따와서 '빌더' 패턴이 아닌가 생각된다.

이 패턴을 활용하여 `DrawLottosDto`의 모든 데이터를 한 번에 모아서 만드는 것이 아니라,

필요한 데이터가 2개이므로, 하나씩 넣어서 2번에 걸쳐 완성 시키는 방식으로 전환하고,

데이터를 넣을 때마다 검증도 함께 이루어지면 '잘못된 데이터가 들어간 순간' 예외를 던져서 인지할 수 있을 것이다.

그리고 그 부분부터 다시 입력받게 하면 될 것이다.

이러면 코드를 이상하게 바꾸지 않고 약간만 손보더라도 요구 사항을 좀 더 정확하게 지킬 수 있을 것 같아서 시도 해보겠다.

빌더 패턴을 사용은 해봤지만 만들어 본 적은 없어서 처음엔 클래스 내에 그대로 빌더를 만들어 봤는데,

문제는 Dto의 필드에서 `final`을 제거해야 한다는 것이다.

```java
public final class DrawLottosDto {

    // 불변을 제거해서 하나씩 채워 나가야 함
    private final List<Integer> lottoNumbers;

    private final int bonusNumber;

    // ...

    public DrawLottosDto() {

    }
}
```

Dto는 일반적으로 불변 클래스이기 때문에 빌더 패턴을 위해 `final`을 제거한다는 것은,

기능을 추가하기 위해 본질을 어기는 듯 하여 잘못된 방향성을 잡았다는 생각이 들었다.

그래서 이 방법을 버리고 빌더를 위한 클래스를 하나 더 만드는 것이 낫겠다는 판단이 들었다.

```java

/**
 *
 */
public class DrawLottosDtoBuilder {
    private List<Integer> lottoNumbers;
    private int bonusNumber;

    private DrawLottosDtoBuilder() {
    }

    public static DrawLottosDtoBuilder builder() {
        return new DrawLottosDtoBuilder();
    }

    public DrawLottosDtoBuilder lottoNumbers(final String input) {
        InputValidator.validateCommasSeparatedInput(input);
        this.lottoNumbers = StrictInputParser.mustParseFromCommasSeparatedInputToIntList(input);
        return this;
    }

    public DrawLottosDtoBuilder bonusNumber(final String input) {
        InputValidator.validateNumericInput(input);
        this.bonusNumber = StrictInputParser.mustParseToInt(input);
        return this;
    }

    public DrawLottosDto build() {
        return new DrawLottosDto(lottoNumbers, bonusNumber);
    }
}
```

위와 같이 빌더 클래스를 따로 빼게 된다면,

```java
    final DrawLottosDto dto = DrawLottosDtoBuilder.builder()
        // lottoNumbers를 먼저 할당
        .lottoNumbers("1,2,3,4,5,6")
        // 이후 bonusNumber 할당
        .bonusNumber("7")
        // Dto 객체로 완성
        .build();
```

위와 같이 생성 단계를 나눌 수 있게 된다.

`OutputView`의 `inputDrawLottosDto` 이전 코드를 다시 살펴보자.

```java
public DrawLottosDto inputDrawLottosDto() {
    new InputLottoNumbersComponent().renderTo(writer);
    final String lottoNumbersInput = readLine();

    new InputBonusNumberComponent().renderTo(writer);
    final String bonusNumberInput = readLine();

    return DrawLottosDto.from(lottoNumbersInput, bonusNumberInput);
}
```

그리고 빌더로 변환한 코드를 아래에 작성했다.

```java
public DrawLottosDto inputDrawLottosDto() {
    // 빌더 생성
    final DrawLottosDtoBuilder builder = DrawLottosDtoBuilder.builder();

    new InputLottoNumbersComponent().renderTo(writer);
    // 로또 번호를 먼저 입력
    builder.lottoNumbers(readLine());

    new InputBonusNumberComponent().renderTo(writer);

    // 보너스 번호 마저 입력
    builder.bonusNumber(readLine());

    // Dto 완성 및 반환
    return builder.build();
}
```

이제 Dto를 두 번에 걸쳐서 나눠서 입력하여 생성할 수 있게 되었다.

그러나 요구 사항대로 예외가 발생한 부분부터 다시 입력을 받게 하려면,

메소드로 분리해주는 것이 좋을 것 같다.

```java
public DrawLottosDto inputDrawLottosDto() {
    // 1. 빌더 먼저 생성
    final DrawLottosDtoBuilder builder = DrawLottosDtoBuilder.builder();

    // 로또 번호 입력
    inputLottoNumbers(builder);
    // 보너스 번호 입력
    inputBonusNumber(builder);

    // Dto로 변환 및 반환
    return builder.build();
}

private DrawLottosDtoBuilder inputLottoNumbers(final DrawLottosDtoBuilder builder) {
    // "로또 번호를 입력해주세요" 출력
    new InputLottoNumbersComponent().renderTo(writer);

    try {
        // 사용자의 입력을 받아서 빌더에 저장
        builder.lottoNumbers(readLine());
    } catch (final Exception e) {
        // 예외 발생 시, 메세지 출력
        System.out.println("[ERROR] 유효하지 않은 로또 번호입니다.\n다시 입력 해주세요.");
        // 그리고 재입력을 받음
        return inputLottoNumbers(builder);
    }

    // 빌더 반환
    return builder;
}

private DrawLottosDtoBuilder inputBonusNumber(final DrawLottosDtoBuilder builder) {
    // "보너스 번호를 입력해주세요" 출력
    new InputBonusNumberComponent().renderTo(writer);

    try {
        // 사용자의 입력을 받아서 빌더에 저장
        builder.bonusNumber(readLine());
    } catch (final Exception e) {
        // 예외 발생 시, 메세지 출력
        System.out.println("[ERROR] 유효하지 않은 보너스 번호입니다.\n다시 입력 해주세요.");
        // 그리고 재입력을 받음
        return inputBonusNumber(builder);
    }

    // 빌더 반환
    return builder;
}
```

코드가 꽤나 길어졌지만, 구조상 그리 난잡하지는 않아서 가독성도 괜찮고, 이해하는데 큰 어려움은 없을 것 같다.

요구 사항을 만족시키기 위해서 생각해낸 방법 중에 가장 괜찮은 것 같다.

물론 항상 더 좋은 방법이 있을 수 있지만,

객체 생성 단계를 나누어서 한다는 생각을 해보니 빌더 패턴이 딱 떠올라서

적절한 위치라고 생각해서 사용해보았다.

디자인 패턴 책을 보면 그 떄는 당장 이해는 되지만,

실제로 써먹을 일이 많지 않아서 금방 잊어버리게 되고, 응용력이 부족하다고 생각이 드는데

이런 식으로 적절한 사용처를 찾아서 직접 짜 보니 확실히 기억에 잘 남을 것 같다.

마지막으로 빌더 클래스를 따로 생성하지 않고 `static` nested class를 사용하는 방법도 괜찮을 것 같아서,

해당 버전의 코드도 기록해두고 마무리하겠다.

```java
package lotto.controller.dto.input;

import java.util.List;
import lotto.parser.StrictInputParser;
import lotto.validator.InputValidator;

/**
 * 로또 추첨을 위한 입력 데이터,
 * <p>
 * 당첨 번호 및 보너스 번호를 담은 Dto
 */
public final class DrawLottosDto {

    /**
     * 당첨 번호 6자리
     */
    private final List<Integer> lottoNumbers;

    /**
     * 보너스 번호
     */
    private final int bonusNumber;

    public DrawLottosDto(
            final List<Integer> lottoNumbers,
            final int bonusNumber
    ) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    /**
     * 2개의 입력을 받아서 로또 추첨을 위한 Dto로 변환합니다.
     */
    public static DrawLottosDto from(
            final String lottoNumbersInput,
            final String bonusNumberInput
    ) {
        final List<Integer> lottoNumbers = StrictInputParser.mustParseFromCommasSeparatedInputToIntList(
                lottoNumbersInput);
        final int bonusNumber = StrictInputParser.mustParseToInt(bonusNumberInput);
        return new DrawLottosDto(lottoNumbers, bonusNumber);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Dto 내의 데이터는 추후 다른 객체에 의해 사용되어야 하기 때문에 getter를 모두 열어 두었습니다.
     * <p>
     * 이후 Mapper에 의해 도메인 객체로 변환됩니다.
     */
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    /**
     * 빌더 클래스를 static nested 클래스로 작성
     */
    public static class Builder {
        private List<Integer> lottoNumbers;
        private int bonusNumber;

        // 생성자 호출 막음
        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder lottoNumbers(final String input) {
            InputValidator.validateCommasSeparatedInput(input);
            this.lottoNumbers = StrictInputParser.mustParseFromCommasSeparatedInputToIntList(input);
            return this;
        }

        public Builder bonusNumber(final String input) {
            InputValidator.validateNumericInput(input);
            this.bonusNumber = StrictInputParser.mustParseToInt(input);
            return this;
        }

        public DrawLottosDto build() {
            return new DrawLottosDto(lottoNumbers, bonusNumber);
        }
    }

}

```

이렇게 사용하면 따로 클래스를 만들지 않아도 되며,

Dto 파일만 보고도 Builder를 사용할 수 있다는 사실을 인지할 수 있다는 장점이 있지만,

단점은 Dto에 빌더 코드가 너무 많아져서 배보다 배꼽이 더 커진다는 것이다.

우아한 테크코스를 진행하면서 클래스 당 역할을 최소화 해보기로 했으니,

실제 3주차 미션 코드는 클래스를 나누는 방식을 선택했다. 