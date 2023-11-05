# MVC 패턴으로 제작한 로또 게임

## Controller
    [⭕] 전체 실행 run

    [⭕] 구매 금액 사용자 입력
        ㄴ [⭕] 구매 금액이 숫자가 아닐 시 ERROR

    [⭕] 랜덤 생성 Lotto 출력

    [⭕] 당첨 번호 사용자 입력
        ㄴ [⭕] 당첨 번호가 숫자가 아닐 시 ERROR

    [⭕] 보너스 번호 사용자 입력
        ㄴ [⭕] 보너스 번호가 숫자가 아닐 시 ERROR

        ㄴ [⭕] 보너스 번호가 당첨 번호와 중복 시 ERROR
    
    [⭕] 당첨 통계 출력


## Service
    [⭕] 금액을 전달받아 랜덤값 Lotto 생성
    
    [⭕] 구매한 Lotto를 문자열로 만들어 전달

    [⭕] 정답 Lotto 생성

    [⭕] 정답 개수 갱신

    [⭕] 정답 개수 반환
    
    [⭕] 수익률 게산

### 정답 번호
    [⭕] 생성자로 정답 지정

    [⭕] 정답과 같은 개수를 반환 

    [⭕] 정답과 비교해 Lotto의 Match 반환 

## View
    [⭕] 구입 금액 입력 안내 출력
    
    [⭕] 구매한 내역 출력
    
    [⭕] 당첨 번호 입력 안내 출력
    
    [⭕] 보너스 번호 입력 안내 출력
    
    [⭕] 당첨 통계 출력

    [⭕] 수익률 출력


## Repository
    [⭕] Lotto, Match Map store

    [⭕] Service에서 가공된 데이터 전달받은 걸로 store save
    
    [⭕] 전체 조회 findAll
    
    [⭕] Match와 같은 Lotto 개수 반환 

    [⭕] 갱신 update


## Domain
*Randoms.prickUniqueNumbersInRange 함수를 확인했을 때 <br>범위 내의 값만 나오도록 설정된 걸 알 수 있었으나<br>
당첨 번호를 설정할 때 체크하는 용도 겸 다른 함수를 이용해 제작될 경우를 고려해 체크했다.*

    [⭕] Lotto
        ㄴ [⭕] Lotto 번호가 6개가 아닐 시 ERROR

        ㄴ [⭕] Lotto 번호끼리 중복일 시 ERROR

        ㄴ [⭕] Lotto 번호가 1~45 값이 아닐 시 ERROR
                

    [⭕] Match (일치 개수 Enum)

## Test
    [  ] Lotto 번호와 보너스 번호가 중복인 경우

    [  ] Lotto 번호가 1~45 내의 번호가 아닌 경우

    [  ] Lotto 번호와 WinLotto를 설정하여 특정 Match의 값이 나오는지