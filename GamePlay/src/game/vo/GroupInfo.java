package game.vo;

/**
 * <pre>
 * 
 * Class Name : GroupInfo
 * Info : 리그 조별 정보 객체 클래스 , 특정 팀의 리그 경기결과
 *  
 * </pre>
 * @author LEE SEONG-HYUN
 *
 */
public class GroupInfo {

    /** 조 이름 */
    private String groupName="";
    /** 팀 고유번호 */
    private int teamNo;
    /** 경기 횟수 */
    private int matchNo=0;
    /** 승리 횟수*/
    private int winNo=0;
    /** 패배 횟수 */
    private int loseNo=0;
    /** 순위 */
    private int rank=0;
    /** 토너먼트 진출여부 */
    private boolean flag =false;
    
    public GroupInfo(){};

    public GroupInfo(String groupName, int teamNo) {
        super();
        this.groupName = groupName;
        this.teamNo = teamNo;
    }
    
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public int getTeamNo() {
        return teamNo;
    }
    public void setTeamNo(int teamNo) {
        this.teamNo = teamNo;
    }
    /** 승리 횟수*/
    public int getWinNo() {
        return winNo;
    }
    /** 순위 */
    public int getRank() {
        return rank;
    }
    /** 토너먼트 진출여부 */
    public boolean getflag() {
        return flag;
    }

    /** 리그 승리 */
    public void updateWin() {
        this.matchNo++;
        this.winNo++;
    }
    /** 리그 패배 */
    public void updateLose() {
        this.matchNo++;
        this.loseNo++;
    }
    /** 순위 업데이트 */
    public void updateRank(int rank) {
        this.rank=rank;
    }
    /** 토너먼트 진출가능 업데이트 */
    public void updateFlag() {
        this.flag=true;
    }

    @Override
    public String toString() {
        return "GroupInfo [groupName=" + groupName + ", teamNo=" + teamNo + ", matchNo=" + matchNo + ", winNo=" + winNo
                + ", loseNo=" + loseNo + ", rank=" + rank + ", flag=" + flag + "]";
    }

}
