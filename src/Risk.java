/*Class name:  SoftwareProject
Written by:  Zikomo S. Bullock
Purpose:  Final project in Software Project Management (4663), taught by Dr. Hassan Purnaghsband at Kennesaw State University
The purpose of this class is to hold all values pertaining to the Risks of the software project.  Each Risk will have a description and status.*/

public class Risk {
    //DEFAULT CONSTRUCTOR OF THE RISK CLASS:
     Risk(){
        sDescription="Description of the risk";
        sStatus="Status of the risk";
    }


    //CONSTRUCTOR OF THE RISK CLASS:
    Risk(String sDescription, String sStatus){
        this.sDescription=sDescription;
        this.sStatus=sStatus;
    }


    //GENERIC ACCESSORS FOR THE RISK CLASS:
     String getsDescription() { return sDescription; }

     String getsStatus() { return sStatus; }


    //GENERIC MUTATORS FOR THE RISK CLASS:
    public void setsDescription(String sDescription) { this.sDescription = sDescription; }

    public void setsStatus(String sStatus) { this.sStatus = sStatus; }


    //ALL MEMBER VARIABLES FOR THE RISK CLASS:
    private String sDescription;
    private String sStatus;
}
