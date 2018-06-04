//package requirements;

//Requirement class written by Stuart Tresslar for the Final Project in
//Software Project Management (SWE 4663), taught by Dr. Hassan Purnaghsband at
//Kennesaw State University.

//The Requirement object holds the parameters needed when keeping track of info
//on a functional or nun-functional requirement. The changeable parameters are
//a boolean to determine whether the requirement is functional or non-functional
//(with it being TRUE and FALSE respectively), name of the requirement,
//description of the requirement, and time estimates for Requirements Analysis,
//Design, Coding, Testing, and overall Project Management.
public class Requirement {
    //Declaring the different variables described above.
    private boolean functional;
    private String name;
    private String description;

    //Default constructor method
     Requirement() {
        functional = true;
        name = "Requirement";
        description = "This is a basic description.";
    }

    //Cosntructor used to create a basic Requirement object.
     Requirement(boolean fun, String nm, String des) {
        functional = fun;
        name = nm;
        description = des;
    }

    //These are all generic getters so the variables can be viewed.
     boolean getFunctional(){
        return functional;
    }

     String getName(){
        return name;
    }

     String getDescription(){
        return description;
    }

    //These methods are all generic setters to set the variables externally.
    public void setFunctional(boolean fn){
        functional = fn;
    }

    public void setName(String nme){
        name = nme;
    }

    public void setDescription(String ds){
        description = ds;
    }
}
