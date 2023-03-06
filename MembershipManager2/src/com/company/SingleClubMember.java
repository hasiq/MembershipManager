package com.company;

public class SingleClubMember extends Member
{
    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub)
    {
        super(pMemberType, pMemberID, pName, pFees);
        this.club = pClub;
    }

    public void setClub(int club1)
    {
        this.club = club1;
    }

    public int getClub()
    {
        return club;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", " + club ;
    }

}
