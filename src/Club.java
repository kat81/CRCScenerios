public class Club {

    private String name;
    private String description;
    private String sponsor;
    private String president;
    private Roster roster;
    public Club next;

    public Club(String name, String desc, String sp, String pres, Student[] rst) {
        this.name = name;
        this.description = desc;
        this.sponsor = sp;
        this.president = pres;
        this.roster = new Roster();
        for (int i = 0; i < rst.length; i++)
            roster.insertFirstStudent(rst[i].getName(), rst[i].getGrade());
    }

    public void addStudent(String name, String grade) {
        roster.insertFirstStudent(name, grade);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSponsor() {
        return this.sponsor;
    }

    public String getPresident() {
        return this.president;
    }

    public Roster getRoster() {
        return this.roster;
    }
}
