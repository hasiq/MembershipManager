package com.company;

public class MultiClubMember extends Member
{
    private int membershipPoints;

    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints)
    {
        super(pMemberType, pMemberID, pName, pFees);
        this.membershipPoints = pMembershipPoints;
    }

    public int getMembershipPoints()
    {
        return this.membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints)
    {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString()
    {
      return super.toString() + ", " + membershipPoints;
    }
}
