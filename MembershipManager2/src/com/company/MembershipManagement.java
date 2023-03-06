package com.company;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement
{
    final private Scanner reader  = new Scanner(System.in);

    private int getIntInput()
    {
        int choice = 0;
        while (choice == 0)
        {
            try
            {
                choice = reader.nextInt();
                if(choice == 0)
                    throw new InputMismatchException();
                reader.nextLine();
            }
            catch (InputMismatchException e)
            {
                reader.nextLine();
                System.err.println("ERROR: INVALID INPUT. Please try again");
            }

        }
     return choice;
    }

    private void printClubOptions()
    {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice()
    {
        int choice;

        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("=================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("Please select an option (or Enter -1 to quit)");

        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m)
    {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.println("Enter the member's name");
        name = reader.nextLine();
        printClubOptions();
        System.out.println("Enter the club ID");
        club = getIntInput();
        while (club < 1 || club > 4  )
        {
            System.out.println("Not a valid value");
            System.out.println("Enter a new value");
            club = getIntInput();
        }
        if(m.size() > 0)
            memberID = m.getLast().getMemberID() + 1;
        else
            memberID = 1;

        if(club != 4)
        {
            cal = (n) ->
            {
             switch (n)
             {
                 case 1:
                     return 900;
                 case 2:
                     return 950;
                 case 3:
                     return 1000;
                 default:
                     return -1;
             }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Single Club Member added\n");
        }
        else
        {
            cal = (n) ->
            {
                switch (n)
                {
                    case 4:
                        return 1200;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Multi Club Member added\n");
        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m)
    {
        int memberID;
        System.out.println("Enter the member ID");
        memberID = getIntInput();
        for(int i = 0; i < m.size(); i++)
        {
            if(memberID == m.get(i).getMemberID())
            {
                m.remove(i);
                System.out.println("User has been removed");
                return;
            }
        }
        System.out.println("Member ID is not found");
    }

    public void printMemberInfo(LinkedList<Member> m)
    {
        int memberID;
        System.out.println("Enter the member ID");
        memberID = getIntInput();
        for (int i = 0; i < m.size(); i++)
        {
            if(memberID == m.get(i).getMemberID())
            {
                String[] memberInfo = m.get(i).toString().split(", ");
                if(memberInfo[0].equals("S"))
                {
                    System.out.println("Member Type = S");
                    System.out.println("Member ID = " +memberInfo[1]);
                    System.out.println("Member ID = " +memberInfo[2]);
                    System.out.println("Member ID = " +memberInfo[3]);
                    System.out.println("Member ID = " +memberInfo[4]);
                }
                else
                {
                    System.out.println("Member Type = M");
                    System.out.println("Member ID = " +memberInfo[1]);
                    System.out.println("Member ID = " +memberInfo[2]);
                    System.out.println("Member ID = " +memberInfo[3]);
                    System.out.println("Member ID = " +memberInfo[4]);
                }
            }
        }
    }


}
