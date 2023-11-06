### 로또 게임
## docs - [x] 기능 목록
    feat - [x] View 메세지 관리 기능
    feat - [x] View “구입금액을 입력해 주세요.” 일반 메세지 출력 기능
    feat - [x] Controller 사용자 입력 기능을 호출하는 기능
    feat - [x] View 사용자 입력 기능(Console)
    feat - [x] Controller 입력된 문자열(금액) 저장 기능
        test - [x] 입력된 문자열이 정수로 변환 가능하지 않으면 IllegalArgumentException 발생 확인 기능
    feat - [x] Model 저장된 금액이 정수로 변환 가능하지 않으면 IllegalArgumentException을 발생시키는 기능
    feat - [x] Controller IllegalArgumentException이 발생하면 [ERROR]로 시작하는 View의 에러 메세지 출력 기능 호출 기능
    feat - [x] View “[ERROR] 유효하지 않은 입력입니다. 재입력 부탁드립니다.” 예외 메세지 출력 기능
    feat - [x] Model 저장된 금액이 정수로 변환 시키는 기능
        test - [x] 저장된 금액이 1000으로 나누어 떨어지지 않으면 IllegalArgumentException을 발생시키는 기능
    feat - [x] Model 저장된 금액이 1000으로 나누어 떨어지지 않으면 IllegalArgumentException을 발생시키는 기능
    feat - [x] Controller IllegalArgumentException이 발생하면 [ERROR]로 시작하는 View의 에러 메세지 출력 기능 호출 기능
    feat - [x] View “[ERROR] 천 단위로 금액 입력 부탁드립니다.” 예외 메세지 출력 기능
    feat - [x] View “[ERROR] 천 단위로 금액 입력 부탁드립니다.” 예외 메세지 누락 수정
    feat - [x] Model 입력된 금액을 복권 매수로 연산하는 기능
    feat - [ ] View 빈 라인을 출력하는 기능
    feat - [ ] Controller 복권 매수를 출력하는 기능을 호출하는 기능
    feat - [ ] View “복권 매수 + 개를 구매했습니다. “ 연산 메세지 출력 기능
    feat - [ ] Model 1~45 사이의 서로 다른 수 6개로 이루어진 리스트를 만드는 기능(Randoms)
    feat - [ ] Model 1~45 사이의 서로 다른 수 6개로 이루어진 리스트를 담는 기능(Lotto)
    feat - [ ] Model 1~45 사이의 서로 다른 수 6개로 이루어진 리스트를 오름차순으로 정렬하는 기능
    feat - [ ] Model 1~45 사이의 서로 다른 수 6개로 이루어진 리스트를 문자열로 표현하는 기능
    feat - [ ] Model 1~45 사이의 서로 다른 수 6개로 이루어진 리스트를 담는 객체를 생성하는 기능
    feat - [ ] Model 1~45 사이의 서로 다른 수 6개로 이루어진 리스트를 담는 객체를 복권 매수 만큼 생성하여  리스트에 담는 기능
    feat - [ ] Controller 객체를 복권 매수 만큼 생성하여 담은 리스트를 출력하는 기능을 호출하는 기능
    feat - [ ] View 객체를 복권 매수만큼 생성하여 담은 리스트를 출력하는 기능
    feat - [ ] View 빈 라인을 출력하는 기능
    feat - [ ] View “`당첨 번호를 입력해 주세요.`" 일반 메세지 출력 기능
    feat - [ ] Controller 사용자 입력 기능을 호출하는 기능
    feat - [ ] View 사용자 입력 기능(Console)
    feat - [ ] Controller 입력된 문자열(당첨 번호) 저장 기능
    feat - [ ] Model 저장된 당첨 번호가 구분자 쉼표(,)로 쪼개지지 않으면 IllegalArgumentException을 발생시키는 기능
    feat - [ ] Controller IllegalArgumentException이 발생하면 [ERROR]로 시작하는 View의 에러 메세지 출력 기능 호출 기능
    feat - [ ] View “[ERROR] 구분자는 오직 쉼표(,)여야 합니다. 재입력 부탁드립니다.” 예외 메세지 출력 기능
    feat - [ ] Model 저장된 당첨 번호에 중복이 있으면 IllegalArgumentException을 발생시키는 기능
    feat - [ ] Controller IllegalArgumentException이 발생하면 [ERROR]로 시작하는 View의 에러 메세지 출력 기능 호출 기능
    feat - [ ] View “[ERROR] 중복값이 존재합니다. 재입력 부탁드립니다.” 예외 메세지 출력 기능
    feat - [ ] Model 저장된 당첨 번호의 범위가 1~45사이가 아니면 IllegalArgumentException을 발생시키는 기능
    feat - [ ] Controller IllegalArgumentException이 발생하면 [ERROR]로 시작하는 View의 에러 메세지 출력 기능 호출 기능
    feat - [ ] View “[ERROR] [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다. 재입력 부탁드립니다.” 예외 메세지 출력 기능
    feat - [ ] Model 저장된 당첨 번호와 중복이 되는지 확인하는 기능 IllegalArgumentException을 발생시키는 기능
    feat - [ ] Controller IllegalArgumentException이 발생하면 [ERROR]로 시작하는 View의 에러 메세지 출력 기능 호출 기능
    feat - [ ] View “[ERROR] 중복값이 존재합니다. 재입력 부탁드립니다.” 예외 메세지 출력 기능
    feat - [ ] Model 입력된 당첨 번호를 쉼표로 쪼개어 문자열 배열에 담는 기능
    feat - [ ] Model 문자열 배열에 담긴 당첨 번호를 SET에 담는 기능
    feat - [ ] View 빈 라인을 출력하는 기능
    feat - [ ] View “`보너스 번호를 입력해 주세요.`” 일반 메세지 출력 기능
    feat - [ ] View “`보너스 번호를 입력해 주세요.`” 일반 메세지 출력 기능
    feat - [ ] Controller 사용자 입력 기능을 호출하는 기능
    feat - [ ] View 사용자 입력 기능(Console)
    feat - [ ] Model 저장된 보너스 번호의 범위가 정규표현식을 이용하여 문자 1~45 이외의 값이면 IllegalArgumentException을 발생시키는 기능
    feat - [ ] Controller IllegalArgumentException이 발생하면 [ERROR]로 시작하는 View의 에러 메세지 출력 기능 호출 기능
    feat - [ ] View “[ERROR] 유효하지 않은 입력입니다. 재입력 부탁드립니다.” 예외 메세지 출력 기능
    feat - [ ] Model 저장된 보너스 번호가 당첨 번호와 중복된 값이면 IllegalArgumentException을 발생시키는 기능
    feat - [ ] Controller IllegalArgumentException이 발생하면 [ERROR]로 시작하는 View의 에러 메세지 출력 기능 호출 기능
    feat - [ ] View “[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 재입력 부탁드립니다.” 예외 메세지 출력 기능
    feat - [ ] Controller 입력된 문자열(보너스 번호) 저장 기능
    feat - [ ] View 빈 라인을 출력하는 기능
    feat - [ ] View “`당첨 통계`” 일반 메세지 출력 기능
    feat - [ ] View “`---`” 일반 메세지 출력 기능
    feat - [ ] Model Lotto 당첨 기준과 당첨 금액 정보를 제공하는 기능
    feat - [ ] Model Lotto 객체가 담긴 리스트의 각 요소와 당첨 번호를 비교하여 당첨을 확인하는 기능
    feat - [ ] Model 당첨결과를 각 등수의 당첨내역에 카운트하는 기능
    feat - [ ] Controller 당첨 내역을 출력하는 기능을 호출하는 기능
    feat - [ ] View 당첨내역을 출력하는 기능
    feat - [ ] Model 각 당첨 내역의 수익을 합산하는 기능
    feat - [ ] Model 수익률을 구하는 기능
    feat - [ ] Controller 수익률 출력 기능을 호출하는 기능
    feat - [ ] View 수익률을 출력하는 기능
    feat - [ ] View 수익률에 대한 설명하는 내용을 출력하는 기능