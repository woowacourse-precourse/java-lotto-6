# 3주차 미션: 로또 게임 구현 기능 목록

# Model

## ❌ 로또 번호 생성 기능

- ❌ getLottoRandomNumber 메서드 구현
    -  1부터 45까지의 숫자 중 서로 다른 수로 이루어 진 random 6자리의 숫자 리스트 생성

## ❌ 로또 번호 정렬 기능

- ❌ sortLottoNumber 메서드 구현
    -  로또 번호 리스트를 오름차순으로 정렬

## ❌ 당첨 번호 일치 개수 반환 기능

- ❌ getWinningNumberCount 메서드 구현
    -  당첨 번호 리스트와 구매 번호 리스트를 비교해 당첨 개수 반환

## ❌ 보너스 번호 일치 여부 기능

- ❌ isMatchBonusNumber 메서드 구현
    -  구매 번호 리스트 중 보너스번호가 하나라도 일치할 경우 true 반환

# View
## ❌ 구매 로또 개수 출력

- ❌ displayLottoCount
    -  구매한 로또 개수 출력 'n개를 구매했습니다'

## ❌ 구매 로또 번호 리스트 출력

- ❌ displayLottoNumberList
    -  생성된 로또 번호 6개 리스트 형식으로 출력

## ❌ 당첨 통계 출력

- ❌ displayLottoResult
    -  구매한 로또의 결과를 집계
    - 각 등수별 당첨 개수를 출력
    - 수익률 출력

## ❌ 에러 메시지 출력

- ❌ displayErrorMessage
    -  검증에서 실패할 경우 실패한 사유 출력

## ❌ 구입금액 입력

- ❌ getInputPurchaseAmount 메서드 구현
    - '구입금액을 입력해 주세요.' 출력
    - 사용자의 입력을 통해 구매 금액을 입력

## ❌ 당첨 번호 입력

- ❌ getInputWinningNumber 메서드 구현
    - '당첨 번호를 입력해 주세요.' 출력
    - 사용자의 입력을 통해 로또 당첨 번호를 입력
        - 6개 번호를 입력
        - 번호를 쉽표(,)를 기준으로 구분
        - 1부터 45사이의 숫자를 입력

## ❌ 보너스 번호 입력

- ❌ getInputBonusNumber 메서드 구현
    - '보너스 번호를 입력해 주세요.' 출력
    - 사용자의 입력을 통해 보너스 번호를 입력
        - 1부터 45사이의 숫자를 입력

# Controller

## ❌ 구매 금액 입력 검증

- ❌ 메서드 구현
    - 사용자가 구매 금액을 1,000원 단위로 입력 했는지 검증

## ❌ 입력 값 타입 검증

- ❌ validateInputIsNumeric 메서드 구현
    - 사용자가 숫자를 입력했는지 검증

## ❌ 입력 널 값 검증

- ❌ validateInputIsNull 메서드 구현
    - 사용자가 Null을 입력 했는지 검증

## ❌ 로또 번호 검증

- ❌ validateNumberRange 메서드 구현
    - 숫자가 1부터 45사이의 숫자인지 검증
    - 조건에 부합 하지 않을 경우 false 리턴

## ❌ 로또 당첨 번호 입력 검증

- ❌ validateInputWinningNumber 메서드 구현
    - 6개의 숫자를 입력 했으며, (,)로 구분 했는지 검증

## ❌ 보너스 번호 검증 기능

- ❌ validateInputBonusNumber 메서드 구현
    - validateNumberRange를 통해 검증