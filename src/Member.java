//Class name:  Member
//Written by:  Zikomo S. Bullock
//Purpose:  Final project in Software Project Management (4663), taught by Dr. Hassan Purnaghsband at Kennesaw State University
//The purpose of this class is to hold all values pertaining to team members of Software Projects.
import java.util.ArrayList;

public class Member {
    //DEFAULT CONSTRUCTOR OF THE MEMBER CLASS:
    public Member(){
        sName="Team member name";
    }

    //CONSTRUCTOR FOR THE MEMBER CLASS:
    public Member(String sName){
        this.sName=sName;
    }

    //GENERIC ACCESSORS FOR THE MEMBER CLASS:
    public String getsName() { return sName; }


    //GENERIC MUTATORS FOR THE MEMBER CLASS:
    public void setsName(String sName) { this.sName = sName; }


    //MODIFICATION MEMBER FUNCTIONS FOR THE MEMBER CLASS
    //postcondition:  Adds a requirement to either functional or non-functional requirements
    public void addRequirement(Requirement rq){
        if(!(rq.getFunctional())){
            alNFR.add(rq);
        }
        else if(rq.getFunctional()){
            alFR.add(rq);
        }
    }

    //ALL MEMBER VARIABLES FOR THE MEMBER CLASS:
    private String sName;
    private ArrayList<Requirement> alFR;                    //ArrayList of Functional Requirements
    private ArrayList<Requirement> alNFR;                   //ArrayList of Non-Functional Requirements
}
