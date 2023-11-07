package lotto.controller.dto.input.builder;

import java.util.List;
import lotto.controller.dto.input.DrawLottosDto;
import lotto.controller.exception.InvalidBuilderFieldsException;
import lotto.domain.lotto.validator.LottoValidator;
import lotto.parser.StrictInputParser;

/**
 * DrawLottos의 경우, 입력을 2번 받아서 객체를 생성해야 합니다.
 * <p>
 * 그래서 모든 객체의 필드를 유효한 상태로, 한 번에 생성하기 위해서는
 * <p>
 * 검증을 하지 않고 우선 입력을 모두 받을 때까지 기다려야 하는데,
 * <p>
 * 이 경우, 요구 조건에 맞춰서 사용자가 잘못된 입력을 하는 순간 오류 메세지를 띄워주고 재입력 받는 동작이 불가합니다.
 * <p>
 * 그래서 객체의 필드를 하나씩 채워주면서 점진적으로 데이터를 모으고,
 * <p>
 * 데이터가 입력될 때마다 검증을 해줄 수 있으며,
 * <p>
 * 모든 데이터가 모였을 때, 실제 객체를 `build` 메소드 호출을 통해 생성시킬 수 있는 `Builder` 클래스를
 * <p>
 * 따로 작성하였습니다.
 */
public final class DrawLottosDtoBuilder {

    /**
     * DrawLottosDto가 필드로 가지고 있는 로또 번호
     * <p>
     * 점진적으로 필드를 하나씩 채우기 때문에 `final`을 제해야 합니다.
     */
    private List<Integer> lottoNumbers = null;

    /**
     * DrawLottosDto가 필드로 가지고 있는 보너스 번호
     */
    private Integer bonusNumber = null;

    /**
     * 기본 생성자를 막아서 반드시 `builder` 정적 팩토리 메소드를 통해서 Builder를 생성하도록 합니다.
     */
    private DrawLottosDtoBuilder() {
    }

    /**
     * 정적 팩토리 메소드명이 builder이기 때문에,
     * <p>
     * 클래스 명과 함께 빌더 메소드임을 좀 더 확실하게 인지할 수 있습니다.
     */
    public static DrawLottosDtoBuilder builder() {
        return new DrawLottosDtoBuilder();
    }

    /**
     * 사용자가 로또 번호를 입력하면 검증한 뒤, 빌더의 필드에 데이터를 채워줍니다.
     * <p>
     * 아직 `DrawLottosDto` 타입은 아니기 때문에 따로 사용은 불가하며,
     * <p>
     * 객체를 제품이라고 생각하면, 공장에서 조립 중인 상태와 동일하다고 생각할 수 있습니다.
     */
    public DrawLottosDtoBuilder lottoNumbers(final String input) {
        final List<Integer> lottoNumbers = StrictInputParser.mustParseFromCommasSeparatedInputToIntList(input);
        LottoValidator.validateLottoLength(lottoNumbers);
        LottoValidator.validateDuplication(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        return this;
    }

    /**
     * 사용자가 보너스 번호를 입력하면 검증한 뒤, 필드에 데이터를 채워줍니다.
     * <p>
     * 역시 아직 객체 사용은 불가합니다.
     */
    public DrawLottosDtoBuilder bonusNumber(final String input) {
        this.bonusNumber = StrictInputParser.mustParseToInt(input);
        return this;
    }

    /**
     * 모든 데이터를 채웠을 때,
     * <p>
     * `build` 메소드를 호출하여 실제 객체를 현재까지의 필드에 담긴 데이터로 생성해줍니다.
     * <p>
     * 유효하지 않은 객체가 생성되는 것을 방지하기 위해 모든 필드가 세팅 되었는지 검증 로직을 재차 수행합니다.
     */
    public DrawLottosDto build() {
        ensureAllFieldsSet();
        return new DrawLottosDto(lottoNumbers, bonusNumber);
    }

    /**
     * build 시 수행하는 검증 로직
     */
    private void ensureAllFieldsSet() {
        if (lottoNumbers == null || bonusNumber == null) {
            throw new InvalidBuilderFieldsException();
        }
    }

}