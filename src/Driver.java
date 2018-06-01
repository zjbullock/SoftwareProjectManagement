// Class name:  Driver
// Written by Jarred Wilson
// Main driver class for the Software Project Management System

//==============================================================================
// IMPORT STATEMENTS
//==============================================================================
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Driver
{

  //==============================================================================
  // MAIN METHOD
  //==============================================================================
    @SuppressWarnings("InfiniteLoopStatement")
  public static void main(String [] args)
  {

    //==============================================================================
    // VARIABLES USED FOR DATA INPUT
    //==============================================================================
    Scanner input = new Scanner(System.in);
    String choice;

    //==============================================================================
    // STARTUP BANNER
    //==============================================================================
    System.out.println("=========================================");
    System.out.println("WELCOME TO THE SOFTWARE MANAGEMENT SYSTEM");
    System.out.println("=========================================");
    System.out.println("Class: Software Project Management \n    Group GJ Fall Semester 2017 CO");
    System.out.println("Project Group: 5");
    System.out.println("Members: Jarred Wilson\n    Victoria Williams\n    Stuart Tresslar\n    Tyler Whitfield\n    Zikomo Bullock");
    System.out.println("=========================================");
    System.out.println("\n\nPlease enter a description of the Software Project.");
    String description = input.nextLine();
    System.out.println("Please enter the Project Manager.");
    String projectManager = input.nextLine();

    //==============================================================================
    // CREATING NEW PROJECT
    //==============================================================================
    SoftwareProject project1 = new SoftwareProject(description, projectManager);

    //==============================================================================
    // MAIN RUNNING LOOP
    //==============================================================================
    try{
        while(true)
        {
            DisplayProject(project1);
            PrintOptions();
            choice = input.nextLine();
            ChooseOption(choice, project1, input);
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
  }

  //==============================================================================
  // PRINTS MENU OPTIONS
  //==============================================================================
  private static void PrintOptions()
  {
        System.out.println("\nSELECT AN OPTION");
        System.out.println("\n1): Add Team Member");
        System.out.println("2): Add Risk");
        System.out.println("3): Add Functional Requirement");
        System.out.println("4): Add Non-Functional Requirement");
        System.out.println("5): Write New Description");
        System.out.println("6): Change Project Manager");
        System.out.println("7): Record Time");
        System.out.println("8): Exit");
  }

  //==============================================================================
  // DISPLAYS PROJECT INFORMATION
  //==============================================================================
   private static void DisplayProject(SoftwareProject currentProject)
  {
    //==============================================================================
    // TEMP VARIABLES FOR DISPLAYING DATA
    //==============================================================================
    ArrayList <Risk> riskList = currentProject.getRisks();
    Iterator <Risk> iterate = riskList.iterator();
    ArrayList <Requirement> funList = currentProject.getAlFunctionalRequirement();
    Iterator <Requirement> funIt = funList.iterator();
    ArrayList <Requirement> nonList = currentProject.getAlNonFunctionalRequirement();
    Iterator <Requirement> nonIt = nonList.iterator();
    String [] members = currentProject.getSaTeamMembers();
    Risk temp;
    Requirement tempF;

    //==============================================================================
    // PRINTS INDIVIDUAL GROUPINGS OF DATA
    //==============================================================================
    System.out.println("\n=========================================");
    System.out.println("=====            Project            =====");
    System.out.println("=========================================");
    System.out.println("\nDESCRIPTION: " + currentProject.getsDescription());
    System.out.println("PROJECT MANAGER: " + currentProject.getsProjectManager());
    System.out.println("TEAM MEMBERS: ");
    for(int i = 0; i < currentProject.getiMemberCount(); i++)
        System.out.println(members[i]);
    System.out.println("RISKS: ");
    while(iterate.hasNext())
    {
        temp = iterate.next();
        System.out.println("Description: " + temp.getsDescription());
        System.out.println("Status: " + temp.getsStatus());
        System.out.println();
    }
    System.out.println("FUNCTIONAL REQUIREMENTS:");
    while(funIt.hasNext())
    {
      tempF = funIt.next();
      PrintRequirement(tempF);
    }
    System.out.println("NON-FUNCTIONAL REQUIREMENTS:");
    while(nonIt.hasNext())
    {
      tempF = nonIt.next();
      PrintRequirement(tempF);
    }
    System.out.println("TOTAL TIME SPENT: " + currentProject.getTotalTime());
    System.out.println("Requirements analysis: " + currentProject.getRATime());
    System.out.println("Design: " + currentProject.getDTime());
    System.out.println("Coding: " + currentProject.getCTime());
    System.out.println("Testing: " + currentProject.getTTime());
    System.out.println("Project Management: " + currentProject.getTTime());
    System.out.println("\n=========================================");

  }

  //==============================================================================
  // SWITCH STATEMENT FOR ENTERED IN MENU SELECTION
  //==============================================================================
  private static void ChooseOption(String chosen, SoftwareProject currentProject, Scanner scan)
  {
        switch(chosen)
        {
          case "1": System.out.println("\nEnter name of Team Member: ");
                  currentProject.addTeamMember(scan.nextLine());
                  break;
          case "2": System.out.println("\nEnter Risk description.");
                  String riskDesc = scan.nextLine();
                  System.out.println("\nEnter Risk Status");
                  String riskStat = scan.nextLine();
                  currentProject.addRisk(new Risk(riskDesc, riskStat));
                  break;
          case "3": CreateRequirement(true, currentProject, scan);
                  break;
          case "4": CreateRequirement(false, currentProject, scan);
                  break;
          case "5": System.out.println("\nEnter New Project Description.");
                  currentProject.setsDescription(scan.nextLine());
                  break;
          case "6": System.out.println("\nEnter Name of New Project Manager.");
                  currentProject.setsProjectManager(scan.nextLine());
                  break;
          case "7": RecordTime(currentProject, scan);
                  break;
          case "8": System.exit(0);
          default: System.out.println("\nInvalid Selection.");
                  break;
        }
  }

  //==============================================================================
  // ADDS REQUIREMENT TO CURRENT PROJECT
  //==============================================================================
  private static void CreateRequirement(boolean functional, SoftwareProject currentProject, Scanner scan)
  {
    String description;
    String name;

    System.out.println("\nEnter Requirement Description.");
    description = scan.nextLine();
    System.out.println("Enter Requirement Name.");
    name = scan.nextLine();
    currentProject.addRequirement(new Requirement(functional, name, description));
    RecordTime(currentProject, scan);
    System.out.println("Requirement created.");

  }

  //==============================================================================
  // USED FOR PRINTING EACH REQUIREMENTS DATA
  //==============================================================================
  private static void PrintRequirement(Requirement req)
  {
    System.out.println("Functional: " + req.getFunctional());
    System.out.println("Description: " + req.getDescription());
    System.out.println("Name: " + req.getName());
    System.out.println();
  }

  //==============================================================================
  // ADDS TIME TO THE CURRENT PROJECT
  //==============================================================================
  private static void RecordTime(SoftwareProject currentProject, Scanner scan)
  {
    System.out.println("Enter the number of hours spent on Requirements Analysis.");
    currentProject.addRATime(scan.nextDouble());
    System.out.println("Enter the number of hours spent on Designing.");
    currentProject.addDTime(scan.nextDouble());
    System.out.println("Enter the number of hours spent on Coding.");
    currentProject.addCTime(scan.nextDouble());
    System.out.println("Enter the number of hours spent on Testing.");
    currentProject.addTTime(scan.nextDouble());
    System.out.println("Enter the number of hours spent on Project Management.");
    currentProject.addPMTime(scan.nextDouble());
  }

}
