package game.service;

/**
 * <pre>
 * 
 * Class Name : GuGuDanService
 * Info : 구구단 정보입력 및 게임실행
 *  
 * </pre>
 * @author LEE SEONG-HYUN
 *
 */
public class TimesTableService {
    final private int stepStNum=2;
    final private int sequenceStNum=1;

    public TimesTableService() {
        
    }
    
    /**
     * 구구단 기본(2단~9단) 실행한다.
     * Two steps and nine steps times
     */
    public String runTimesTables() {
        return runTimesTables( 9, 9);
    }
    
    /**
     * 2단부터 특정 단의 특정 순서까지 출력하는 구구단을 생성한다. 
     * Two steps and specific steps times
     * @param steps
     */
    public String runTimesTables(int steps) {
        return runTimesTables(steps, 9);
    }
    
    /**
     * 특정 단의 특정 순서까지 출력하는 구구단을 생성한다. 
     * 2단부터 specific steps times sequence
     * @param steps
     * @param sequence
     */
    private String runTimesTables(int steps, int sequence) {
        return runTimesTables(steps, sequence, 2, 1);
    }
    
    /**
     * 특정 단을 출력하는 구구단을 생성한다. 
     * specific steps times
     * @param steps
     */
    public String runTimesTable(int steps) {
        return runTimesTables(steps, 9, steps, 1);
    }
    
    /**
     * 구구단을 계산하는 메소드이다.
     * Times Method 
     * @param steps
     * @param sequence
     * @param stepStNum
     * @param sequenceStNum
     * @return
     */
    private String runTimesTables(int steps, int sequence, int stepStNum, int sequenceStNum) {
        if(9<steps){
            sequence = steps;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = stepStNum; i <= steps; i++) {
            sb.append("[ ");
            sb.append(i);
            sb.append(" 단]\n");
            for (int j = sequenceStNum; j <= sequence; j++) {
                sb.append(i);
                sb.append(" X ");
                sb.append(j);
                sb.append(" = ");
                int times = i*j;
                sb.append(times);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
