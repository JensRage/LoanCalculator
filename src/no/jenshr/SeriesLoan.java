package no.jenshr;

import java.util.ArrayList;

public class SeriesLoan extends Loan{
    private double Interest = 0.035;
    private int Amount;
    private short PaybackYears;

    public SeriesLoan(int amount, short paybackYears) {
        Amount = amount;
        PaybackYears = paybackYears;
    }

    @Override
    public String toString() {
        return "SeriesLoan{" +
                "Interest=" + Interest +
                ", Amount=" + Amount +
                ", PaybackYears=" + PaybackYears +
                '}';
    }

    public ArrayList<Double> calculateYearlyPaymentPlan(){
        ArrayList<Double> result = new ArrayList<>();

        int installment = Amount / PaybackYears;
        int priceLeft = Amount;
        int payedTotal = 0;

        for (int i=0; i < PaybackYears; i++){
            double payThisYear = installment + priceLeft * Interest;
            priceLeft -= installment;
            payedTotal += payThisYear;

            result.add(payThisYear);
        }

        return result;
    }

    @Override
    ArrayList<Double> calculateMonthlyPaymentPlan() {
        ArrayList<Double> result = new ArrayList<>();

        int paybackMonths = PaybackYears * 12;

        int installment = Amount / paybackMonths;
        int priceLeft = Amount;
        int payedTotal = 0;

        for (int i=0; i < paybackMonths; i++){
            double payThisYear = installment + priceLeft * Interest;
            priceLeft -= installment;
            payedTotal += payThisYear;

            result.add(payThisYear);
        }

        return result;
    }
}
