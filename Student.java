
import java.io.*;
import java.util.*;

class Student implements Comparable<Object> {

    private String stuid;//学号
    private String name;//姓名
    private Double Mathscore, Englishscore, Javascore;//三门成绩
    private Double ScoreSum;//总成绩
    private Double AverageSum;
    public Student(String stuid, String name, Double mathscore, Double englishscore, Double javascore) {
        this.stuid = stuid;
        this.name = name;
        Mathscore = mathscore;
        Englishscore = englishscore;
        Javascore = javascore;
        this.ScoreSum = Mathscore + Englishscore + Javascore;
        this.AverageSum = ScoreSum / 3.0;

    }



    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMathscore() {
        return Mathscore;
    }

    public void setMathscore(Double mathscore) {
        Mathscore = mathscore;
    }

    public Double getEnglishscore() {
        return Englishscore;
    }

    public void setEnglishscore(Double englishscore) {
        Englishscore = englishscore;
    }

    public Double getJavascore() {
        return Javascore;
    }

    public void setJavascore(Double javascore) {
        Javascore = javascore;
    }

    public Double getScoreSum() {
        return ScoreSum;
    }

    public void setScoreSum() {
        this.ScoreSum = Mathscore + Englishscore + Javascore;
    }

    public Double getAverageSum() {
        return AverageSum;
    }

    public void setAverageSum() {
         this.AverageSum = getScoreSum() / 3.0;
    }
    @Override
    public String toString() {//输出字符串类型
        return String.format("%-10s\t%-5s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f", stuid, name, Mathscore, Englishscore, Javascore, getScoreSum(),getAverageSum());
    }
    @Override
    public int compareTo(Object o) {//按学号排序（默认）
        // TODO Auto-generated method stub
        Student s = (Student) o;
        return this.stuid.compareTo(s.stuid);
    }
}