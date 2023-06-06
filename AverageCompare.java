import java.util.Comparator;

public class AverageCompare implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        // TODO Auto-generated method stub
        return (int)(o2.getAverageSum() - o1.getAverageSum());
    }

}