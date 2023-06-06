import java.util.Comparator;

public class JustCompare implements Comparator<Just> {

    @Override
    public int compare(Just o1, Just o2) {
        // TODO Auto-generated method stub
        return (int)(o2.getScoreSum() - o1.getScoreSum());
    }

}
