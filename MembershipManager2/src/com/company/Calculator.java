package com.company;

public interface Calculator<T extends Number>
{
    public double calculateFees(T clubID);

}
