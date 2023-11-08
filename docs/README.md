# 📌 간단한 프로젝트 소개
- 한 장에 1000원짜리인 로또를 여러개 산다.
- 6개의 숫자와 1개의 보너스 수를 입력한다.
- 구매한 로또의 당첨 번호와 입력한 번호가 몇 개 일치하는지 보고 순위를 매겨서 상금을 지급한다.
- 각 로또의 당첨번호는 공개된다.
- 수익률이 계산되어 공개된다.

--- 

# 📌 구현 기능 목록

# 1. 구입금액이 숫자로 입력됐는지 확인 - Service 클래스로 관리

- Integer.parseInt 사용
- 숫자가 아니면 IllegalArgumentException 던지고 “[ERROR] 숫자를 입력하세요” 출력
    - 다시 입력하게 하기

# 2. 구입 금액이 1000으로 나누어 떨어지는지 확인 - Service 클래스로 관리
- 1000으로 나눠 떨어지면 몫 저장
- 나눠떨어지지 않으면  IllegalArgumentException 던지고 “[ERROR] 구입 금액은 1000의 배수여야 합니다.” 출력
    - 다시 입력하게 하기

# 3. 당첨 금액 입력 받아 저장하기 - Lotto 클래스로 관리

- 숫자를 입력했는지 검증
    - Integer.parseInt()로 검증
    - 예외 발생시 IllegalArgumentException 던지고 “[ERROR] 숫자를 입력하세요” 출력
- 6자리인지 검증
    - 예외 발생시 IllegalArgumentException 던지고 “[ERROR] 숫자를 6개 입력하세요” 출력
- 중복된 숫자인지 검증
    - 예외 발생시 IllegalArgumentException 던지고 “[ERROR] 같은 숫자를 2개 이상 입력할 수 없습니다” 출력
- 입력된 번호가 1~45 사이의 숫자인지 검증
    - Service의 rangeValidation() 사용

# 4. 보너스 번호 입력 받아 저장하기 - Service 클래스로 관리

- 숫자를 입력했는지 검증
    - Integer.parseInt()로 검증
    - 예외 발생시 IllegalArgumentException 던지고 “[ERROR] 숫자를 입력하세요” 출력
        - 다시 입력받기
- 1~45 범위의 수를 입력했는지 검증
  - 예외 발생시 IllegalArgumentException 던지고 “[ERROR] 1~45 범위의 숫자를 입력하세요.” 출력
    - 다시 입력받기
- 당첨번호로 입력했던 수와 보너스번호가 겹치는지 검증
  - 예외 발생시 IllegalArgumentException 던지고 “[ERROR] 당첨 번호로 입력했던 숫자는 보너스 번호가 될 수 없습니다.” 출력
    - 다시 입력받기

# 5. 로또 발행 - Lottery 클래스로 관리

- 필드
    - 로또 당첨 번호
    - 순위
- 구현할 기능
    - 로또 당첨 번호 생성하고 정렬하기
    - 로또 당첨 번호와 입력한 당첨 번호가 몇 개나 일치하는지 확인하고 일치하는 번호 개수 반환
    - 순위 정하기 (enum)

# 6. 결과 집계 - Service 클래스로 관리
- 순위 별로 로또 개수 집계해서 Map<순위, 개수>에 저장
- 수익률 계산