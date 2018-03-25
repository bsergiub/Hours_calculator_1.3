/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hours_calculator;

/**
 *
 * @author Sergiu Borlovan
 */

public class CoreCalc {
    private static int DS = 12;
    private static int ND = 12;
    private static int SI = 16;
    private static int topUp = 8;
    private static int hols = 7;
    private static double contractHrs = 151.5;
    private static double hourlyRate = 7.50;
    private static double topUpRate = 7.50;
    private static double sleepInRate = 29.95;
    
    public static double getSleepInRate() {
        return sleepInRate;
    }

    public static void setSleepInRate(double sleepInRate) {
        CoreCalc.sleepInRate = sleepInRate;
    }

    public static double getOnCallRate() {
        return onCallRate;
    }

    public static void setOnCallRate(double onCallRate) {
        CoreCalc.onCallRate = onCallRate;
    }
    private static double onCallRate = 9.95;

    
    public static double getContractHrs() {
        return contractHrs;
    }

    public static void setContractHrs(double contractHrs) {
        CoreCalc.contractHrs = contractHrs;
    }

    public static double getHourlyRate() {
        return hourlyRate;
    }

    public static void setHourlyRate(double hourlyRate) {
        CoreCalc.hourlyRate = hourlyRate;
    }

    public static double getTopUpRate() {
        return topUpRate;
    }

    public static void setTopUpRate(double topUpRate) {
        CoreCalc.topUpRate = topUpRate;
    }

    
    public int getDS() {
        return DS;
    }

    public void setDS(int DS) {
        this.DS = DS;
    }

    public int getND() {
        return ND;
    }

    public void setND(int ND) {
        this.ND = ND;
    }

    public int getSI() {
        return SI;
    }

    public void setSI(int SI) {
        this.SI = SI;
    }

    public int getHols() {
        return hols;
    }

    public void setHols(int hols) {
        this.hols = hols;
    }
    
    public int calculateDS(String num){
       int amount = this.checkNum(num);
       return amount * DS;
    }
    
    public int calculateND(String num){
       int amount = this.checkNum(num);
       return amount * ND;   
    }
    
    public int calculateSI(String num){
       int amount = this.checkNum(num);
       return amount * SI;   
    }
    
    public int calculateTopUp(String num){
       int amount = this.checkNum(num);
       return amount * topUp; 
    }
    public int calculateOnCall(String num){
       int amount = this.checkNum(num);
       return amount;
    }
    public double calculateAddHrs(String num){
       double amount = this.checkNum(num);
       return amount;
    }
    public int calculateHols(String num){
        int amount = this.checkNum(num);
        return amount * hols;
    }
    public double calculateOvertime(double num){
        if (num <= contractHrs){
            return 0;
        }
        else{
            return num - contractHrs;
        }
    }
    
    public double calculatePay(double totalHours, int totalSI, int totalOC, double topUp){
        double totalHoursPay = totalHours * hourlyRate;
        double totalSIPay = totalSI * sleepInRate;
        double totalOCPay = totalOC * onCallRate;
        double totalTopUp = topUp * topUpRate;
        double finalTopUp = totalTopUp - totalSIPay;
        
        double totalPay = totalHoursPay + totalSIPay + totalOCPay + finalTopUp;
        return totalPay;
    }
    public int checkNum(String num){
        if (num.isEmpty()){
            return 0;
        }
        else{
            return Integer.parseInt(num);
        }
    }
}
