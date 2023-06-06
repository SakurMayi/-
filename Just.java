
class Just extends Student{
    private String hg;

    public Just(String stuid, String name, Double mathscore, Double englishscore, Double javascore) {
        super(stuid, name, mathscore, englishscore, javascore);
        // TODO Auto-generated constructor stub
        if(super.getScoreSum()<180)
            hg = "out";
        else
            hg = "pass";
    }
    public String getHg() {

        return hg;
    }
    public void setHg() {
        if(super.getScoreSum()<180)
            hg = "out";
        else
            hg = "pass";
        this.hg = hg;
    }
    @Override
    public String toString() {
        return String.format("%-10s\t%-5s\t%s", super.getStuid(),super.getName(),getHg());
    }

}
