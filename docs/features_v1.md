# 설계

# DOMAIN

## MONEY

### `class Money`: 금액 검증 및 표시

    `spend(int amount)`: 현재 소지금에서 `amount`만큼 차감

---

### `class Wallet`: 잔액을 담을 수 있는 지갑을 표현

    - [ ] 필드:
      `Money remainedMoney`

---

## LOTTO

### `class Lotto`: 로또 번호 6자리를 담은 티켓

    - [ ] 필드:
      `List <LottoNumber> numbers`: 로또 번호 6자리

    - [ ] 기능:
      `boolean contains(int): 특정 숫자 포함 여부 반환
      `int count`

### `class Lottos`: 로또 일급 컬렉션

    - [ ] 필드:
      `List <Lotto> lottos`: 사용자가 구매한 모든 로또 소유

---

## `class LottoStore`: 로또 판매점

    - [ ] 필드:
        `RandomLottoGenerator`
        `static Money PRICE_PER_LOTTO`
    - [ ] 기능:
        `Lottos buyUntilOutOfMoney(Money)`: 모든 금액을 소비하여 로또 구매

---

## `class LottoGenerator`: 로또 발행기

    - [ ] 필드:
        `SizedNumbersGenerator`: N자리의 숫자로 이루어진 리스트 생성기

    - [ ] 기능:
        `Lotto generate()`: 임의의 번호를 가진 로또 발행

---

## `interface SizedNumbersGenerator`: N자리의 랜덤 숫자 배열 반환

    - [ ] 필드:
        `startInclusive`: 생성할 랜덤 숫자의 최소 범위
        `endInclusive`: 생성할 랜덤 숫자의 최대 범위
        `size`: 생성할 숫자 배열 길이

    - [ ] 기능:
      `List <Integer> generate`: N자리의 랜덤 숫자 리스트 반환

---

## `class LottoDrawingMachine`: 로또 번호 추첨 기계

    - [ ] 필드:
      `List <Integer> numbers`: 당첨 번호 6자리
      `int bonusNumber`: 보너스 번호
      
    - [ ] 기능:
      `LottoRrawingResult draw(Lotto)`: 로또 티켓을 받아서 당첨 번호 및 보너스 번호와 비교 및 결과 반환

---

# DTO

## `enum LottoDrawingResult`: 로또 당첨 결과

    - [ ] 필드:
      `int place`: 등수
      `int price`: 당첨 금액
      `int matchCount`: 일치하는 번호 갯수
      `boolean hasBonusNumber`: 보너스 번호 유무
      
    - [ ] 기능:
      `draw(matchCount, hasBonusNumber)`: 일치하는 갯수와 보너스 번호 유무를 토대로 등수에 해당하는 enum constant 반환

---



