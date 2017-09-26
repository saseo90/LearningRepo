package game.vo;
/**
 * <pre>
 * 
 * Class Name : TeamInfo
 * Info : 팀의 정보 객체 클래스
 *  
 * </pre>
 * @author seo-HG
 *
 */
public class TeamInfo {

    /** 팀 고유번호 */
    private int teamNo;
    /** 소속 국가 이름 */
    private String countryName;
    /** 조 이름 */
    private String groupName="";
    
    public TeamInfo(int teamNo, String countryName) {
        super();
        this.teamNo = teamNo;
        this.countryName = countryName;
    }
    
    public int getTeamNo() {
        return teamNo;
    }
    public void setTeamNo(int teamNo) {
        this.teamNo = teamNo;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "팀정보 [팀번호=" + teamNo + ", 소속국가이름=" + countryName +", 조이름="+groupName+ "]";
    }
    
    
}
