package ksmart.springboot.exam.service;

import ksmart.springboot.exam.dto.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Service : 비즈니스 로직 수행, 기능구현, data 가공
 * (트랜잭션 : 논리적인 작업을 수행하는 한 단위)
 * bean 이름 : 디폴트 ExamService -> examService
 */

@Service
public class ExamService {

    public ExamService() {
        System.out.println("객체생성");
    }

    /**
     * 회원정보조회
     * @return Member
     */
    public Member getMemberInfo() {
        return new Member("id002", "pw002", "홍02", "판매자", "010-2222-2222");
    }

    /**
     * id로 회원정보 조회
     * @param memberId
     * @return Member
     */
    public Member getMemberInfoById(String memberId) {
        String[] level = new String[] {"관리자", "판매자", "구매자"};
        int i = Integer.parseInt(memberId.substring(2));
        String mobilePattern = ""+i+i+i+i;
        String memberPw = "pw"+String.format("%03d", i);
        String memberName = "홍" + String.format("%02d", i);
        String memberLevel = level[(i-1)%level.length];
        String memberMobile = "010-" + mobilePattern + "-" + mobilePattern;
        return new Member(memberId, memberPw, memberName, memberLevel, memberMobile);
    }

    /**
     * 회원목록 조회
     * @return List<Member>
     */
    public static List<Member> getMemberList(){
        // Member id001~id009 arrayList 만들어보세요.
        // id001 관리자 id002 판매자 id003 구매자
        List<Member> memberList = new ArrayList<Member>();
        String[] levelList = new String[]{"관리자", "판매자", "구매자"};
        Member member = null;
        for(int i=1; i<10; i++) {
            String memberId = "id00" + i;
            String memberPw = "pw00" + i;
            String memberLevel = levelList[(i-1)% levelList.length];
            String memberName = "홍0" + i;
            String memberMobile = "010-" + i + i + i + i + "-" + i + i + i + i;
            member = new Member(memberId, memberPw, memberName, memberLevel, memberMobile);
            memberList.add(member);
        }

        return memberList;
    }

    /* 예시
    public void payOrder(String memberId, Goods goods, Order order, Payment pay){
        // 1. 주문 내역확인 상품 재고 확인

        // 2. 주문 내역 결제 금액 충분한지

        // 3. 상품 재고 업데이트

        // 4. 주문 주문 이력 추가
    }
     */

}

