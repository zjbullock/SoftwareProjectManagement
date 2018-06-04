//Class name:  SoftwareProject
//Written by:  Zikomo S. Bullock
//Purpose:  Final project in Software Project Management (4663), taught by Dr. Hassan Purnaghsband at Kennesaw State University
//The purpose of this class is to hold all values pertaining to software projects.  Specifically, each software project shall hold a description,
//an owner or project manager, and team members for the project.  Each software project shall hold a list of risks associated with it, and a list of both functional
//and non-functional requirements.  The number of team members working on the project will also be recorded with each Software Project.
import java.util.ArrayList;



public class SoftwareProject {
    //DEFAULT CONSTRUCTOR OF THE SOFTWAREPROJECT CLASS:
    public SoftwareProject(){
        sDescription="Description of the Software Project";
        sProjectManager="Owner or Project Manager for the project";
    }


    //CONSTRUCTOR FOR THE SOFTWAREPROJECT CLASS:
     SoftwareProject(String description, String projectManager){
        sDescription=description;
        sProjectManager=projectManager;
    }


    //GENERIC ACCESSORS FOR THE SOFTWAREPROJECT CLASS:
    String getsDescription() { return sDescription; }

    String getsProjectManager() { return sProjectManager; }

    String [] getSaTeamMembers() { return teamMembers; }

    ArrayList<Risk> getRisks() { return risks; }

    ArrayList<Requirement> getAlFunctionalRequirement() { return alFR; }

    ArrayList<Requirement> getAlNonFunctionalRequirement() { return alNFR; }

    int getiMemberCount() { return iMemberCount; }

    double getRATime() { return RATime; }

    double getDTime() { return DTime; }

    double getCTime() { return CTime; }

    double getTTime() { return TTime; }

    double getPMTime() { return PMTime; }


    //GENERIC MUTATORS FOR THE SOFTWAREPROJECT CLASS:
    void setsDescription(String sDescription) { this.sDescription = sDescription; }

    void setsProjectManager(String sProjectManager) { this.sProjectManager = sProjectManager; }

    public void setSaTeamMembers(String[] teamMembers) { this.teamMembers = teamMembers; }

    public void setAlRisks(ArrayList<Risk> risks) { this.risks = risks; }

    public void setAlFunctionalRequirement(ArrayList<Requirement> alFunctionalRequirement) { this.alFR = alFunctionalRequirement; }

    public void setAlNonFunctionalRequirement(ArrayList<Requirement> alNonFunctionalRequirement) { this.alNFR = alNonFunctionalRequirement; }

    public void setiMemberCount(int iMemberCount) { this.iMemberCount = iMemberCount; }

    void addRATime(double time) { RATime += time; }

    void addDTime(double time) { DTime += time; }

    void addCTime(double time) { CTime += time; }

    void addTTime(double time) { TTime += time; }

    void addPMTime(double time) { PMTime += time; }


    //MODIFICATION MEMBER FUNCTIONS FOR THE SOFTWAREPROJECT CLASS:
    //precondition: getiMemberCount is not 0;
    //postcondition:  Team member is added to the project
    void addTeamMember(String member){
        if(getiMemberCount()<1000){
            teamMembers[getiMemberCount()]=member;
            iMemberCount++;
        }

        else{ System.out.println("Array Limit of Members reached."); }
    }

    //postcondition:  Retrieves the total time spent on the project
    double getTotalTime(){
        return RATime + DTime + CTime + TTime + PMTime;
    }

    //postcondition:  A Risk is added to list of project Risks
    void addRisk(Risk risk){ risks.add(risk); }

    //postcondition:  Adds a requirement to either functional or non-functional requirements
    void addRequirement(Requirement rq){
        if(!(rq.getFunctional())){ alNFR.add(rq); }

        else if(!(rq.getFunctional())){ alFR.add(rq); }
    }


    //ALL MEMBER VARIABLES FOR THE SOFTWAREPROJECT CLASS:
    private String sDescription;
    private String sProjectManager;
    private int iMemberCount=0;
    private String [] teamMembers=new String[1000];
    private ArrayList<Risk> risks = new ArrayList<>();
    private ArrayList<Requirement> alFR = new ArrayList<>();                    //ArrayList of Functional Requirements
    private ArrayList<Requirement> alNFR = new ArrayList<>();                   //ArrayList of Non-Functional Requirements

    private double RATime = 0;
    private double DTime = 0;
    private double CTime = 0;
    private double TTime = 0;
    private double PMTime = 0;

}
