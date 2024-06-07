package ksmart.springboot.exam.dto;

public class Member {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberLevel;
    private String memberMobile;

    public Member() {}

    public Member(String memberId, String memberPw, String memberName, String memberLevel, String memberMobile) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberLevel = memberLevel;
        this.memberMobile = memberMobile;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("memberId='").append(memberId).append('\'');
        sb.append(", memberPw='").append(memberPw).append('\'');
        sb.append(", memberName='").append(memberName).append('\'');
        sb.append(", memberLevel='").append(memberLevel).append('\'');
        sb.append(", memberMobile='").append(memberMobile).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
