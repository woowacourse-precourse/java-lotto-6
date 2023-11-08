# 로또

## 0. 개요

우아한 테크 코스 3주차 과제인 로또 게임을 구현한다.<br>
이번 과제에서는 다음의 내용들을 중점으로 리팩토링 한다.

- 클래스 분리
    - 클래스는 최소한의 책임만 가지도록 구현한다.
        - 요구사항 변경에 대해 최소한의 클래스 수정이 가능하도록 리팩토링 한다.
- 테스트
    - 각 도메인 로직에 대해 단위 테스트를 수행한다.

## 1. 프로그램 흐름

1. 로또 구입
    1. 구입 즉시 구입한 수량만큼의 로또를 발행 후 출력 - _입력한 값이 숫자가 아닌 경우 예외 발생_
        - _입력한 값이 1,000원 단위 입력이 아닐 경우 예외 발생_
        - _입력한 값이 100,000원을 초과할 경우 예외 발생_
        - 현행법상 인당 구매할 수 있는 로또의 최대 금액은 100,000 이다.
2. 정답 생성
    1. 당첨 번호 입력 - _입력한 값이 숫자가 아닐 경우 예외 발생_
        - _입력한 값이 정해진 입력 포맷과 다를 경우 예외 발생_
        - 포맷 : `"숫자,숫자,숫자,숫자,숫자,숫자,숫자"`
        - 단, 사용자 편의를 위해 공백은 허용한다. - _입력한 숫자가 6개가 아닐 경우 예외 발생_
        - _입력한 값이 중복되어 있을 경우 예외 발생_
    2. 보너스 번호 입력 - _입력한 값이 숫자가 아닐 경우 예외 발생_
        - _입력한 보너스 번호와 로또 번호가 중복될 경우 예외 발생_
3. 당첨 결과 출력
    1. 등수 별 당첨 개수 출력
    2. 수익률 출력

## 2. 패키지 구성

📦lotto <br>
┣ 📂`constance`<br>
┣ 📂`controller` <br>
┣ 📂`exception` <br>
┃ ┗ 📂`exceptionhandler` - 예외 처리 방법 추상화 패키지<br>
┣ 📂`model` <br>
┃ ┗ 📂`domain` <br>
┃ &nbsp; &nbsp;&nbsp; ┣ 📂`lotto` <br>
┃ &nbsp; &nbsp;&nbsp; ┃ ┗ 📂`lottogenerator` 로또를 생성하는 방법 추상화 패키지<br>
┃ &nbsp; &nbsp;&nbsp; ┗ 📂`result` <br>
┃ &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ┗ 📂`compare` <br>
┗ 📂`view` <br>
&nbsp; &nbsp; &nbsp;┗ 📂`io` 입출력 처리 객체 패키지<br>

## 3. 주요 구성

### Controller

#### `class LottoController`

**전체 로또 게임을 총괄하는 객체**

### Exception

#### `interface ExceptionHandler`

**예외 처리 방법에 대한 추상화 인터페이스**

#### `class RetryExceptionHandler implements ExceptionHandler`

**예외 발생 시 예외를 출력 후 다시 로직을 수행한다.**

#### `enum LottoGameException`

**로또 게임에서 발생할 수 있는 모든 예외를 관리한다.**

- 기능
    - 미리 정의된 메시지를 사용한 `IllegalArgumentException`을 반환한다.
        - 주의! <br>`IllegalArgumentException`을 발생시키는 것이 아니라, `IllegalArgumentException` 객체를 반환한다.

### Model / Lotto

#### `class Lotto`

**로또 한 장의 정보를 담는 객체**

- 기능
    - 로또 숫자를 불변 객체로 반환
    - `Lotto` 객체 두 개를 비교한 뒤, 결과를 `CompareResult`로 반환한다.

#### `class LottoAnswer extends Lotto`

**정답 로또 정보를 담는 객체**

- 보너스 숫자

### Model / Lotto / LottoGenerator

#### `abstract class LottoGenerator`

**로또를 생성해 주는 객체** _(로또 숫자를 생성하는 방법은 추상화)_

#### `class RandomLottoGenerator extends LottoGenerator`

**랜덤 값을 이용해 로또를 생성해 준다.**

#### `class AnswerGenerator extends LottoGenerator`

**사용자의 입력 값을 이용해 로또 정답을 생성해 준다.**

#### `class FixedValueLottoGenerator extends LottoGenerator`

**(테스트용) 고정된 값을 이용해 로또를 생성해 준다.**

#### `class SequenceListLottoGenerator extends LottoGenerator`

**(테스트용) 주어진 입력 값 리스트를 이용해 로또를 생성해 준다.**

### Model / Result

#### `class LottoCompareResult`

**`Lotto` 객체끼리의 비교 결과를 저장한다.**

#### `class LottoAnswerCompareResult`

**`Lotto` 객체와 `LottoAnswer` 객체의 비교 결과를 저장한다.**

#### `enum LottoResult`

**당첨 결과를 담는 객체**

#### `class LottoResultFactory`

**로또 당첨 결과를 생성하는 객체**

- 기능
    - `Lotto` 객체를 비교하여 `LottoResult`를 반환한다.

#### `class LottoResults`

**로또 당첨 순위와 당첨 횟수를 저장하는 객체**

### Model / Etc

#### `class Money`

**입력 금액 관련 기능을 제공하는 객체**

- 기능
    - 로또를 더 살 수 있는지 판단한다.
    - 로또를 사기 위한 금액을 지불한다.

#### `class Revenue`

**수익 관련 정보를 저장하는 객체**

### view

#### `class Reader, Writer`

**각각 입력, 출력의 일반적인 기능을 제공하는 객체**

#### `TerminalUI`

**비즈니스 로직에게 필요한 입,출력 기능을 제공하는 객체**